package ru.nsu.ccfit.resync.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.nsu.ccfit.resync.Activator;
import ru.nsu.ccfit.resync.pref.SimplePreferenceSynchronizer;
import ru.nsu.ccfit.resync.storage.PreferenceStorage;

public class ResyncDialog extends Dialog {
    private static final String SYNCHRONIZE_BUTTON_CONTENT = "Synchronize";
    private static final String UPLOAD_BUTTON_CONTENT = "Upload";
    private static final String URL_LABLE_CONTENT = "Url:";
    private static final int NUM_COLUMNS = 2;
    private static final int URL_LIST_WIDTH_HINT = 300;
    private static final int URL_LIST_HEIGHT_HINT = 200;
    private static final int ERROR_LABLE_X_HINT = 150;
    private Shell parent;
    private Url url = new Url();
    private IStatus currentStatus;

    public ResyncDialog(Shell parent) {
        super(parent);
        this.parent = parent;
    }

    public int open() {
        Shell shell = new Shell(parent);
        createContents(shell);
        shell.pack();
        shell.open();
        Display display = parent.getDisplay();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        return 1;
    }

    private void createContents(final Shell shell) {
        shell.setLayout(new GridLayout(NUM_COLUMNS, true));

        Label label = new Label(shell, SWT.NONE);
        label.setText(URL_LABLE_CONTENT);
        GridData data = new GridData(GridData.FILL_HORIZONTAL);
        label.setLayoutData(data);

        final Text urlText = new Text(shell, SWT.BORDER);
        data = new GridData(GridData.FILL_HORIZONTAL);
        urlText.setLayoutData(data);
        ControlDecoration urlTextDecoration = createControlDecoration(urlText, "Please, enter valid Url");

        new Label(shell, SWT.NONE).setText("Validation Error:");

        Label validationErrorLabel = new Label(shell, SWT.NONE);
        validationErrorLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        GridDataFactory.swtDefaults().hint(ERROR_LABLE_X_HINT, SWT.DEFAULT).applyTo(validationErrorLabel);

        final DataBindingContext dataBindingContext = new DataBindingContext();

        dataBindingContext.bindValue(SWTObservables.observeText(urlText, SWT.Modify), PojoObservables.observeValue(url,
                "url"), new UpdateValueStrategy().setAfterConvertValidator(new UrlValidator("Please enter valid Url",
                urlTextDecoration)), null);

        final AggregateValidationStatus aggregateValidationStatus = new AggregateValidationStatus(
                dataBindingContext.getBindings(), AggregateValidationStatus.MAX_SEVERITY);

        aggregateValidationStatus.addValueChangeListener(new IValueChangeListener() {

            @Override
            public void handleValueChange(ValueChangeEvent event) {
                currentStatus = (IStatus) event.diff.getNewValue();
            }
        });

        dataBindingContext.bindValue(SWTObservables.observeText(validationErrorLabel), aggregateValidationStatus, null,
                null);

        data = new GridData(GridData.FILL_HORIZONTAL);
        data.horizontalSpan = 2;
        data.heightHint = URL_LIST_HEIGHT_HINT;
        data.widthHint = URL_LIST_WIDTH_HINT;
        final List urlList = new List(shell, SWT.H_SCROLL | SWT.V_SCROLL);
        urlList.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                urlText.setText(urlList.getSelection()[0]);
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {

            }
        });
        urlList.setLayoutData(data);
        urlList.add("file://C:\\example.properties");
        urlList.add("file://C:\\example.properties");
        urlList.add("file://localhost/c:/Users/Mike/Desktop/Resync/demo");
        urlList.add("https://gist.github.com/617e1ebee5e3cf325a87");
        urlList.add("file://C:\\example.properties");
        urlList.add("file://C:\\example.properties");
        urlList.add("file://C:\\example.properties");
        urlList.add("file://C:\\example.properties");
        urlList.add("hello");
        urlList.add("");

        Button synchronize = new Button(shell, SWT.PUSH);
        synchronize.setText(SYNCHRONIZE_BUTTON_CONTENT);
        data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
        synchronize.setLayoutData(data);
        synchronize.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                if (currentStatus.isOK()) {
                    URL location = null;
                    try {
                        location = new URL(url.getUrl());
                    } catch (MalformedURLException e) {
                        Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
                        ErrorDialog.openError(shell, "Error", e.getMessage(), status);
                    }
                    try {
                        PreferencesStorageUtils utils = new PreferencesStorageUtils();

                        // TODO: options == null?
                        PreferenceStorage storage = utils.getFactory(location).open(location, null);
                        storage.pull();
                        SimplePreferenceSynchronizer.synchronize(storage);
                        shell.close();
                    } catch (Exception e) {
                        Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
                        ErrorDialog.openError(shell, "Error", e.getMessage(), status);
                    }
                } else {
                    urlText.setFocus();
                }
            }
        });

        Button upload = new Button(shell, SWT.PUSH);
        upload.setText(UPLOAD_BUTTON_CONTENT);
        data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
        upload.setLayoutData(data);
        upload.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                if (currentStatus.isOK()) {
                    URL location = null;
                    try {
                        location = new URL(url.getUrl());
                    } catch (MalformedURLException e) {
                        Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
                        ErrorDialog.openError(shell, "Error", e.getMessage(), status);
                    }
                    PreferencesStorageUtils utils = new PreferencesStorageUtils();
                    try {
                        PreferenceStorage storage = utils.getWritableStorage(location);
                        SimplePreferenceSynchronizer.exportToStorage(storage);
                        // TODO: Hasn't implementation for preferences putting
                        storage.push();
                    } catch (Exception e) {
                        Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
                        ErrorDialog.openError(shell, "Error", e.getMessage(), status);
                    }
                } else {
                    urlText.setFocus();
                }
            }
        });
        shell.setDefaultButton(synchronize);
    }

    private static ControlDecoration createControlDecoration(Control control, String hoverText) {
        ControlDecoration controlDecoration = new ControlDecoration(control, SWT.LEFT | SWT.TOP);
        controlDecoration.setDescriptionText(hoverText);
        FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault().getFieldDecoration(
                FieldDecorationRegistry.DEC_ERROR);
        controlDecoration.setImage(fieldDecoration.getImage());
        return controlDecoration;
    }
}

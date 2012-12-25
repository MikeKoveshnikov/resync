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
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.nsu.ccfit.resync.Activator;
import ru.nsu.ccfit.resync.pref.SimplePreferenceSynchronizer;
import ru.nsu.ccfit.resync.storage.PreferenceStorage;

public class ResyncDialog extends TitleAreaDialog {
	private static final String TITLE = "Synchronize";
	private static final String MESSAGE = "Synchronize your preferences";
	private static final String SYNCHRONIZE_BUTTON_CONTENT = "Synchronize";
	private static final String UPLOAD_BUTTON_CONTENT = "Upload";
	private static final String URL_LABLE_CONTENT = "Url:";
	private static final int NUM_COLUMNS = 2;
	private static final int URL_LIST_WIDTH_HINT = 300;
	private static final int URL_LIST_HEIGHT_HINT = 200;
	private static final int ERROR_LABLE_X_HINT = 150;
	private static final int LIST_COLUMN_SPAN = 2;
	private static final int MARGIN = 10;
	private static final RGB RGB_RED = new RGB(255, 0, 0);
    private Shell parent;
    private Url url = new Url();
    private IStatus currentStatus;
    private Text urlText = null;
    
    public ResyncDialog(Shell parent) {
        super(parent);
	    this.parent = parent;
	    
	}

    private void createMyContents(final Composite parent) {
    	parent.getShell().setImage(getDefaultImage());
    	parent.getShell().setText(TITLE);
	    
    	GridLayout layout = new GridLayout();
        layout.numColumns = NUM_COLUMNS;
        layout.marginWidth = MARGIN;
        layout.marginHeight = MARGIN;
        
        parent.setLayout(layout);

        GridData gridData = new GridData();
        gridData.grabExcessHorizontalSpace = true;
        gridData.horizontalAlignment = GridData.FILL;

	    Label label = new Label(parent, SWT.NONE);
	    label.setText(URL_LABLE_CONTENT);
	    
	    urlText = new Text(parent, SWT.BORDER);
	    urlText.setLayoutData(gridData);
	    ControlDecoration urlTextDecoration = createControlDecoration(urlText, "Please, enter valid Url");

	    new Label(parent, SWT.NONE);

        final Label validationErrorLabel = new Label(parent, SWT.NONE);
        validationErrorLabel.setForeground(new Color(null, RGB_RED));
        validationErrorLabel.setLayoutData(gridData);
        
        GridDataFactory.swtDefaults().hint(ERROR_LABLE_X_HINT, SWT.DEFAULT).applyTo(validationErrorLabel);

        final DataBindingContext dataBindingContext = new DataBindingContext();

        dataBindingContext.bindValue(
                SWTObservables.observeText(urlText, SWT.Modify), 
                PojoObservables.observeValue(url, "url"),
                new UpdateValueStrategy().setAfterConvertValidator(
                		new UrlValidator("Please enter valid Url", urlTextDecoration)),
                null);

        final AggregateValidationStatus aggregateValidationStatus = new AggregateValidationStatus(
        		dataBindingContext.getBindings(),
        		AggregateValidationStatus.MAX_SEVERITY);
        
        aggregateValidationStatus.addValueChangeListener(new IValueChangeListener() {
			
			@Override
			public void handleValueChange(ValueChangeEvent event) {
				currentStatus = (IStatus) event.diff.getNewValue();
				if (currentStatus.isOK()) {
					validationErrorLabel.setVisible(false);
				} else {
					validationErrorLabel.setVisible(true);
				}
			}
		});

        dataBindingContext.bindValue(SWTObservables
        		.observeText(validationErrorLabel), aggregateValidationStatus, null, null);
      
        gridData = new GridData(GridData.FILL_HORIZONTAL);
        gridData.horizontalSpan = LIST_COLUMN_SPAN;
        gridData.heightHint = URL_LIST_HEIGHT_HINT;
        gridData.widthHint = URL_LIST_WIDTH_HINT;
	    final List urlList = new List(parent, SWT.H_SCROLL | SWT.V_SCROLL);
	    urlList.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				urlText.setText(urlList.getSelection()[0]);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
	    urlList.setLayoutData(gridData);
	    urlList.add("file://C:\\example.properties");
	    urlList.add("file://C:\\example.properties");
	    urlList.add("file://C:\\example.properties");
	    urlList.add("file://C:\\example.properties");
	    urlList.add("file://C:\\example.properties");
	    urlList.add("file://C:\\example.properties");
	    urlList.add("file://C:\\example.properties");
	    urlList.add("file://C:\\example.properties");
	    urlList.add("file://C:\\example.properties");
	    urlList.add("file://C:\\example.properties");
	    urlList.add("file://C:\\example.properties");
	    urlList.add("file://C:\\example.properties");
	    urlList.add("file://C:\\example.properties");
	    urlList.add("file://C:\\example.properties");
	    urlList.add("file://C:\\example.properties");
	    urlList.add("file://C:\\example.properties");
	    
	    new Label(parent, SWT.NONE);
    }

    private static ControlDecoration createControlDecoration(Control control, String hoverText) {
        ControlDecoration controlDecoration = new ControlDecoration(control, SWT.LEFT | SWT.TOP);
        controlDecoration.setDescriptionText(hoverText);
	    FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault()
	    		.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
	    controlDecoration.setImage(fieldDecoration.getImage());
	    return controlDecoration;
	}
    
    private void showErrorDialog(Shell shell, Exception e) {
    	Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
    	ErrorDialog.openError(shell, "Error", e.getMessage(), status);
    }
    
    protected void initializeBounds(Shell shell) {
        Rectangle bounds = parent.getBounds();
        Rectangle rect = shell.getBounds();
        int x = bounds.x + (bounds.width - rect.width) / 2;
        int y = bounds.y + (bounds.height - rect.height) / 2;
        shell.setLocation(x, y);
   }
        
    @Override
    public void create() {
      super.create();
      setTitle(TITLE);
      setMessage(MESSAGE, IMessageProvider.INFORMATION);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
    	createMyContents(parent);
      return parent;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
    	GridData gridData = new GridData();
        gridData.verticalAlignment = GridData.END;
        gridData.grabExcessHorizontalSpace = true;
        gridData.grabExcessVerticalSpace = true;
        gridData.horizontalAlignment = SWT.RIGHT;

        parent.setLayoutData(gridData);
        createSynchronizeButton(parent, OK, SYNCHRONIZE_BUTTON_CONTENT, true);
        createUploadButton(parent, OK, UPLOAD_BUTTON_CONTENT, true);
    }
    
    protected Button createSynchronizeButton(final Composite parent, int id, String label, boolean defaultButton) {
        ((GridLayout) parent.getLayout()).numColumns++;
        Button button = new Button(parent, SWT.PUSH);
        button.setText(label);
        button.setFont(JFaceResources.getDialogFont());
        button.setData(new Integer(id));
        button.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                if (currentStatus.isOK()) {
                    URL location = null;
                    try {
                        location = new URL(url.getUrl());
                    } catch (MalformedURLException e) {
                        showErrorDialog(parent.getShell(), e);
                    }
                    PreferencesStorageUtils utils = new PreferencesStorageUtils();
                    try {
                        PreferenceStorage storage = utils.getWritableStorage(location);
                        //TODO: Hasn't implementation for preferences putting
                        storage.push();
                    } catch (Exception e) {
                        showErrorDialog(parent.getShell(), e);
                    }
                } else {
                     urlText.setFocus();
                }  
            }
        });
        if (defaultButton) {
            Shell shell = parent.getShell();
             if (shell != null) {
                 shell.setDefaultButton(button);
             }
        }
        setButtonLayoutData(button);
    	return button;
    }
    
    protected Button createUploadButton(final Composite parent, int id, String label, boolean defaultButton) {
        ((GridLayout) parent.getLayout()).numColumns++;
	    Button button = new Button(parent, SWT.PUSH);
	    button.setText(label);
	    button.setFont(JFaceResources.getDialogFont());
	    button.setData(new Integer(id));
	    button.addSelectionListener(new SelectionAdapter() {
	        public void widgetSelected(SelectionEvent event) {
	    	    if (currentStatus.isOK()) {
	    		    URL location = null;
	  			    try {
	  			        location = new URL(url.getUrl());
	  			    } catch (MalformedURLException e) {
	  			    	showErrorDialog(parent.getShell(), e);
	  			    }
	    		    try {
	    			    PreferencesStorageUtils utils = new PreferencesStorageUtils();
	    			    PreferenceStorage storage = utils.getFactory(location).open(location, null);
	    			    storage.pull();
	    			    SimplePreferenceSynchronizer.synchronize(storage);
	    			    close();
	    		    } catch (Exception e) {
	    		    	showErrorDialog(parent.getShell(), e);
				    }	                
	    	    } else {
   	    	        urlText.setFocus();
	    	    }
	        }
	    });
	    if (defaultButton) {
	      Shell shell = parent.getShell();
	      if (shell != null) {
	        shell.setDefaultButton(button);
	      }
	    }
	    setButtonLayoutData(button);
	    return button;
    }
}

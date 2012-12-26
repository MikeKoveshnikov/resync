package ru.nsu.ccfit.resync.pref.jdt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;

import ru.nsu.ccfit.resync.pref.Preference;
import ru.nsu.ccfit.resync.pref.PreferenceProvider;
import ru.nsu.ccfit.resync.storage.PreferenceStorage;

public abstract class AbstractPreferenceProvider implements PreferenceProvider {

    abstract protected Iterable<String> getOptions();

    abstract protected String getPrefix();

    abstract protected String getBundle();

    @Override
    public Collection<Preference> getPreferences(PreferenceStorage storage) {
        List<Preference> preferences = new ArrayList<Preference>();
        String prefix = getPrefix();
        String bundle = getBundle();

        for (String option : getOptions()) {
            String value = storage.get(option, null);
            String key = option.substring(prefix.length());

            if (value != null) {
                preferences.add(Preference.newInstance(bundle, key, value));
            }
        }

        return preferences;
    }

    @Override
    public Collection<Preference> exportPreferences() {
        List<Preference> exportedPreferences = new ArrayList<Preference>();
        IPreferencesService preferencesService = Platform.getPreferencesService();
        String prefix = getPrefix();
        String bundle = getBundle();

        for (String option : getOptions()) {
            String partialKey = option.substring(prefix.length());
            String value = preferencesService.getString(bundle, partialKey, null, null);

            String key = option;
            if (value != null && value.length() != 0) {
                exportedPreferences.add(Preference.newInstance(bundle, key, value));
            }
        }
        return exportedPreferences;
    }
}

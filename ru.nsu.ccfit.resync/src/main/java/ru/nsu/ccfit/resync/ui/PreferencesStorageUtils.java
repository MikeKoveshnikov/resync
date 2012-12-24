package ru.nsu.ccfit.resync.ui;

import java.net.URL;
import java.util.ArrayList;

import ru.nsu.ccfit.resync.storage.PreferenceStorage;
import ru.nsu.ccfit.resync.storage.PreferenceStorageException;
import ru.nsu.ccfit.resync.storage.PreferenceStorageFactory;
import ru.nsu.ccfit.resync.storage.disk.DiskStorageFactory;
import ru.nsu.ccfit.resync.storage.github.GithubStorageFactory;
import ru.nsu.ccfit.resync.storage.github.WritableGithubStorageFactory;

public class PreferencesStorageUtils {
    private static ArrayList<PreferenceStorageFactory> factories;

    public PreferencesStorageUtils() {
        factories = new ArrayList<PreferenceStorageFactory>();
    	factories.add(new DiskStorageFactory());
    	factories.add(new GithubStorageFactory());
    	factories.add(new WritableGithubStorageFactory());
    }
    
    public PreferenceStorageFactory getFactory(URL url) {
		for (PreferenceStorageFactory factory : factories) {
			if (factory.canOpen(url)) {
				return factory;
			}
		}
		return null;
	}
    
    public PreferenceStorage getWritableStorage(URL url) throws PreferenceStorageException {
		for (PreferenceStorageFactory factory : factories) {
			if (factory.canOpen(url)) {
				PreferenceStorage storage = factory.open(url, null);
				if (storage.canWrite()) {
					return storage;
				}
			}
		}
		return null;
	}
}
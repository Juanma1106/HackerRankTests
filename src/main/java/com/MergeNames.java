package com;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class MergeNames {

	public static String[] uniqueNames(String[] names1, String[] names2) {
		Set<String> names = new HashSet<>();
		for (int i = 0; i < names1.length; i++) {
			names.add(names1[i]);
		}
		for (int i = 0; i < names2.length; i++) {
			names.add(names2[i]);
		}
		String[] myArray = new String[names.size()];
		return names.toArray(myArray);
	}

	public static void main(String[] args) {
		String[] names1 = new String[] { "Ava", "Emma", "Olivia" };
		String[] names2 = new String[] { "Olivia", "Sophia", "Emma" };
		System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma,
																						// Olivia, Sophia
	}
}

class AlertService {

	private final AlertDAO storage;

	public AlertService(AlertDAO storage) {
		this.storage = storage;
	}

	public UUID raiseAlert() {
		return this.storage.addAlert(new Date());
	}

	public Date getAlertTime(UUID id) {
		return this.storage.getAlert(id);
	}
}

interface AlertDAO {

	public UUID addAlert(Date time);

	public Date getAlert(UUID id);
}

class MapAlertDAO implements AlertDAO {

	private final Map<UUID, Date> alerts = new HashMap<UUID, Date>();

	public UUID addAlert(Date time) {
		UUID id = UUID.randomUUID();
		this.alerts.put(id, time);
		return id;
	}

	public Date getAlert(UUID id) {
		return this.alerts.get(id);
	}
}
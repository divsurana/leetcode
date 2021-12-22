/**
 * 
 */
package org.oop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author divyeshsurana
 *
 */
public class AmazonLocker {

	LockerManager lockerManager;
	Locker locker;

	public AmazonLocker(UUID managerId, LockerType type, UUID productCatalogId) {
		lockerManager = new LockerManager(managerId);
		locker = lockerManager.getSingleEmptyLockerBytype(type);
		lockerManager.fillLocker(locker, productCatalogId);
	}

	// User Requests
	public List<LockerManager> showMeLockers(String userAddress) {
		// we use the address to list down top 10 nearest locker managers to the
		// users. We can use Trie to implement this. Can use ZipCode or general
		// address to navigate in the Trie.
		// once a user selects Locker Manager, we get locker Manager Id.
		// We initialize this locker Manager with Id or can use this Id to
		// communicate with the locker manager.
		return null;
	}

	// Design Locker Type
	public enum LockerType {

		X_Small("X_Small"), Small("Small"), Medium("Medium"), Large("Large"), X_Large("X_Large");

		public final String label;

		LockerType(String label) {
			this.label = label;
		}

		public String getValue() {
			return this.label;
		}

		public static LockerType getEnum(String label) {
			switch (label) {
			case "X_Small":
				return LockerType.X_Small;
			case "Small":
				return LockerType.Small;
			case "Medium":
				return LockerType.Medium;
			case "Large":
				return LockerType.Large;
			case "X_Large":
				return LockerType.X_Large;
			default:
				return LockerType.Medium;
			}
		}
	}

	// Design Locker Class
	public class Locker {
		public UUID lockerId;
		public LockerType type;
		public int localId;

		public Locker(UUID id, LockerType type) {
			lockerId = id;
			this.type = type;
		}

		public Locker(UUID id, LockerType type, int localId) {
			this.lockerId = id;
			this.type = type;
			this.localId = localId;
		}
	}

	// Design Locker Manager
	public class LockerManager {
		private UUID lockerManagerId;
		private Map<Locker, UUID> lockers;
		public String lockerAddress;
		private static LockerManager manager;

		private LockerManager(UUID managerId) {
			lockerManagerId = managerId;
			lockers = getLockersByManager(managerId);
			lockerAddress = getLockerManagerAddress(managerId);
		}

		public LockerManager getInstance(UUID managerId) {
			if (manager == null) {
				manager = new LockerManager(managerId);
			}
			if (managerId != lockerManagerId) {
				throw new IllegalArgumentException("Invalid value Exception");
			}
			return manager;
		}

		public List<Locker> getEmptyLockers() {
			return lockers.entrySet().stream().filter(x -> x.getValue() == null).map(x -> x.getKey())
					.collect(Collectors.toList());
		}

		public Locker getSingleEmptyLockerBytype(LockerType type) {
			return lockers.entrySet().stream().filter(x -> x.getValue() == null && type.equals(x.getKey().type))
					.map(x -> x.getKey()).findFirst().get();
		}

		public boolean emptyLocker(UUID lockerId) {
			Locker locker = lockers.entrySet().stream().filter(x -> x.getKey().lockerId == lockerId)
					.map(x -> x.getKey()).findFirst().get();
			return this.emptyLocker(locker);
		}

		public boolean emptyLockerByProduct(UUID productCatalogId) {
			Locker locker = lockers.entrySet().stream().filter(x -> x.getValue() == productCatalogId)
					.map(x -> x.getKey()).findFirst().get();
			return this.emptyLocker(locker);
		}

		public boolean emptyLocker(Locker locker) {
			if (locker != null && lockers.containsKey(locker)) {
				lockers.put(locker, null);
				return true;
			}
			return false;
		}

		public boolean fillLocker(Locker locker, UUID productCatalogId) {
			if (locker != null && lockers.containsKey(locker) && lockers.get(locker) == null) {
				lockers.put(locker, productCatalogId);
				return true;
			}
			return false;
		}

		private Map<Locker, UUID> getLockersByManager(UUID managerId) {
			Map<Locker, UUID> lockers = new HashMap<>();
			List<String[]> rowSets = getLockersDetails(managerId);
			for (String[] row : rowSets) {
				UUID lockerId = UUID.randomUUID();
				lockers.put(new Locker(UUID.randomUUID(), LockerType.getEnum(row[1]), Integer.parseInt(row[2])),
						lockerId);
			}
			return lockers;
		}

		private List<String[]> getLockersDetails(UUID managerId) {
			// TODO Auto-generated method stub
			return null;
		}

		private String getLockerManagerAddress(UUID managerId) {
			// TODO Auto-generated method stub
			return null;
		}
	}

}

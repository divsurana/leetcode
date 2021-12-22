/**
 * 
 */
package org.oop;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author divyeshsurana
 *
 */
public abstract class AbstractAmazonLocker {
	LockerManager lockerManager;
	Locker locker;

	public AbstractAmazonLocker(UUID managerId, LockerType type, UUID productCatalogId) {
		lockerManager = LockerManager.getInstance(managerId);
		locker = lockerManager.getSingleEmptyLockerBytype(type);
		lockerManager.fillLocker(locker, productCatalogId);
	}

	public abstract List<LockerManager> showMeLockers(String userAddress);

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
	public abstract class LockerManager {
		private UUID lockerManagerId;
		private Map<Locker, UUID> lockers;
		public String lockerAddress;
		private LockerManager manager;

		private LockerManager(UUID managerId) {
			this.lockerManagerId = managerId;
			this.lockers = getLockersByManager(managerId);
			this.lockerAddress = getLockerManagerAddress(managerId);
		}

		public LockerManager getInstance(UUID managerId) {
			if (this.manager == null) {
				this.manager = getManager(managerId);
			}
			if (managerId != lockerManagerId) {
				throw new IllegalArgumentException("Invalid value Exception");
			}
			return this.manager;
		}

		public abstract LockerManager getManager(UUID managerId);

		public abstract List<Locker> getEmptyLockers();

		public abstract Locker getSingleEmptyLockerBytype(LockerType type);

		public abstract boolean emptyLocker(UUID lockerId);

		public abstract boolean emptyLockerByProduct(UUID productCatalogId);

		public abstract boolean emptyLocker(Locker locker);

		public abstract boolean fillLocker(Locker locker, UUID productCatalogId);

		protected abstract Map<Locker, UUID> getLockersByManager(UUID managerId);

		protected abstract List<String[]> getLockersDetails(UUID managerId);

		protected abstract String getLockerManagerAddress(UUID managerId);
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
}

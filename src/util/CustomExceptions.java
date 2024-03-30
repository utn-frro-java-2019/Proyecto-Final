package util;

import java.io.Serializable;

public class CustomExceptions {
	
	public static class DatabaseAccessException extends RuntimeException implements Serializable {
		private static final long serialVersionUID = 5840452425932179851L;

		public DatabaseAccessException(String message) {
            super(message);
        }

		public DatabaseAccessException(String message, Throwable cause) {
			super(message, cause);
		}
    }
	
	public static class CocheraConEmpleadosException extends RuntimeException implements Serializable {
		private static final long serialVersionUID = -211214709052675116L;

		public CocheraConEmpleadosException(String message) {
            super(message);
        }

		public CocheraConEmpleadosException(String message, Throwable cause) {
			super(message, cause);
		}
    }
	
	public static class CapacidadNullException extends RuntimeException implements Serializable {
		private static final long serialVersionUID = 537769307935672166L;

		public CapacidadNullException(String message) {
            super(message);
        }

		public CapacidadNullException(String message, Throwable cause) {
			super(message, cause);
		}
    }
	
	public static class CapacidadInvalidaException extends RuntimeException implements Serializable {
		private static final long serialVersionUID = 6575455320123354232L;

		public CapacidadInvalidaException(String message) {
            super(message);
        }

		public CapacidadInvalidaException(String message, Throwable cause) {
			super(message, cause);
		}
    }

}

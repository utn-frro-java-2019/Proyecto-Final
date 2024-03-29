package util;

import java.io.Serializable;

public class CustomExceptions {
	
	public static class DatabaseAccessException extends RuntimeException implements Serializable {
        private static final long serialVersionUID = 1L;

		public DatabaseAccessException(String message) {
            super(message);
        }

		public DatabaseAccessException(String message, Throwable cause) {
			super(message, cause);
		}
    }

}

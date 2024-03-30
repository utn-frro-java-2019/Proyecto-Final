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
	
	public static class CocheraNullException extends RuntimeException implements Serializable {
		private static final long serialVersionUID = 9206785505356728565L;

		public CocheraNullException(String message) {
            super(message);
        }

		public CocheraNullException(String message, Throwable cause) {
			super(message, cause);
		}
    }
	public static class VehiculoNullException extends RuntimeException implements Serializable {
		private static final long serialVersionUID = -3437231938853899010L;

		public VehiculoNullException(String message) {
            super(message);
        }

		public VehiculoNullException(String message, Throwable cause) {
			super(message, cause);
		}
    }
	public static class VehiculoExistenteException extends RuntimeException implements Serializable {
		private static final long serialVersionUID = 6502573891487734025L;

		public VehiculoExistenteException(String message) {
            super(message);
        }

		public VehiculoExistenteException(String message, Throwable cause) {
			super(message, cause);
		}
    }
	public static class VehiculoEstacionadoException extends RuntimeException implements Serializable {
		private static final long serialVersionUID = 3543432749440589939L;

		public VehiculoEstacionadoException(String message) {
            super(message);
        }

		public VehiculoEstacionadoException(String message, Throwable cause) {
			super(message, cause);
		}
    }
	public static class LugarNullException extends RuntimeException implements Serializable {
		private static final long serialVersionUID = -3437231938853899010L;

		public LugarNullException(String message) {
            super(message);
        }

		public LugarNullException(String message, Throwable cause) {
			super(message, cause);
		}
    }
	public static class MultiplicadorInvalidoException extends RuntimeException implements Serializable {
		private static final long serialVersionUID = -7101252010564130286L;

		public MultiplicadorInvalidoException(String message) {
            super(message);
        }

		public MultiplicadorInvalidoException(String message, Throwable cause) {
			super(message, cause);
		}
    }
	public static class PorcentajeMultiplicadorInvalidoException extends RuntimeException implements Serializable {
		private static final long serialVersionUID = 714411139467892471L;

		public PorcentajeMultiplicadorInvalidoException(String message) {
            super(message);
        }

		public PorcentajeMultiplicadorInvalidoException(String message, Throwable cause) {
			super(message, cause);
		}
    }
	public static class MultiplicadorExistenteException extends RuntimeException implements Serializable {
		private static final long serialVersionUID = -7101252010564130286L;

		public MultiplicadorExistenteException(String message) {
            super(message);
        }

		public MultiplicadorExistenteException(String message, Throwable cause) {
			super(message, cause);
		}
    }
	public static class PorcentajeMultiplicadorExistenteException extends RuntimeException implements Serializable {
		private static final long serialVersionUID = 714411139467892471L;

		public PorcentajeMultiplicadorExistenteException(String message) {
            super(message);
        }

		public PorcentajeMultiplicadorExistenteException(String message, Throwable cause) {
			super(message, cause);
		}
	}
	public static class PrecioPorHoraInvalidoException extends RuntimeException implements Serializable {
		private static final long serialVersionUID = 714411139467892471L;

		public PrecioPorHoraInvalidoException(String message) {
            super(message);
        }

		public PrecioPorHoraInvalidoException(String message, Throwable cause) {
			super(message, cause);
		}
	}
	public static class EstadiaNullException extends RuntimeException implements Serializable {
		private static final long serialVersionUID = -3418618285071918130L;

		public EstadiaNullException(String message) {
            super(message);
        }

		public EstadiaNullException(String message, Throwable cause) {
			super(message, cause);
		}
    }
}

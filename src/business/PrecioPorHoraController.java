package business;

import data.PrecioPorHoraData;
import domain.PrecioPorHora;
import util.CustomExceptions.*;

public class PrecioPorHoraController {
	public static PrecioPorHora getPrecioPorHora() {
		try {
			return new PrecioPorHoraData().getPrecioPorHora();
		} catch (Exception e) {
			throw new DatabaseAccessException("Error al intentar obtener el precio por hora en la base de datos", e);
		}
	}

	public static void updatePrecioPorHora(PrecioPorHora p) {
		if (p.getPrecio() < 0) {
			throw new PrecioPorHoraInvalidoException("El precio por hora no puede ser negativo");
		} else if (p.getPrecio() == 0) {
			throw new PrecioPorHoraInvalidoException("El precio por hora debe ser mayor a 0");
		}

		try {
			new PrecioPorHoraData().updatePrecioPorHora(p);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar modificar un multiplicador en la base de datos", e);
		}
	}
}

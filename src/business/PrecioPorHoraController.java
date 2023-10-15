package business;

import data.PrecioPorHoraData;
import domain.PrecioPorHora;

public class PrecioPorHoraController {
	public static PrecioPorHora getPrecioPorHora() {
		try {
			return new PrecioPorHoraData().getPrecioPorHora();
		} catch (Exception e) {
			throw e;
		}
	}

	public static void updatePrecioPorHora(PrecioPorHora p) {
		if (p.getPrecio() < 0) {
			throw new RuntimeException("El precio por hora no puede ser negativo");
		} else if (p.getPrecio() == 0) {
			throw new RuntimeException("El precio por hora debe ser mayor a 0");
		}

		System.out.println("Precio por hora: " + p.getPrecio());

		try {
			new PrecioPorHoraData().updatePrecioPorHora(p);
		} catch (Exception e) {
			throw e;
		}
	}
}

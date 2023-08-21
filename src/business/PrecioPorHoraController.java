package business;

import data.PrecioPorHoraData;
import domain.PrecioPorHora;

public class PrecioPorHoraController {
	public static PrecioPorHora getPrecioPorHora() {
		return new PrecioPorHoraData().getPrecioPorHora();
	}

	public static void updatePrecioPorHora(PrecioPorHora p) {
		new PrecioPorHoraData().updatePrecioPorHora(p);
	}
}

package business;
import data.PrecioPorHoraData;
import domain.PrecioPorHora;

public class PrecioPorHoraController {
	public static PrecioPorHora getPrecioPorHora() {
		return new PrecioPorHoraData().getPrecioPorHora();
	}
}

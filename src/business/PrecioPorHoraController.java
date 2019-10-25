package business;
import data.PrecioPorHoraData;
import domain.PrecioPorHora;

public class PrecioPorHoraController {
	public static PrecioPorHora getPrecio() {
		return new PrecioPorHoraData().getPrecio();
	}
}

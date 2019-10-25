package business;
import java.util.ArrayList;
import data.EstadiaData;
import domain.*;

public class EstadiaController {
	
	public static Estadia getOne(int idEstadia) {
		return new EstadiaData().getOne(idEstadia);
	}

	public static ArrayList<Estadia> getAll() {
		return new EstadiaData().getAll();
	}
	
}
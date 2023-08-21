package business;

import java.util.ArrayList;
import data.TurnoData;
import domain.*;

public class TurnoController {
	public static Turno getOne(int idTurno) {
		return new TurnoData().getOne(idTurno);
	}

	public static ArrayList<Turno> getAll() {
		return new TurnoData().getAll();
	}
}

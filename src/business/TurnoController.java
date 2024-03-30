package business;

import java.util.ArrayList;
import data.TurnoData;
import domain.*;
import util.CustomExceptions.DatabaseAccessException;

public class TurnoController {
	public static Turno getOne(int idTurno) {
		try {
		return new TurnoData().getOne(idTurno);
		}
		catch(DatabaseAccessException e){
            throw new DatabaseAccessException("Error al intentar obtener un turno en la base de datos", e);
		}
	}

	public static ArrayList<Turno> getAll() {
		try {
		return new TurnoData().getAll();
		}
		catch(DatabaseAccessException e){
            throw new DatabaseAccessException("Error al intentar obtener los turnos en la base de datos", e);
		}
	}
}

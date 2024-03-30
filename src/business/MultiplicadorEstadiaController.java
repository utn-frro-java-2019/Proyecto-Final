package business;

import java.util.ArrayList;
import data.MultiplicadorEstadiaData;
import domain.*;
import util.CustomExceptions.*;

public class MultiplicadorEstadiaController {
	public static ArrayList<MultiplicadorEstadia> getAll() {
		try {
			return new MultiplicadorEstadiaData().getAll();
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar obtener un multiplicador en la base de datos", e);
		}
	}

	public static MultiplicadorEstadia getOne(int multiplicadorDesde) {
		try {
			return new MultiplicadorEstadiaData().getOne(multiplicadorDesde);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar obtener un multiplicador en la base de datos", e);
		}
	}

	public static void deleteOne(int multiplicadorDesde) {
		try {
			new MultiplicadorEstadiaData().deleteOne(multiplicadorDesde);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar eliminar un multiplicador en la base de datos", e);
		}
	}

	public static void insertOne(MultiplicadorEstadia me) {
		if (me.getMultiplicadorDesde() < 0) {
			throw new MultiplicadorInvalidoException("La cantidad de días para poder aplicar el descuento no puede ser negativa");
		} else if (me.getMultiplicadorDesde() == 0) {
			throw new MultiplicadorInvalidoException("La cantidad de días para poder aplicar el descuento debe ser mayor a 0");
		} else if (me.getMultiplicadorDesde() % 1 != 0) {
			throw new MultiplicadorInvalidoException("La cantidad de días para poder aplicar el descuento debe ser un número entero");
		} else if (me.getPorcentajeMultiplicador() < 0) {
			throw new PorcentajeMultiplicadorInvalidoException("El porcentaje de descuento no puede ser negativo");
		} else if (me.getPorcentajeMultiplicador() == 0) {
			throw new PorcentajeMultiplicadorInvalidoException("El porcentaje de descuento debe ser mayor a 0");
		} else if (me.getPorcentajeMultiplicador() >= 1) {
			throw new PorcentajeMultiplicadorInvalidoException("El porcentaje de descuento debe ser menor a 1");
		}

		ArrayList<MultiplicadorEstadia> multiplicadores = MultiplicadorEstadiaController.getAll();

		int mDias = me.getMultiplicadorDesde();
		Double Mporcentaje = me.getPorcentajeMultiplicador();

		for (MultiplicadorEstadia m : multiplicadores) {
			if (m.getMultiplicadorDesde() == mDias) {
				throw new MultiplicadorExistenteException("Ya existe un descuento por estadía para " + mDias + " días");
			}
		}

		for (MultiplicadorEstadia m : multiplicadores) {
			if (m.getMultiplicadorDesde() < mDias) {
				if (m.getPorcentajeMultiplicador() >= Mporcentaje) {
					throw new PorcentajeMultiplicadorExistenteException(
							"Ya existe un porcentaje de descuento mayor o igual al ingresado para una menor cantidad de días");
				}
			}
		}

		for (MultiplicadorEstadia m : multiplicadores) {
			if (m.getMultiplicadorDesde() > mDias) {
				if (m.getPorcentajeMultiplicador() <= Mporcentaje) {
					throw new PorcentajeMultiplicadorExistenteException(
							"Existe un porcentaje de descuento menor o igual al ingresado para una mayor cantidad de días");
				}
			}
		}

		try {
			new MultiplicadorEstadiaData().insertOne(me);
		} catch (DatabaseAccessException e) {
			throw new DatabaseAccessException("Error al intentar insertar un multiplicador en la base de datos", e);
		}
	}
}

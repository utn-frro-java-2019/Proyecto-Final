package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;
import util.CustomExceptions.DatabaseAccessException;

public class VehiculoData {

	public ArrayList<Vehiculo> getAll() {
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from vehiculos");

			while (rs.next()) {
				Vehiculo v = new Vehiculo();

				v.setPatente(rs.getString("patente"));
				v.setMarca(rs.getString("marca"));
				v.setModelo(rs.getString("modelo"));
				v.setDescripcion(rs.getString("descripcion"));
				v.setPropietario(rs.getString("propietario"));
				v.setTelefonoContacto(rs.getString("telefonoContacto"));
				v.setTipo(new TipoVehiculoData().getOne(rs.getInt("idTipo")));

				vehiculos.add(v);
			}

		} catch (SQLException e) {
			throw new DatabaseAccessException("Error SQL al intentar recuperar los vehiculos de la base de datos", e);
		} catch (Exception e) {
			throw new DatabaseAccessException("Error al intentar recuperar los vehiculos de la base de datos", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				FactoryConnection.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DatabaseAccessException(
						"Error al intentar cerrar la conexión o el statement al recuperar los vehiculos", e);
			}
		}

		return vehiculos;
	}

	public Vehiculo getOne(String patente) {
		Vehiculo v = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("select * from vehiculos where patente = ?");
			pstmt.setString(1, patente);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				v = new Vehiculo();

				v.setPatente(rs.getString("patente"));
				v.setMarca(rs.getString("marca"));
				v.setModelo(rs.getString("modelo"));
				v.setDescripcion(rs.getString("descripcion"));
				v.setPropietario(rs.getString("propietario"));
				v.setTelefonoContacto(rs.getString("telefonoContacto"));
				v.setTipo(new TipoVehiculoData().getOne(rs.getInt("idTipo")));
			}

		} catch (SQLException e) {
			throw new DatabaseAccessException("Error SQL al intentar recuperar un vehiculo de la base de datos", e);
		} catch (Exception e) {
			throw new DatabaseAccessException("Error SQL al intentar recuperar un vehiculo de la base de datos", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				FactoryConnection.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DatabaseAccessException(
						"Error al intentar cerrar la conexión o el statement al recuperar un vehiculo", e);
			}
		}

		return v;
	}

	public void deleteOne(String patente) {
		PreparedStatement pstmt = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("delete from vehiculos where patente = ?");
			pstmt.setString(1, patente);
			pstmt.executeUpdate();
			if (pstmt != null) {
				pstmt.close();
			}

		} catch (SQLException e) {
			throw new DatabaseAccessException("Error SQL al intentar eliminar un vehiculo de la base de datos", e);
		} catch (Exception e) {
			throw new DatabaseAccessException("Error al intentar eliminar un vehiculo de la base de datos", e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new DatabaseAccessException("Error al intentar cerrar el statement al eliminar un vehiculo", e);
			}
		}
	}

	public void insertOne(Vehiculo v) {
		PreparedStatement pstmt = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into vehiculos (patente, modelo, descripcion, marca, idTipo, propietario, telefonoContacto) values (?,?,?,?,?,?,?)");
			pstmt.setString(1, v.getPatente());
			pstmt.setString(2, v.getModelo());
			pstmt.setString(3, v.getDescripcion());
			pstmt.setString(4, v.getMarca());
			pstmt.setInt(5, v.getTipo().getIdTipo());
			pstmt.setString(6, v.getPropietario());
			pstmt.setString(7, v.getTelefonoContacto());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DatabaseAccessException("Error SQL al intentar insertar un vehiculo de la base de datos", e);
		} catch (Exception e) {
			throw new DatabaseAccessException("Error al intentar insertar un vehiculo de la base de datos", e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				FactoryConnection.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DatabaseAccessException(
						"Error al intentar cerrar la conexión o el statement al insertar un vehiculo", e);
			}
		}
	}

	public void updateOne(Vehiculo v) {
		PreparedStatement pstmt = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"update vehiculos set modelo = ?, descripcion = ?, marca = ?, idTipo = ?, propietario = ?, telefonoContacto = ? where patente = ?");
			pstmt.setString(1, v.getModelo());
			pstmt.setString(2, v.getDescripcion());
			pstmt.setString(3, v.getMarca());
			pstmt.setInt(4, v.getTipo().getIdTipo());
			pstmt.setString(5, v.getPropietario());
			pstmt.setString(6, v.getTelefonoContacto());
			pstmt.setString(7, v.getPatente());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DatabaseAccessException("Error SQL al intentar actualizar un vehiculo de la base de datos", e);
		} catch (Exception e) {
			throw new DatabaseAccessException("Error al intentar actualizar un vehiculo de la base de datos", e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				FactoryConnection.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DatabaseAccessException(
						"Error al intentar cerrar la conexión o el statement al actualizar un vehiculo", e);
			}
		}
	}
}

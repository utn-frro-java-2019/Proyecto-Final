package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.*;
import util.CustomExceptions.DatabaseAccessException;

public class LugarData {

	public ArrayList<Lugar> getAllFromCochera(int idCochera) {
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from lugares where idCochera =" + idCochera);

			while (rs.next()) {
				Lugar l = new Lugar();

				l.setNroLugar(rs.getInt("nroLugar"));
				boolean ocupado = false;
				if (rs.getString("ocupado") == "true")
					ocupado = true;
				l.setOcupado(ocupado);
				l.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));

				lugares.add(l);
			}

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar obtener los lugares por cochera en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar obtener los lugares por cochera en la base de datos", e);
		}
		finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al obtener los lugares por cochera", e);
	        }		
		}

		return lugares;
	}

	public void updateOne(Lugar l) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			stmt.executeUpdate("update lugares set ocupado = '" + l.isOcupado() + "' where nroLugar = "
					+ l.getNroLugar() + " and idCochera = " + l.getCochera().getIdCochera());


		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar modificar el lugar en cochera en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error SQL al intentar modificar el lugar en cochera en la base de datos", e);
		}
		finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al modificar el lugar en cochera", e);
	        }		
		}

	}

	public void insertOne(Lugar l) {
		Statement stmt = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			stmt.executeUpdate("insert into lugares (nroLugar, ocupado, idCochera) values (" + l.getNroLugar() + ", '"
					+ l.isOcupado() + "', " + l.getCochera().getIdCochera() + ")");

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar insertar un lugar en cochera en la base de datos", e);
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        throw new DatabaseAccessException("Error al intentar insertar un lugar en cochera en la base de datos", e);
		}
		finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al insertar el lugar en cochera", e);
	        }		
		}
	}

	public Lugar getOne(int nroLugar, int idCochera) {
		Lugar l = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from lugares where nroLugar=" + nroLugar + " and idCochera="
					+ idCochera);

			while (rs.next()) {
				l = new Lugar();

				l.setNroLugar(rs.getInt("nroLugar"));
				boolean ocupado = false;
				if (rs.getString("ocupado") == "true") {
					ocupado = true;
				}

				l.setOcupado(ocupado);
				l.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
			}


		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar buscar un lugar en cochera en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar buscar un lugar en cochera en la base de datos", e);
		}
		finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al buscar un lugar en cochera", e);
	        }		
		}

		return l;
	}

	public Lugar getOneFree(int idCochera) {
		Lugar l = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt
					.executeQuery("select * from lugares where idCochera=" + idCochera + " and ocupado='false'");

			while (rs.next()) {
				l = new Lugar();

				l.setNroLugar(rs.getInt("nroLugar"));
				boolean ocupado = false;
				if (rs.getString("ocupado") == "true") {
					ocupado = true;
				}

				l.setOcupado(ocupado);
				l.setCochera(new data.CocheraData().getOne(rs.getInt("idCochera")));
			}

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar buscar un lugar libre en cochera en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar buscar un lugar libre en cochera en la base de datos", e);
		}
		finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al buscar libre un lugar en cochera", e);
	        }		
		}

		return l;
	}
}
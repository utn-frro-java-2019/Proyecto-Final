package data;

import java.sql.*;
import java.util.ArrayList;
import domain.*;
import util.CustomExceptions.DatabaseAccessException;

public class EmpleadoData {

	public ArrayList<Empleado> getAll() {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from empleados");

			while (rs.next()) {
				Empleado emp = new Empleado();

				emp.setNombre(rs.getString("nombre"));
				emp.setApellido(rs.getString("apellido"));
				emp.setEmail(rs.getString("email"));
				emp.setTelefono1(rs.getString("telefono1"));
				emp.setTelefono2(rs.getString("telefono2"));
				emp.setUsuario(rs.getString("usuario"));
				emp.setPassword(rs.getString("password"));
				emp.setDni(rs.getString("dni"));
				emp.setCochera(new CocheraData().getOne(rs.getInt("idCochera")));
				emp.setTurno(new TurnoData().getOne(rs.getInt("idTurno")));

				empleados.add(emp);
			}


		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar obtener los empleados en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar obtener los empleados en la base de datos", e);
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
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al obtener los empleados", e);
	        }		
		}

		return empleados;
	}

	public Empleado getOne(String dni) {
		Empleado emp = null;
		PreparedStatement stmt =null;
		ResultSet rs = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("Select * from empleados where dni = ?");
			stmt.setString(1, dni);
			rs = stmt.executeQuery();
			while (rs.next()) {
				emp = new Empleado();

				emp.setDni(rs.getString("dni"));
				emp.setNombre(rs.getString("nombre"));
				emp.setApellido(rs.getString("apellido"));
				emp.setEmail(rs.getString("email"));
				emp.setTelefono1(rs.getString("telefono1"));
				emp.setTelefono2(rs.getString("telefono2"));
				emp.setUsuario(rs.getString("usuario"));
				emp.setPassword(rs.getString("password"));
				emp.setCochera(new CocheraData().getOne(rs.getInt("idCochera")));
				emp.setTurno(new TurnoData().getOne(rs.getInt("idTurno")));
			}

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar obtener un empleado por dni en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar obtener un empleado por dni en la base de datos", e);
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
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al obtener un empleado por dni", e);
	        }		
		}

		return emp;
	}

	public Empleado getOneByEmail(String email) {
		Empleado emp = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("Select * from empleados where email = ?");
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			while (rs.next()) {
				emp = new Empleado();

				emp.setDni(rs.getString("dni"));
				emp.setNombre(rs.getString("nombre"));
				emp.setApellido(rs.getString("apellido"));
				emp.setEmail(rs.getString("email"));
				emp.setTelefono1(rs.getString("telefono1"));
				emp.setTelefono2(rs.getString("telefono2"));
				emp.setUsuario(rs.getString("usuario"));
				emp.setPassword(rs.getString("password"));
				emp.setCochera(new CocheraData().getOne(rs.getInt("idCochera")));
				emp.setTurno(new TurnoData().getOne(rs.getInt("idTurno")));
			}


		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar obtener un empleado por mail en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar obtener un empleado por mail en la base de datos", e);
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
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al obtener un empleado por mail", e);
	        }		
		}

		return emp;
	}

	public void deleteOne(String dni) {
		PreparedStatement pstmt = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn()
					.prepareStatement("delete from empleados where dni = ?");
			pstmt.setString(1, dni);
			pstmt.executeUpdate();

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar eliminar un empleado en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar eliminar un empleado en la base de datos", e);
		}
		finally {
	        try {
				if (pstmt != null) {
					pstmt.close();
				}
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar el statement al eliminar un empleado", e);
	        }		
		}
	}

	public void insertOne(Empleado emp) {
		PreparedStatement pstmt = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into empleados(dni,nombre,apellido,email,telefono1,telefono2,usuario,password,idCochera,idTurno) values(?,?,?,?,?,?,?,?,?,?)");

			pstmt.setString(1, emp.getDni());
			pstmt.setString(2, emp.getNombre());
			pstmt.setString(3, emp.getApellido());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getTelefono1());
			pstmt.setString(6, emp.getTelefono2());
			pstmt.setString(7, emp.getUsuario());
			pstmt.setString(8, emp.getPassword());
			pstmt.setInt(9, emp.getCochera().getIdCochera());
			pstmt.setInt(10, emp.getTurno().getIdTurno());

			pstmt.executeUpdate();

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar insertar un empleado en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar insertar un empleado en la base de datos", e);
		}
		finally {
	        try {
				if (pstmt != null) {
					pstmt.close();
				}
				FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al insertar un empleado", e);
	        }		
		}
	}

	public void updateOne(Empleado emp) {
		PreparedStatement pstmt = null;
		try {
			pstmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"update empleados set  nombre = ? , apellido = ? , email = ? , telefono1 = ? , telefono2 = ? , usuario = ? , password = ?, idCochera = ?, idTurno = ? where dni = ?");

			pstmt.setString(1, emp.getNombre());
			pstmt.setString(2, emp.getApellido());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getTelefono1());
			pstmt.setString(5, emp.getTelefono2());
			pstmt.setString(6, emp.getUsuario());
			pstmt.setString(7, emp.getPassword());
			pstmt.setInt(8, emp.getCochera().getIdCochera());
			pstmt.setInt(9, emp.getTurno().getIdTurno());
			pstmt.setString(10, emp.getDni());

			pstmt.executeUpdate();

		} catch (SQLException e) {
	        throw new DatabaseAccessException("Error SQL al intentar modificar un empleado en la base de datos", e);
		} catch (Exception e) {
	        throw new DatabaseAccessException("Error al intentar modificar un empleado en la base de datos", e);
		}
		finally {
	        try {
				if (pstmt != null) {
					pstmt.close();
				}
				FactoryConnection.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            throw new DatabaseAccessException("Error al intentar cerrar la conexión o el statement al modificar un empleado", e);
	        }		
		}
	}
}

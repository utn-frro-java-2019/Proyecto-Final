package data;

import java.sql.*;

public class FactoryConnection {

	private static FactoryConnection instancia;
	
	private String driver="com.mysql.jdbc.Driver";

	private String host=System.getenv("DB_HOST");
	private String port=System.getenv("DB_PORT");
	private String user=System.getenv("DB_USER");
	private String password=System.getenv("DB_PASSWORD");
	private String db=System.getenv("DB_NAME");

	private int conectados=0;
	private Connection conn=null;
	
	private FactoryConnection() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static FactoryConnection getInstancia() {
		if (instancia == null) {
			instancia = new FactoryConnection();
		}
		return instancia;
	}
	
	public Connection getConn() {
		try {
			if(conn==null || conn.isClosed()) {
				conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+"?serverTimezone=UTC", user, password);
				conectados=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() {
		conectados--;
		try {
			if (conectados<=0) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
package manage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DbManager {
	private String dsnNameString;
	private String userNameString;
	private String passWordString;
	private Connection connection=null;
	private Statement statement=null;
	
	public DbManager(String dsnNameString,String userNameString,String passWordString){
		this.dsnNameString=dsnNameString;
		this.userNameString=userNameString;
		this.passWordString=passWordString;
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connection = DriverManager.getConnection("jdbc:odbc:" + dsnNameString,
					userNameString, passWordString);
			
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;DatebaseName="+dsnNameString+";user="+userNameString+";password="+passWordString);
			statement=connection.createStatement();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void stop(){
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet executequery(String sqlString){
		try {
			return statement.executeQuery(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public int executeNoQuery(String sqlString){
		try{
			return statement.executeUpdate(sqlString);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	

}

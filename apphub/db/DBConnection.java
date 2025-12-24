package apphub.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection
{
	private static final String URL="-------";
	private static final String USER="root";
	private static final String PASS="----------";
	
	private DBConnection()
	{
		
	}
	public static Connection getConnection() throws Exception
	{
		return DriverManager.getConnection(URL,USER,PASS);
	}
}
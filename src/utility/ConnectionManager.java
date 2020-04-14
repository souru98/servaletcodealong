package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
public static Properties loadPropertiesFile() throws IOException {
	Properties prop =new Properties();
	InputStream in =ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
	prop.load(in);
	in.close();
	return prop;
}

public static Connection getConnection() throws SQLException, ClassNotFoundException {
	Connection con =null;
	Properties prop=null;
	try {
		prop=loadPropertiesFile();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	final String driver=prop.getProperty("driver");
	final String url=prop.getProperty("url");
	final String username=prop.getProperty("username");
	final String password=prop.getProperty("password");
	
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url,username,password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}
}

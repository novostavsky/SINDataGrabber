package cdp.lviv.singrabber.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCManager {
		private String user;
		private String password;
		private String url;
		
		protected JDBCManager(String propertiesFilePath) throws FileNotFoundException, IOException{
			Properties properties = new Properties();
			properties.load(new FileInputStream(propertiesFilePath));

			//TODO check if properties are properly loaded (exist)
			this.user = properties.getProperty("user");
			this.password = properties.getProperty("password");
			this.url = properties.getProperty("url");
		}
		protected Connection getMDBConnection() throws SQLException{
			Connection result = null;
			result = DriverManager.getConnection(this.url, this.user, this.password);

			return result;
		}
}

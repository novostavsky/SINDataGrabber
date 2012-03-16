package cdp.lviv.singrabber.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCConnectionManager {
	
	public static Connection getConnection() throws FileNotFoundException, SQLException, IOException {
		return	(new JDBCManager("db.properties").getMDBConnection());
	}
}

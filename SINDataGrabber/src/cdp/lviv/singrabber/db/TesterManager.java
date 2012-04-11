package cdp.lviv.singrabber.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cdp.lviv.singrabber.dto.Tester;

public class TesterManager {
	private static String tblName = "testers";
	private Connection connection;
	
	public TesterManager(Connection connection){
		this.connection = connection;
	}
	public TesterManager() {
		try {
			this.connection = JDBCConnectionManager.getConnection();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void insert(Tester tester) throws SQLException {
		System.out.println("Trying to add " + tester.getFamilyName() + " " + tester.getGivenName());
		
		String sqlInsert = "INSERT INTO `" + TesterManager.tblName + 
				"` (inId, givenName, familyName, currentTitle, pastTitle, period, locality, industry, education, email) " +
				"VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
		
		PreparedStatement statement = this.connection.prepareStatement(sqlInsert);
		
		statement.setLong(1, tester.getId());
		statement.setString(2, tester.getGivenName());
		statement.setString(3, tester.getFamilyName());
		statement.setString(4, tester.getCurrentTitle());
		statement.setString(5, tester.getPastTitle());
		statement.setString(6, tester.getPeriod());
		statement.setString(7, tester.getLocality());
		statement.setString(8, tester.getIndustry());
		statement.setString(9, tester.getEducation());
		statement.setString(10, tester.getEmail());
				
		this.updateTable(statement);
	}
	private int updateTable(PreparedStatement  statement){
		int rows = 0;
		
		try{
			rows = statement.executeUpdate();
		} catch (SQLException sqlEx){
			sqlEx.printStackTrace();
		} finally{
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}
}

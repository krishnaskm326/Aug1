package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection con=null;
	public void connectToDb() throws Throwable
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstants.DBURL,IpathConstants.DBUSERNAME,IpathConstants.DBPASSWORD);
	}
	public long executeQueryAndGetData(String query,long expdata,int columnIndex) throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstants.DBURL,IpathConstants.DBUSERNAME,IpathConstants.DBPASSWORD);
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		while(result.next()) {
			long data = result.getLong(columnIndex);
			if(data==expdata) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println("data is not Accepted");
					
	return expdata;
	}
		else {
			System.out.println("data is Accepted");
			return 0;
		}
}
	/**
	 * 
	 * @throws Throwable
	 */
	public void closeDb() throws Throwable {
		con.close();
		System.out.println("database connection closed");
	}
	}

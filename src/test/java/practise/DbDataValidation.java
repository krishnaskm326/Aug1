package practise;

import org.testng.annotations.Test;

import com.GenericUtilities.DatabaseUtility;

public class DbDataValidation {

	@Test
	public void DBvalidate() throws Throwable {
		long phNo=636950100l;
		DatabaseUtility dblib=new DatabaseUtility();
		//String q="select contact from users";
		dblib.executeQueryAndGetData("select contact from users",phNo, 1);
		
	}
}

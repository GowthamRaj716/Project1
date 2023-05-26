package org.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc {

	public static void main(String[] args) throws SQLException {

		Connection con = null;
		try {
			// load the oracle driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// connect to db
			con = DriverManager.getConnection("\"jdbc:oracle:thin@localhost:1521:xe", "hr", "admin");

			// write sql query
			String que = "select * from stuin";

			// prepare statement
			PreparedStatement res = con.prepareStatement(que);

			// execute the query
			ResultSet res1 = res.executeQuery();

			// iterate the resultset
			while (res1.next()) {
				int idno = res1.getInt("stu_id");
				System.out.println(idno);
				String name = res1.getString("stu_name");
				System.out.println(name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

}

package com.hao.jdbc;

import java.sql.*;

public class TestJDBC {

	public static void main(String[] args) {
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&useUnicode=true&characterEncoding=UTF8");
//			new com.mysql.jdbc.Driver();
			//new oracle.jdbc.driver.OracleDriver();

			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from tbl_user where email = 'id 80033'");
			while(rs.next()) {
				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("last_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
					rs = null;
				}
				if(stmt != null) {
					stmt.close();
					stmt = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

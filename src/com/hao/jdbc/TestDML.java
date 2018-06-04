package com.hao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDML {

	public static void main(String[] args) {
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			//new oracle.jdbc.driver.OracleDriver();
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.1:1521:SXT", "scott", "tiger");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&useUnicode=true&characterEncoding=UTF8");
			conn.setAutoCommit(false);
			long start = System.currentTimeMillis();
			String sql = "insert into tbl_user (email, last_name) values (?, ?)";
			stmt = conn.prepareStatement(sql);
			for (int i = 0; i < 100; i++) {
//				String x = i+"sun";
//				String sql = "insert into tbl_user values (null,'"+x+"','23dd')";
				String x = i+"sun";
				stmt.setString(1,"sun"+i);
				stmt.setString(2,"hao"+i);
//				stmt.setString(3,"hao"+i);
				stmt.executeUpdate(sql);
			}
			long end = System.currentTimeMillis();
			System.out.println(end-start);//29138
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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

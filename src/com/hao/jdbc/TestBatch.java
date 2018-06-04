package com.hao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

public class TestBatch {


	public static void main(String[] args) throws Exception {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.1:1521:SXT", "scott", "tiger");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&useUnicode=true&characterEncoding=UTF8");
		conn.setAutoCommit(false);
		PreparedStatement  stmt = null;
		String sql = "insert into tbl_user values ( null,?, 'fd')";
		stmt = conn.prepareStatement(sql);
		long start = new Date().getTime();
//		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			String x = "dog"+i;
			stmt.setString(1, x);
			stmt.addBatch();
		}
		stmt.executeBatch();
		conn.commit();
		conn.setAutoCommit(true);
//		long end = System.currentTimeMillis();
		long end = new Date().getTime();
		System.out.println(end-start);//29138
		stmt.close();

		
//		PreparedStatement ps = conn.prepareStatement("insert into dept2 values (?, ?, ?)");
//		ps.setInt(1, 61);
//		ps.setString(2, "haha");
//		ps.setString(3, "bj");
//		ps.addBatch();
//
//		ps.setInt(1, 62);
//		ps.setString(2, "haha");
//		ps.setString(3, "bj");
//		ps.addBatch();
//
//		ps.setInt(1, 63);
//		ps.setString(2, "haha");
//		ps.setString(3, "bj");
//		ps.addBatch();
		
//		ps.executeBatch();
//		ps.close();
		
		conn.close();

	}

}

package com.hao.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestThreadBatch {
    public static void main(String[] args) {
        allotThread();
    }
        
    /**
     * 将100条数据分成10份并启动10个线程分别操作
     */
    public static void allotThread() {
        List<String[]> datas = buildDatas();
        long start = System.currentTimeMillis();
        for (int i=0; i<100000; i+=20000) {
            List<String[]> tenDatas = datas.subList(i, i + 20000);
            insertData(tenDatas);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);//29138
    }
        
    /**
     * 创建100条模拟数据
     * @return
     */
    public static List<String[]> buildDatas() {
        List<String[]> datas = new ArrayList<String[]>();
        for (int i=0; i<100000; i++) {
            String[] data = {"id " + i, "name " + i};
            datas.add(data);
        }
        return datas;
    }
        
    /**
     * 启动线程进行数据插入操作
     * @param tenDatas
     */
    public static void insertData(final List<String[]> tenDatas) {
        new Thread(new Runnable() {
            public void run() {
                String sql = "insert into tbl_user (email, last_name) values (?, ?)";
                Connection conn = null;
                PreparedStatement pstmt = null;
                try {
                    conn = getConnection();
                    conn.setAutoCommit(false);
                    pstmt = getPstmt(conn, sql);
                    for (String[] data : tenDatas) {
                        pstmt.setString(1, data[0]);
                        pstmt.setString(2, data[1]);
                        pstmt.addBatch();
                    }
                    pstmt.executeBatch();
                    conn.commit();
                    conn.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                    rollback(conn);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    close(pstmt);
                    close(conn);
                }
            }
        }).start();
    }
        
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String dbUrl = "jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=UTF-8";
        Connection conn = DriverManager.getConnection(dbUrl, "root", "root");
        return conn;
    }
        
    public static PreparedStatement getPstmt(Connection conn, String sql) throws SQLException, ClassNotFoundException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        return pstmt;
    }
        
    public static void rollback(Connection conn) {
        try {
            if (null != conn) {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    public static void close(Connection conn) {
        try {
            if (null != conn) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    public static void close(PreparedStatement pstmt) {
        try {
            if (null != pstmt) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    public static void close(ResultSet rs) {
        try {
            if (null != rs) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
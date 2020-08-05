package cn.luyi.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	//创建一个连接池，但是这个连接池只需要创建一次即可
	private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	/*
	 * 获得连接的方法
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	/*
	 * 获得连接池
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
	/*
	 * 释放资源的方法
	 */
	public static void release(Statement stmt, Connection conn){
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	public static void release(ResultSet rs, Statement stmt, Connection conn){
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			rs = null;
		}		
	}
}

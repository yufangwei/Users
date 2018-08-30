package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * ���ݿ⹤�߰�
 * @author Administrator
 *
 */
public class DBUtil {
	String url="jdbc:sqlserver://127.0.0.1:1433;databasename=users";
	String user = "sa";
	String pwd = "123456";
	public Connection conn;
	public PreparedStatement ps;
	public ResultSet rs;
	
	public DBUtil() {
		// TODO Auto-generated constructor stub
		//��������
		try {//"com.microsoft.sqlserver.jdbc.SQLServerDriver"
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ȡ���Ӷ���
	public Connection getConn(){
		try {
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//������ɾ��
	public int execUpdate(String sql,Object[] obj){
		try {
			//��ȡ���Ӷ���
			getConn();
			//��ȡ��������
			ps = conn.prepareStatement(sql);
			if(obj!=null){
				//ѭ����ֵ
				for(int i=0;i<obj.length;i++){
					ps.setObject(i+1, obj[i]);
				}
			}
			 return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//���ڲ�ѯ
	public ResultSet execQuery(String sql,Object[] obj){
		try {
			//��ȡ���Ӷ���
			getConn();
			//��ȡ��������
			ps = conn.prepareStatement(sql);
			if(obj!=null){
				for(int i=0;i<obj.length;i++){
					ps.setObject(i+1, obj[i]);
				}
			}
			 return ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//�ر����ݿ�Ķ���
	public void getClose(ResultSet rs,PreparedStatement ps,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

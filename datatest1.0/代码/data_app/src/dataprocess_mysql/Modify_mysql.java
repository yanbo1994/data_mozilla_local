/*package dataprocess_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modify_mysql {
	static int record=0;
	  public static void main(String args[]) {
		    try {
		      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/github_db","root","");
		           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������
		      System.out.println("Success connect Mysql server!");
		      
		      Statement stmt = connect.createStatement();
		      ResultSet rs = stmt.executeQuery("select Comment_Time from info_level2");
		                                                        
		      while (rs.next()) {

		  		  TransTime tt=new TransTime();
		  		  String time=tt.trans(rs.getString("Comment_Time"));
		  		 
			      String sqlupdate="update info_level2_beijingtime set Comment_Time=?";
			      PreparedStatement ps = connect.prepareStatement(sqlupdate); 
			      ps.setString(1, time);
			      ps.executeUpdate(); 
		         record++;
		          
		      }
		      connect.close();
		      System.out.print("sucess of update:"+record);
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    }
		  }
}*/
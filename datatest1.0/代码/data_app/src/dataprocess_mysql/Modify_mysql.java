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
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/github_db","root","");
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
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
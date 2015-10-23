package dataprocess_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Mysql_commenttime {
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
		  	  
		      //PreparedStatement ps = connect.prepareStatement("select Comment_Time from info_level2", 
		      //ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); 
		      //ps.setFetchSize(Integer.MIN_VALUE); //也可以修改jdbc url通过defaultFetchSize参数来设置，这样默认所以的返回结果都是通过流方式读取.
		      //ResultSet rs = ps.executeQuery(); 

		                                                        
		      while (rs.next()) {
		         //System.out.print(rs.getString("Bug_ID"));
		         //System.out.print(" ");
		         //System.out.print(rs.getString("Comment_Num"));
		         //System.out.print(" ");
		         //System.out.print(rs.getString("Login_ID"));
		         //System.out.print(" ");
		         
		  		 TransTime tt=new TransTime();
		  		 String time=tt.trans(rs.getString("Comment_Time"));
		  		 
		         //System.out.print(rs.getString("Comment_Time"));
		         //System.out.print(" ");
		         //System.out.print(rs.getString("Type"));
		         //System.out.print(" ");
		         //System.out.print(rs.getString("Comment_User"));
		         //System.out.print(" ");
		         //System.out.print(rs.getString("Text_Length"));
		         //System.out.println(" ");
		  		 
		  		 String sqlstr= "insert into commenttime(time) values(?)";
		  		 PreparedStatement statement = connect.prepareStatement(sqlstr);
		  		 statement.setString (1,time);
		         statement.executeUpdate();
		         record++;
		          
		      }
		      connect.close();
		      System.out.print("sucess:"+record);
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    }
		  }
}
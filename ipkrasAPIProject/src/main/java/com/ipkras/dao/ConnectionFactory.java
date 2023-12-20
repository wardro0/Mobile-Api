package com.ipkras.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	 public static Connection getConnection() { // call everytime i want to connect on ipkras db
	        Connection c = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ipkras", "root", "");
	        } catch (ClassNotFoundException e) {
	            System.out.println("ClassNotFoundException " + e);
	        } catch (SQLException e) {
	            System.out.println("SQLException " + e);
	        }
	        return c;
	    }
	 
	 	Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		public String getStringFromTable(String query){
			String field = null;	
			
			try{
				
				con = ConnectionFactory.getConnection();			
			      
			    st = con.createStatement();
			    rs = st.executeQuery(query);
					
					if(rs != null){
						while(rs.next()){
							field = rs.getString(1);
							break;
						}
						rs.close();
					}
					st.close();
					//con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				return field;
		}
}

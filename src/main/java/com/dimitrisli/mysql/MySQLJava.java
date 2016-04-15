package com.dimitrisli.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLJava {

	enum TestTableColumns{
		film_id,title;
	}
	
	private final String jdbcDriverStr;
	private final String jdbcURL;
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	public MySQLJava(String jdbcDriverStr, String jdbcURL){
		this.jdbcDriverStr = jdbcDriverStr;
		this.jdbcURL = jdbcURL;
	}
	
	public void readData() throws Exception {
		try {
			Class.forName(jdbcDriverStr);
			connection = DriverManager.getConnection(jdbcURL);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from sakila.film;");
			getResultSet(resultSet);
			/*preparedStatement = connection.prepareStatement("insert into javaTestDB.test_table values (default,?)");
			preparedStatement.setString(1,"insert test from java");
			preparedStatement.executeUpdate();*/
		}finally{
			close();
		}
	}
	
	private void getResultSet(ResultSet resultSet) throws Exception {
		while(resultSet.next()){
			Integer id = resultSet.getInt(TestTableColumns.film_id.toString());
			String text = resultSet.getString(TestTableColumns.title.toString());
			System.out.println("id: "+id);
			System.out.println("text: "+text);
		}
	}
	
	private void close(){
		try {
			if(resultSet!=null) resultSet.close();
			if(statement!=null) statement.close();
			if(connection!=null) connection.close();
		} catch(Exception e){}
	}
}

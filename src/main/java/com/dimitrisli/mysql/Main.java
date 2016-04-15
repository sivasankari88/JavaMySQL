package com.dimitrisli.mysql;

public class Main {
	public static final String MYSQL_USERNAME="root";
	public static final String MYSQL_PASSWORD="Welcome!@#";
	public static final String MYSQL_DBNAME="sakila";
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_URL = "jdbc:mysql://localhost/"+ MYSQL_DBNAME +"?"
											+ "user=" + MYSQL_USERNAME + "&password="+ MYSQL_PASSWORD;
	
	public static void main(String[] args) throws Exception {
		MySQLJava dao = new MySQLJava(MYSQL_DRIVER,MYSQL_URL);
		dao.readData();
	}
}

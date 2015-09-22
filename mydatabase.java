import java.sql.*;
public class mydatabase
{
	public ResultSet select(String table) throws SQLException,ClassNotFoundException
	{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		String url="jdbc:mysql://localhost:3306/bank?user=root&password=root";
		Connection con=DriverManager.getConnection(url);
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select * from "+table);
		return rs;
	}
	public void insert(String table,int value1,String value2,String value3) throws SQLException,ClassNotFoundException
	{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		String url="jdbc:mysql://localhost:3306/bank?user=root&password=root";
		Connection con=DriverManager.getConnection(url);
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		st.execute("insert into "+table+" values("+value1+",'"+value2+"',"+value3+")");
		
	}
	public void update(String table,int value,String value1) throws SQLException,ClassNotFoundException
	{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		String url="jdbc:mysql://localhost:3306/bank?user=root&password=root";
		Connection con=DriverManager.getConnection(url);
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		st.execute("update "+table+" set Balance= "+value1+" where AccountNo="+value);
	}
	public void delete(String table,int value1) throws SQLException,ClassNotFoundException
	{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		String url="jdbc:mysql://localhost:3306/bank?user=root&password=root";
		Connection con=DriverManager.getConnection(url);
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		st.execute("delete from "+table+" where AccountNo="+value1);
	}
	public ResultSet singlerow(String table,int value4) throws SQLException,ClassNotFoundException
	{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		String url="jdbc:mysql://localhost:3306/bank?user=root&password=root";
		Connection con=DriverManager.getConnection(url);
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select * from "+table+" where AccountNo="+value4);
		return rs;
	}
}
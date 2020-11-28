package model;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	public class CURD_TEST{
		
	public static void main(String[]args) 
	{
		// TODO Auto-generated method stub

			
			CURD_TEST objTest=new CURD_TEST();
			        
				objTest.create_data1("1", "abc", "20000","xdf","ajay","3455757","efhidoidfhgiudhgjfdgh");
				   //insert data
				objTest.create_data1("2", "xyz",  "24000","xdf","vjay","3455757","efhidoidfhgiudhgjfdgh");
			      
			        //update data
				objTest.update_data1("2", "mno",  "10000","xdf","jay","3455757","efhidoidfhgiudhgjfdgh");
			        //delete data
				objTest.delete_data1("1");
				
	}

				public void create_data1(String id,String name,String fee,String course,String fathername,String contact,String address )
				
				{
					
					DB_connection obj_DB_connections=new DB_connection();
					Connection connection=obj_DB_connections.get_connection();
					
					PreparedStatement ps=null;
					
					try {
						
						String querry="insert into user(id,name,fee,course,fathername,contact,address) values(?,?,?,?,?,?,?)";
						ps=connection.prepareStatement(querry);
						ps.setString(1, id);
						ps.setString(2, name);
						ps.setString(3, fee);
						ps.setString(4, course);
						ps.setString(5, fathername);
						ps.setString(6, contact);
						ps.setString(7, address);
					System.out.println(ps);
					ps.executeUpdate();
					}
					catch (Exception e) 
					{
						System.out.println(e);
						}
						
					}
				public void read_data(String sl_no)
				{
					DB_connection obj_DB_Connection=new DB_connection();
					Connection connection=obj_DB_Connection.get_connection();
					PreparedStatement ps=null;
					ResultSet rs=null;
					try {
						String query="select * from user";
						ps=connection.prepareStatement(query);
						
						System.out.println(ps);
						rs=ps.executeQuery();
						while(rs.next()){
						System.out.println("id -"+rs.getString("id"));
						System.out.println("name -"+rs.getString("name"));
						System.out.println("fee -"+rs.getString("fee"));
						System.out.println("course -"+rs.getString("fee"));
						System.out.println("fathername -"+rs.getString("fee"));
						System.out.println("contact -"+rs.getString("fee"));
						System.out.println("address -"+rs.getString("fee"));
						System.out.println("---------------");
						}
					} 
					catch (Exception e)
					{
						System.out.println(e);
					}
				}
				public void update_data1( String id,String name,String fee,String course,String fathername,String contact,String address)
				{
					DB_connection obj_DB_Connection=new DB_connection();
					Connection connection=obj_DB_Connection.get_connection();
					PreparedStatement ps=null;
				
					try {
						String query="update user set id=?,name=?,name=? ,fee=?,course=?,fathername=?,contact=?,address=?,vwhere id=?";
						ps=connection.prepareStatement(query);
						ps.setString(1, id);
						ps.setString(2, name);
						ps.setString(3, fee);
						ps.setString(4, course);
						ps.setString(5, fathername);
						ps.setString(6, contact);
						ps.setString(7, address);
						
						ps.setString(8, id);
						System.out.println(ps);
						ps.executeUpdate();
					} 
					catch (Exception e) 
					{
						System.out.println(e);
						}
					}
					
				

				public void delete_data1(String id)
				{
					DB_connection obj_DB_Connection=new DB_connection();
					Connection connection=obj_DB_Connection.get_connection();
					PreparedStatement ps=null;
					try {
						String query="delete from user where id=?";
						ps=connection.prepareStatement(query);
						ps.setString(1, id);
						System.out.println(ps);
						ps.executeUpdate();
					} 
					catch (Exception e) 
					{
						System.out.println(e);
					}

				}
				
			

			
   }
		


	



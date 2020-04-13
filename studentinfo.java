import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class studentinfo1
{
	public static void studentdetails() 
	{
		String name,city,email;
		long mobile=0;
		int marks=0,i=0;
		System.out.println("enter student name");
		Scanner s=new Scanner(System.in);
		name=s.next();
		System.out.println("enter mobile number");
		mobile=s.nextLong();
		System.out.println("enter marks");
		marks=s.nextInt();
		System.out.println("enter emailid");
		email=s.next();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/priyanka", "root","priyanka@123");
			PreparedStatement pstmt=con.prepareStatement("insert into studentdetails values (?,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setLong(2,mobile);
			pstmt.setInt(3,marks);
			pstmt.setString(4,email);
			 i=pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
			}
		public static void main(String[] args) 
	{
			studentinfo1  t=new studentinfo1();
		t.studentdetails();
}
}

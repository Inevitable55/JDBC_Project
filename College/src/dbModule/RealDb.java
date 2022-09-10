package dbModule;

import java.sql.*;
import java.util.ArrayList;

import javax.security.sasl.RealmCallback;
public class RealDb {
	  private String url = "jdbc:mysql://localhost:/college";  //-----> Add port number
	  private String username = "";                            //-----> Add Username
          private String password = "";                            //------> Add Password
	  Connection conn = null;
	  Statement stmt = null;
	  ResultSet rs = null;

	  public RealDb(){
		 
		  
		  try {
		  conn = DriverManager.getConnection(url,username,password);
		  Thread.sleep((long) 1000);
		  System.out.println("connected");
		  System.out.println();
	   }
	  catch(Exception e) {
		  System.out.println("Error in connecting to the database!");
	   }

      }
	  public void AddStudent(int rol,String fname,String lname,int cl,String addres,String Email, String ph,String pas) {
		  
		  String query="INSERT INTO college.student VALUES (?,?,?,?,?,?,?,?)";
	      try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1,rol);
			stmt.setString(2,fname);
			stmt.setString(3,lname);
			stmt.setInt(4,cl);
			stmt.setString(5,addres);
			stmt.setString(6,Email);
			stmt.setString(7,ph);
			stmt.setString(8,pas);
			int rows=stmt.executeUpdate();
			if(rows==1) {
				System.out.println("Row(Student) was added");
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("Error in storing the data");
			System.out.println(e);
		}
	  }
	  public void AddTeacher(int tidd,String fname,String lname,String sub,String Email, String ph,String pas) {
		  String query="INSERT INTO college.teacher VALUES (?,?,?,?,?,?,?)";
	     try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1,tidd);
			stmt.setString(2,fname);
			stmt.setString(3, lname);
			stmt.setString(4,sub);
			stmt.setString(5,Email);
			stmt.setString(6,ph);
			stmt.setString(7, pas);
			
			int rows=stmt.executeUpdate();
			if(rows==1) {
				System.out.println("Row(Teacher) was added");
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("Error in storing the data");
			System.out.println(e);
		}
	 }
	  public boolean scheck(int rol) {
		  String query="SELECT rollno FROM student WHERE rollno=?";
	     try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1,rol);
			rs=stmt.executeQuery();
			while(rs.next()) {
			     int rollfromdb = rs.getInt(1);
			      if(rollfromdb==rol) 
				    return true;
			    System.out.println(rollfromdb);     
			}
			 return false;
	     
	     }catch (SQLException e) {
	    	 return false;
	    	 //System.out.println(e);
	     }


         
		}
	  public void showMark(int rol) {
		  String query="SELECT * FROM studentmarks where rollno=?";
	     try {
			PreparedStatement stmt = conn.prepareStatement(query);		
			stmt.setInt(1,rol);			
			rs=stmt.executeQuery();
			while(rs.next()) {
				int s1=rs.getInt(2);			
				int s2=rs.getInt(3);
				int s3=rs.getInt(4);
				int s4=rs.getInt(5);
				System.out.println("Subject-1 mark:- "+s1);
				System.out.println("Subject-2 mark:- "+s2);
				System.out.println("Subject-3 mark:- "+s3);
				System.out.println("Subject-4 mark:- "+s4);
				

			}
			

		} catch (SQLException e) {
			System.out.println(e);
         
		}
	 }
	 
	 
	  public void AddMark(int rol,int m1,int m2,int m3,int m4) {
		  String query="INSERT INTO studentmarks (rollno,subject1,subject2,subject3,subject4) values(?,?,?,?,?)";
	     try {
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setInt(1,rol);
			stmt.setInt(2,m1);
			stmt.setInt(3,m2);
			stmt.setInt(4,m3);
			stmt.setInt(5,m4);
			
			int rows=stmt.executeUpdate();
			if(rows==1) {
				System.out.println("Marks added");
			}
			

		} catch (SQLException e) {
			System.out.println(e);
         
		}
	 }
 public void DeleteStudent(int roll) {
		  
		 
	      try {
	    	 String query="DELETE FROM college.student  WHERE rollno=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1,roll);
			
			int rows=stmt.executeUpdate();
			if(rows==1) {
				System.out.println("Student Deleted");
			}
			else
				System.out.println("Student does not exist");
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	  }
 public void Delete_teacher(int tid) {
	  
	 
     try {
   	 String query="DELETE FROM college.teacher  WHERE TID=?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1,tid);
		
		int rows=stmt.executeUpdate();
		if(rows==1) {
			System.out.println("Teacher Deleted");
		}
		else
			System.out.println("Teacher does not exist");
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
 }
 
 
 
 public void AllStudent() {
	  
	  String query="SELECT * FROM student";
     try {
		PreparedStatement stmt = conn.prepareStatement(query);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
            int rol = rs.getInt(1);		
			String fname = rs.getString(2);
			String lname = rs.getString(3);
            int cl = rs.getInt(4);
            String addre= rs.getString(5);
			String email = rs.getString(6);
			String ph=rs.getString(7);
			
			System.out.println(rol+" "+fname+" "+lname+" "+cl+" "+addre+"  "+email+" "+ph);
		}
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Error in retriving all student data");
	}
 }
 public void AllTeacher() {
	  
	  String query="SELECT * FROM teacher";
  try {
		PreparedStatement stmt = conn.prepareStatement(query);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
            int ti = rs.getInt(1);		
			String fname = rs.getString(2);
			String lname = rs.getString(3);
            String sub = rs.getString(4);
         
			String email = rs.getString(5);
			String ph=rs.getString(6);
			System.out.println(ti+" "+fname+" "+lname+" "+sub+"  "+email+" "+ph);
		}
		

	} catch (SQLException e) {
		System.out.println(e);
		//System.out.println("Error in retrieving the data");
	}
}
 public void AStudent(int rol) {
	  
	  String query="SELECT * FROM student WHERE rollno=?";
    try {
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, rol);
		     
		rs = stmt.executeQuery();
		
		while(rs.next()) {
           int roll = rs.getInt(1);		
			String fname = rs.getString(2);
			String lname = rs.getString(3);
           int cl = rs.getInt(4);
           String addre= rs.getString(5);
			String email = rs.getString(6);
			String ph=rs.getString(7);
			System.out.println(roll+" "+fname+" "+lname+" "+cl+" "+addre+"  "+email+" "+ph);
		}
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Error in retrieving the data");
	}
}
 public void ATeacher(int tid) {
	  
	  String query="SELECT * FROM teacher WHERE TID=?";
   try {
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, tid);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
          int ti = rs.getInt(1);		
			String fname = rs.getString(2);
			String lname = rs.getString(3);
          String sub = rs.getString(4);
          
			String email = rs.getString(5);
			String ph=rs.getString(6);
			System.out.println(ti+" "+fname+" "+lname+" \t"+sub+"  "+email+" "+ph);
			System.out.println();
		}
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Error in retrieving the data");
	}
}
 public boolean adminAuth(String auser, String apass) {
		ArrayList<String> passworrds = new ArrayList<>();
     try {
 	    String query="SELECT * FROM college.admin WHERE username=? AND password=?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1,auser);
		stmt.setString(2,apass);
		rs = stmt.executeQuery();
		while(rs.next()) {
			
			String pass = rs.getString(3);
		    passworrds.add(pass);
		   }
		for (String string : passworrds) {
			if (string.equals(apass)) {
				System.out.println("User authenticated");
				return true;
			}
		}
		
		}catch (SQLException e) {
		
		System.out.println(e);
	        }
     System.out.println("User not authenticated");
     return false;
	}
 /*public static void main(String[] args) {
          RealDb db = new RealDb();
          
        db.AddTeacher(12221, "ssdsf", "Sdfs", "sdfsd", "sdfs", "5345345");
}*/
public boolean teachauth(int tid, String tpass) {
	ArrayList<String> passworrds = new ArrayList<>();
    try {
	    String query="SELECT * FROM college.teacher WHERE TID=? AND tpass=?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1,tid);
		stmt.setString(2,tpass);
		rs = stmt.executeQuery();
		while(rs.next()) {
			
			String pass = rs.getString(7);
		    passworrds.add(pass);
		   }
		for (String string : passworrds) {
			if (string.equals(tpass)) {
				System.out.println("Teacher authenticated");
				return true;
			}
		}
		
		}catch (SQLException e) {
		
		System.out.println(e);
	        }
    System.out.println("Teacher not authenticated/Teacher doesnt exist");
    return false;
	
}
public boolean studentauth(int srol, String spass) {
	ArrayList<String> passworrds = new ArrayList<>();
    try {
	    String query="SELECT * FROM college.student WHERE rollno=? AND spass=?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1,srol);
		stmt.setString(2,spass);
		rs = stmt.executeQuery();
		while(rs.next()) {
			
			String pass = rs.getString(8);
		    passworrds.add(pass);
		   }
		for (String string : passworrds) {
			if (string.equals(spass)) {
				System.out.println("Student authenticated");
				return true;
			}
		}
		
		}catch (SQLException e) {
		
		System.out.println(e);
	        }
    System.out.println("Student not authenticated/Student doesnt exist");
    
	return false;
}
 
	  
    



}

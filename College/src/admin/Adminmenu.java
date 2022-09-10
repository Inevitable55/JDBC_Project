package admin;
import dbModule.*;

import java.util.Scanner;

public class Adminmenu {
	 RealDb db = new RealDb();
	public void adminMenu() {
		char cha;
	    Scanner obja = new Scanner(System.in); 
			do {
			    System.out.println("   Admin Portal\n");
			    System.out.println("1) Add a Student");
			    System.out.println("2) Delete a Student");
			    System.out.println("3) Add a Teacher");
			    System.out.println("4) Delete a Teacher");
			    System.out.println("5) Retrieve a particular student detail");
			    System.out.println("6) Retrieve a particular teacher detail");
			    System.out.println("7) Retrieve all student detail");
			    System.out.println("8) Retrieve all teacher detail");
			    System.out.println("9) Exit");
			    System.out.println("Enter your choice:-");
			    char ch = obja.next().charAt(0);
			    adminops adp = new adminops();

			    switch(ch) {
			    case '1': System.out.println("Adding a Student");	        
			              adp.getinfo();
			              adp.putindb();  
			              break;
			    case '2': System.out.println("Deleting a Student");			             
			              System.out.println("Enter the roll number:-");
			              int rol = obja.nextInt();
			              db.DeleteStudent(rol);
			              break;
			    case '3': System.out.println("Adding a Teacher");			    
			              adp.getinfot();
			              adp.puttind();			
			              break;	   
			    case '4': System.out.println("Deleting a Teacher");			              
			              System.out.println("Enter teacher ID:-");
			              int ti=obja.nextInt();
			              db.Delete_teacher(ti);
			              break;
			    case '5': System.out.println("Retrieving a particular students details");
			              System.out.println("Enter Student roll number:-");
			              int si=obja.nextInt();
			              db.AStudent(si);
			              break;
			    case '6': System.out.println("Retrieving a particular teachers details");
			              System.out.println("Enter teacher ID:-");
			              int tii=obja.nextInt();
			              db.ATeacher(tii);
			              break;
			    case '7': System.out.println("Retrieving all students details");
			              db.AllStudent();
			              break;
			    case '8': System.out.println("Retrieving a particular teachers detail");          
			              db.AllTeacher();
			              break;
			    case '9': return;
			    default:  System.out.println("Enter a valid choice!!");
			              break; 
			               
			    
			    
			    }
			    System.out.println("Do you want to go back to Admin Operations(Y/N)");
			    cha = obja.next().charAt(0);
			    
			}while(cha=='y'||cha=='Y');
		
	

	}	
	

}

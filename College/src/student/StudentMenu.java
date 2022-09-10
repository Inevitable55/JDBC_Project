package student;

import java.util.Scanner;

import dbModule.RealDb;

public class StudentMenu {
	RealDb db = new RealDb();
	public void Studentmenu(int rol) {
		char cha;
	    Scanner objtm = new Scanner(System.in); 
			do {
				
			
			    System.out.println("Student portal\n");
			    System.out.println("1) See own details");
			    System.out.println("2) See marks");
			    System.out.println("3) Exit");
			    System.out.println("Enter your choice:-");
			    char ch = objtm.next().charAt(0);

			    switch(ch) {
			    case '1': System.out.println("Details of "+rol);	        
					      db.AStudent(rol);			              
			              break;
			    case '2': System.out.println("Showing Marks of rollnumber "+rol);     
			              db.showMark(rol);
			              break;
			    case '3': return;
			    
			    default: System.out.println("Enter a valid choice!");
			             break;
               }
			    System.out.println("Do you want to go back to teacher menu?(Y/N)");
			     cha= objtm.next().charAt(0);
			}while(cha=='y'||cha=='Y');
       }
	}

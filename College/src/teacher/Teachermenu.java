package teacher;

import java.util.Scanner;

import admin.adminops;
import dbModule.RealDb;

public class Teachermenu {
	 RealDb db = new RealDb();
		public void teachermenu() {
			char cha;
		    Scanner objtm = new Scanner(System.in); 
				do {
					
				
				    System.out.println("Teacher portal\n");
				    System.out.println("1) Enter marks for a student");
				    System.out.println("2) Exit");
				    System.out.println("Enter your choice:-");
				    char ch = objtm.next().charAt(0);

				    switch(ch) {
				    case '1': System.out.println("Adding marks for a particular Student");	        
				              System.out.println("Enter roll number:-");
				              int rol =objtm.nextInt(); 
				              
				              if(db.scheck(rol)) {
				            	  System.out.println("Enter subject 1 mark:-");
				            	  int m1 = objtm.nextInt();
				            	  System.out.println("Enter subject 2 mark:-");
				            	  int m2 = objtm.nextInt();
				            	  System.out.println("Enter subject 3 mark:-");
				            	  int m3 = objtm.nextInt();
				            	  System.out.println("Enter subject 4 mark:-");
				            	  int m4 = objtm.nextInt();
                                 db.AddMark(rol, m1, m2, m3, m4);
				              }
				              else
				            	  System.out.println("Student doesnt exist");
				              break;
				              
				    case '2': return;
				    
				    default: System.out.println("Enter a valid choice!");
				             break;
                   }
				    System.out.println("Do you want to go back to teacher menu?(Y/N)");
				     cha= objtm.next().charAt(0);
				}while(cha=='y'||cha=='Y');
		}
}

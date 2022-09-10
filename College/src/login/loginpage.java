package login;
import admin.*;
import teacher.*;
import student.*;
import dbModule.RealDb;
import java.util.Scanner;

public class loginpage {
	
            @SuppressWarnings("resource")
			public static void main(String[] args) {
	
                       char ch2;
						do {
						    Scanner obj = new Scanner(System.in);
						    System.out.println("   Login Portal\n");
						    System.out.println("1) Admin Login");
						    System.out.println("2) Teacher Login");
						    System.out.println("3) Student Login");
						    System.out.println("4) Exit ");
						    System.out.println("Enter your choice:-");
						    char ch = obj.next().charAt(0);
						    switch(ch) {
						    case '1': System.out.println("Admin Login");
						              adminauthenti ad = new adminauthenti();
						              System.out.println("Enter admin username:-");
						              String au=obj.next();
						              ad.setAuser(au);
						              System.out.println("Enter admin pass:-");
						              String ap=obj.next();
						              ad.setApass(ap);
						              if(ad.isAuthenticate()) {
						            	   System.out.println("Account exists");
						                   Adminmenu adm = new Adminmenu();
						                    adm.adminMenu();
						               }
						              else
						            	  System.out.println("Acoount doesnt exist");
						              break;
						              
						    case '2': System.out.println("Teacher Login");
								      Teachauth to = new Teachauth();				             
						              System.out.println("Enter teacher ID:-");
						              int ti=obj.nextInt();
						                to.setTid(ti);
						              System.out.println("Enter  password:-");
						              String tp=obj.next();
						                to.setTpass(tp);
						              if(to.isAuthenticatedTeacher()) {
						            	   System.out.println("Account exists");
						                   Teachermenu tm = new Teachermenu();
						                   tm.teachermenu();
						               }
						              else
						            	  System.out.println("Account doesnt exist");
						              break;
							case '3': System.out.println("Student Login");
								      Studentauth so = new Studentauth();		             
						              System.out.println("Enter Student roll number :-");
						              int sr=obj.nextInt();
						                so.setSid(sr);
						              System.out.println("Enter  password:-");
						              String sp=obj.next();
						                so.setSpass(sp);
						              if(so.isAuthenticatedStudent()) {
						            	   System.out.println("Account exists");
						                   RealDb dbs = new RealDb();
						                   StudentMenu sm = new StudentMenu();
						                   sm.Studentmenu(sr);
						               }
						              else
						            	  System.out.println("Account doesnt exist");
								              break;
						   
						    case '4': return;
						    default: System.out.println("Enter a valid choice!!");
						             break; 
						               
						    
						    
						    }
						    System.out.println("Do you want to go back to main login page(Y/N)");
						    ch2 = obj.next().charAt(0);

						}while(ch2=='y'||ch2=='Y');
            }
            
}
						

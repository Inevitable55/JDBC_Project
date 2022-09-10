package student;

import dbModule.RealDb;

public class Studentauth {
	private int srol;
    private String spass;


      public void setSid(int rol) {
    	  			srol = rol;
            }

      public void setSpass(String pass) {
    	  			spass = pass;
			}
      public boolean isAuthenticatedStudent() {
    	    RealDb db = new RealDb();
    	    if(db.studentauth(this.srol,this.spass)) {
    	    	System.out.println("Login Successful");
    	    	return true;
    	     }
    	    	
    	    System.out.println("Login Unsuccessful");
    	    return false;
    	    	
      }
	
	}
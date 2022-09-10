package admin;

import dbModule.*;
public class adminauthenti {
	private String Auser;
    private String Apass;


      public void setAuser(String auser) {
    	  			Auser = auser;
            }

      public void setApass(String apass) {
    	  			Apass = apass;
			}
      public boolean isAuthenticate() {
    	    RealDb db = new RealDb();
    	    if(db.adminAuth(this.Auser,this.Apass)) {
    	    	System.out.println("Login Successful");
    	    	return true;
    	     }
    	    	
    	    System.out.println("Login Unsuccessful");
    	    return false;
    	    	
      }
	
	}

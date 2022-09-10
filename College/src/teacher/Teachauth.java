package teacher;

import dbModule.RealDb;

public class Teachauth {
	private int tid;
    private String tpass;


      public void setTid(int id) {
    	  			tid = id;
            }

      public void setTpass(String pass) {
    	  			tpass = pass;
			}
      public boolean isAuthenticatedTeacher() {
    	    RealDb db = new RealDb();
    	    if(db.teachauth(this.tid,this.tpass)) {
    	    	System.out.println("Login Successful");
    	    	return true;
    	     }
    	    	
    	    System.out.println("Login Unsuccessful");
    	    return false;
    	    	
      }
	
	}


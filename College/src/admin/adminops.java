package admin;
import dbModule.*;
import java.util.Scanner;

public class adminops {
	  private String fname;
	  private String lname;
	  private int rollno;
	  private String address;
	  private int cl;
	  private String email;
	  private String phone;
	  private int tid;
	  private String tfname;
	  private String tlname;
	  private String sub;
	  private String tmail;
	  private String tph;
	  private String tpass;
	  private String spass;
	
	public  void getinfo() {
		Scanner objs = new Scanner(System.in);
		
		System.out.println("Enter roll number:- ");
        int rn = objs.nextInt();
        setRollno(rn);
        System.out.println("Enter First name:- ");
        String fn = objs.next();
        setFname(fn);
        System.out.println("Enter Last name:- ");
        String ln = objs.next();
        setLname(ln);
        System.out.println("Enter the class:- ");
        int c = objs.nextInt();
        setCl(c);
        System.out.println("Enter address:- ");
        String addd = objs.next();
        setAddress(addd);
        System.out.println("Enter Email:- ");
        String em = objs.next();
        setEmail(em);
        System.out.println("Enter phone number:- ");
        String ph = objs.next();
        setPhone(ph);
        System.out.println("Make a password for" +this.fname+" ");
        String sp = objs.next();
        setSpass(sp);
        System.out.println("data taken");
		
        
        }
	
	public  void getinfot() {
		Scanner objt = new Scanner(System.in);
		
		System.out.println("Enter Teacher Id:- ");
        int tidd = objt.nextInt();
        setTid(tidd);
        System.out.println("Enter First name:- ");
        String tfn = objt.next();
        setTfname(tfn);
        System.out.println("Enter Last name:- ");
        String tln = objt.next();
        setTllname(tln);
        System.out.println("Enter the subject of the teacher:- ");
        String suub = objt.next();
        setSub(suub);
        System.out.println("Enter Email:- ");
        String tem = objt.next();
        setTmail(tem);
        System.out.println("Enter phone number:- ");
        String tphh = objt.next();
        setTph(tphh);
        System.out.println("Make a password for" +this.fname+" ");
        String tp = objt.next();
        setTpass(tp);
        System.out.println("data taken");
		
        
        
        
        
	}
	public  void puttind() {
        RealDb dbt = new RealDb();

		dbt.AddTeacher(this.tid,this.tfname,this.tlname,this.sub,this.tmail,this.tph,this.tpass);

	}
	

	public void putindb() {
        RealDb dbs = new RealDb();

		dbs.AddStudent(this.rollno, this.fname, this.lname,this.cl,this.address,this.email,this.phone,this.spass);
		
	}
	
	//admin student attributes setters
	
	public  void setEmail(String semail) {
		email = semail;
	}

	

	public   void setPhone(String phone) {
		this.phone =phone;
	}

	public   void setFname(String fname) {
		this.fname = fname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public   void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public   void setCl(int scl) {
		this.cl = scl;
	}
	//admin teacher attributes setters
	
	public void setTid(int tid) {
		this.tid = tid;
	}
	public void setTfname(String tfname) {
		this.tfname = tfname;
	}
	public void setTllname(String tlname) {
		this.tlname = tlname;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public void setTmail(String tmail) {
		this.tmail = tmail;
	}
	public void setTph(String tph) {
		this.tph = tph;
	}

	public void setTpass(String tpass) {
		this.tpass = tpass;
	}

	public void setSpass(String spass) {
		this.spass = spass;
	}
   
}

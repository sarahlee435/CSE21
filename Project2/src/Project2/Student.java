package Project2;

import Project2.Date;
import Project2.Preference;
import Project2.Student;

public class Student {

	private int month;
	private int day;
	private int year;
	private static int  music;
	private static int  reading;
	private static int  chatting;
	private static int quietTime;

	String name;
	char gender; //Store M or F
	Date birthdate=new Date(month, day, year); //store the student’s date of birth
	Preference pref=new Preference(quietTime,music,reading, chatting);//store their answers to four activities
	boolean matched;//convey whether there is a match

	public Student(String name, char gender, Date birthdate, Preference pref) {
		this.name=name;
		this.gender=gender; 
		this.birthdate=birthdate;
		this.pref=pref;

	}
	public String getname() {
		return name;		
	}


	public char getgender() {
		return gender;

	}


	public Date getbirthdate() {
		return birthdate;

	}

	public Preference getpref() {		
		return pref;

	}

	public boolean getmatched() {		
		return matched;

	}
	
	public void setmatched(boolean matched) {		
		this.matched=matched;

	}


	public int compare(Student st) {

		int compScore=0;//compatibility score

		int  prefComp= pref.compare(st.pref);
		int birthComp = birthdate.compare(st.birthdate);

		compScore = (40 - prefComp) + (60 - birthComp);
		if (st.gender=='M'&& this.gender=='F') {
			compScore=0;

		}else if (st.gender=='F'&& this.gender=='M') {
			compScore=0;

		}

		return compScore; 
	}
}

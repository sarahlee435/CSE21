package Project2;

public class Date {


	int month; //range 1-12
	int day; //range 1 to 31 and appropriate to month, Feb always 28 days
	int year;//range 1900 to 3000
	public Date(int month, int day, int year) {
		this.month=month; 
		this.day=day; 
		this.year=year; 

	}
	public int dayOfYear() {
		int totalDays = 0;
		switch (month) {
		case 12: totalDays += 30;
		case 11: totalDays += 31;
		case 10: totalDays += 30;
		case 9 : totalDays += 31;
		case 8 : totalDays += 31;
		case 7 : totalDays += 30;
		case 6 : totalDays += 31;
		case 5 : totalDays += 30;
		case 4 : totalDays += 31;
		case 3 : totalDays += 28;
		case 2 : totalDays += 31;
		}
		totalDays += day;
		return totalDays;
	}


	public int monthOfYear() {
		int totalmonth = month;
		if ((1>totalmonth)||(totalmonth<13)) {
			return totalmonth;
		}else {
			return -1;
		}

	}

	public int Year() {
		if ((1900<=year)||(year<=3000)) {
			return year;
		}else {
			return -1;
		}	
	}

	public int Month() {
		if ((1<=month)||(month<=12)) {
			return month;
		}else {
			return -1;
		}	
	}

	public int Day() {
		return day;
	}

	public int compare(Date dt) { //in number of months

		int yearsDifferenceInDays=dt.dayOfYear()+(365*dt.year);
		int daysDifference=this.dayOfYear()+(365*this.year);
		int totalDifference=yearsDifferenceInDays-daysDifference;
		int monthsDifference=totalDifference/30;


		if(monthsDifference>60) {
			return 60;
		}

		return monthsDifference; 

	}
}

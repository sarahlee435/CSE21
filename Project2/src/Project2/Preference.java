package Project2;

public class Preference {

	int quietTime; //0-10 inclusive (0=hate, 10=love)
	int music; 
	int reading; 
	int chatting;


	public Preference(int quietTime, int music, int reading, int chatting) {
		this.quietTime=quietTime; 
		this.music=music; 
		this.reading=reading; 
		this.chatting=chatting;
	}
	public int getquietTime() {
		if ((11>quietTime)||(quietTime<0)) {
			return quietTime;
		}else {
			return -1;
		}	
	}

	public int getmusic() {
		if ((11>music)||(music<0)) {
			return music;
		}else {
			return -1;
		}	
	}

	public int getreading() {
		if ((11>reading)||(reading<0)) {
			return reading;
		}else {
			return -1;
		}	
	}

	public int getchatting() {
		if ((11>chatting)||(chatting<0)) {
			return chatting;
		}else {
			return -1;
		}	
	}

	public int compare(Preference pref) {

		int quietDif=Math.abs(pref.getquietTime()-this.getquietTime());
		int musicDif= Math.abs(pref.getmusic()-this.getmusic());
		int readingDif=Math.abs(pref.getreading()-this.getreading());
		int chattingDif=Math.abs(pref.getchatting()-this.getchatting());

		int totalPref=quietDif+musicDif+readingDif+chattingDif;

		return totalPref;

	}
}

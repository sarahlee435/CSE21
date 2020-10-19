package Project2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;


public class Match {
	static final int MAX_STUDENTS=100;

	public static void main(String[] args) throws IOException {
		File fileRoster =new File ("C:/Users/Sarah L/eclipse-workspace/Project2/src/Project2/FullRoster.txt");
		File fileStudents =new File ("C:/Users/Sarah L/eclipse-workspace/Project2/src/Project2/Students.txt");
				
		String gender;
		String name;
		String lastName;
		String word;
		int quietTime;
		int music;
		int reading;
		int chatting;
		int day;
		int month;
		int year;
		String date;

		Student [] arr = new Student [MAX_STUDENTS];

		//Scanner input=new Scanner(new FileReader(fileStudents)).useDelimiter(",\\s*");
		Scanner input=new Scanner(new FileReader(fileRoster)).useDelimiter(",\\s*");
		
		int count = 0;

		while (input.hasNextLine()){

			Scanner data = new Scanner(input.nextLine());
			
			//Student inputs
			data.useDelimiter("[\t\r]"); 
			name = data.next(); 
			gender = data.next(); 
			date = data.next(); 
			
			//Birthday inputs
			Scanner birthDateReader = new Scanner (date);
			birthDateReader.useDelimiter("-");
			month = birthDateReader.nextInt();
			day = birthDateReader.nextInt();
			year = birthDateReader.nextInt();

			//Preference inputs
			quietTime = data.nextInt();
			music = data.nextInt();
			reading = data.nextInt(); 
			chatting = data.nextInt(); 

			//Inputs into the classes
			Preference pref = new Preference(quietTime, music, reading, chatting);
			
			Date birthdate = new Date (month, day, year);
			
			Student students = new Student(name, gender.charAt(0), birthdate, pref);
			
			arr[count++] = students;

		}


		int max = count;
		
		for (int i = 0; i<max; i++){
			if (!arr[i].getmatched()){ //For each student NOT currently matched
				int bestMatchScore = 0; 
				int bestMatchStudent = 0;
				
				for (int student=i+1; student < max; student++){
					if(!arr[student].getmatched()){ //For rest of students NOT currently matched
						int currentScore = arr[i].compare(arr[student]); //currentScore = studentA.compare(studentB)
						if (currentScore > bestMatchScore){//if the currentScore is better than MaxScore
							bestMatchScore = currentScore; //bestMatchScore is currentScore 
							bestMatchStudent = student; //bestMatchStudent is student
						}
					}
				}
				//Prints out matches and who is left
				if (bestMatchScore != 0){
					arr[i].setmatched(true);
					arr[bestMatchStudent].setmatched(true);
					System.out.println(arr[i].getname() + " matches with " + arr[bestMatchStudent].getname() + " with the score " + bestMatchScore+".");
				} else {
					if (!arr[i].getmatched())
						System.out.println(arr[i].getname() + " has no matches.");}
			}


		}
	}
}
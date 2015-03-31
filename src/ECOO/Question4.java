package ECOO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question4 {
//QUESTIOn 4//RAYMOND NOT MINE
	public static int counter = 0;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
		Scanner input = new Scanner(new File("DATA41.txt"));
		for (int i = 0; i < 10; i++) {
			counter = 0;
			String word = input.nextLine();
			check(word);
			System.out.println(counter);
			
		}

	


	}

	public static void check(String stringa){
		if (stringa.length()>= 3 &&stringa.substring(0, 3).equals("ook")){
			String temp = stringa.substring(3, stringa.length());
			check(temp);
		}
		if (stringa.length()>= 6 && stringa.substring(0, 6).equals("ookook")){
			String temp = stringa.substring(6, stringa.length());
			check(temp);
		}
		if (stringa.length()>= 3 &&stringa.substring(0, 3).equals("oog")){
			String temp = stringa.substring(3, stringa.length());
			check(temp);
		}
		if (stringa.length()>= 4 &&stringa.substring(0, 4).equals("ooga")){
			String temp = stringa.substring(4, stringa.length());
			check(temp);
		}
		if (stringa.length()>= 2 &&stringa.substring(0, 2).equals("ug")){
			String temp = stringa.substring(2, stringa.length());
			check(temp);
		}
		if (stringa.length()>= 4 &&stringa.substring(0, 4).equals("mook")){
			String temp = stringa.substring(4, stringa.length());
			check(temp);
		}
		if (stringa.length()>= 8 &&stringa.substring(0, 8).equals("mookmook")){
			String temp = stringa.substring(8, stringa.length());
			check(temp);
		}
		if (stringa.length()>= 5 &&stringa.substring(0, 5).equals("oogam")){
			String temp = stringa.substring(5, stringa.length());
			check(temp);
		}
		if (stringa.length()>= 5 &&stringa.substring(0, 5).equals("oogum")){
			String temp = stringa.substring(5, stringa.length());
			check(temp);
		}
		if (stringa.length()>= 4 &&stringa.substring(0, 4).equals("ugug")){
			String temp = stringa.substring(4, stringa.length());
			check(temp);
		}
		else{
			if (stringa.equals("")){
				counter += 1;
			}
		}


	}

}


package com.harsay.ld31;

public class Stopwatch {
	
	public static int seconds = 0;
	public static int minutes = 0;
	public static int milliseconds = 0;
	
	public static void update(float delta) {
		milliseconds += delta*1000;
		if(milliseconds >= 1000) {
			milliseconds -= 1000;
			seconds++;
		}
		if(seconds == 60) {
			seconds = 0;
			minutes++;
		}
	}
	
	public static String getString() {
		String secZer = "";
		String minZer = "";
		String msZer = "";
		
		if(seconds < 10) {
			secZer = "0";
		}
		
		if(minutes < 10) {
			minZer = "0";
		}
		
		if(milliseconds < 10) {
			msZer = "00";
		}
		
		if(milliseconds < 100) {
			msZer = "0";
		}
		
		return minZer+minutes+":"+secZer+seconds+":"+msZer+milliseconds;
	}

}

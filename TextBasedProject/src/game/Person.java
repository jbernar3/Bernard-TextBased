package game;

import java.util.Scanner;

public class Person {
	private String name;
	public void askForName() {

		System.out.println("What's your name?");
		
		Scanner scName = new Scanner(System.in);
		String playerName = scName.nextLine();
		
		while (playerName.isEmpty()) {
			System.out.println("Sorry? What's your name?");
			playerName = scName.nextLine();
		}
    	
    		
		this.name = playerName;
		
	}
}

package application;

import java.util.Date;

import model.entities.Class;
import model.entities.Hero;

public class Program {

	public static void main(String[] args) {
		
		Class obj = new Class(1, "Knight");
		System.out.println(obj);	 

		Hero hero = new Hero(21, "BOB", "bob", new Date(), 20.0, obj);
		System.out.println(hero);
		
	}

}

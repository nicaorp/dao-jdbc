package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.HeroDao;
import model.entities.Class;
import model.entities.Hero;

public class Program {

	public static void main(String[] args) {
		

		HeroDao heroDao = DaoFactory.createHeroDao();
		
		System.out.println("=== Teste: Seller findById ===");
		Hero hero = heroDao.findById(12);
		System.out.println(hero);
		
		System.out.println("\n=== Teste: Seller findByClass ===");
		Class cla = new Class(2, null);
		List<Hero> list = heroDao.findByDepartment(cla);
		for (Hero h : list) {
			System.out.println(h);
		}
		System.out.println("\n=== Teste: Seller findAll ===");
		list = heroDao.findAll();
		for (Hero h : list) {
			System.out.println(h);
		}
		
//		System.out.println("\n=== Teste: Insert");
//		Hero newHero = new Hero(null, "Vibe", "vibe100", new Date(), 30.0, cla);
//		heroDao.insert(newHero);
//		System.out.println("Inserted! New Id: " + newHero.getId());
		
		System.out.println("\n=== Teste: Update");
		hero = heroDao.findById(1);
		hero.setChampLevel(80.0);
		heroDao.update(hero);
		System.out.println(hero);
		
		
	}

}

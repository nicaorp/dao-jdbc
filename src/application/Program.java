package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.HeroDao;
import model.entities.Class;
import model.entities.Hero;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		HeroDao heroDao = DaoFactory.createHeroDao();
		
		System.out.println("=== Teste: Hero findById ===");
		Hero hero = heroDao.findById(12);
		System.out.println(hero);
		
		System.out.println("\n=== Teste: Hero findByClass ===");
		Class cla = new Class(2, null);
		List<Hero> list = heroDao.findByDepartment(cla);
		for (Hero h : list) {
			System.out.println(h);
		}
		System.out.println("\n=== Teste: Hero findAll ===");
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

		System.out.println("\n=== Teste: Delete");
		System.out.println("Enter id for delete: ");
		int id = sc.nextInt();
		heroDao.deleteById(id);
		System.out.println("Delete completed!");
		sc.close();
		
		
	}

}

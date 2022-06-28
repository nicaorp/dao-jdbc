package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.HeroDao;
import model.entities.Hero;
import model.entities.Class;

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
		
	}

}

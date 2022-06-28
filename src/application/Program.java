package application;

import model.dao.DaoFactory;
import model.dao.HeroDao;
import model.entities.Hero;

public class Program {

	public static void main(String[] args) {
		

		HeroDao heroDao = DaoFactory.createHeroDao();
		
		System.out.println("=== Teste: Seller findById ===");
		Hero hero = heroDao.findById(12);
		System.out.println(hero);
	}

}

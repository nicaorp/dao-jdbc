package model.dao;

import model.dao.impl.HeroDaoJDBC;

public class DaoFactory {

	public static HeroDao createHeroDao() {
		return new HeroDaoJDBC();
	}
	
}

package model.dao;

import db.DB;
import model.dao.impl.HeroDaoJDBC;

public class DaoFactory {

	public static HeroDao createHeroDao() {
		return new HeroDaoJDBC(DB.getConnection());
	}
	
}

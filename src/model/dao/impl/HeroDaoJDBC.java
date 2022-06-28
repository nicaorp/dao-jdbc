package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.HeroDao;
import model.entities.Class;
import model.entities.Hero;

public class HeroDaoJDBC implements HeroDao {

	private Connection conn;
	
	public HeroDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void insert(Hero obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Hero obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hero findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT hero.*, class.Name as ClassName "
					+ "FROM hero INNER JOIN class "
					+ "ON hero.ClassId = class.Id "
					+ "WHERE hero.Id = ?");
					st.setInt(1, id);
					
					rs = st.executeQuery();
					if (rs.next()) {
						Class cla = new Class();
						cla.setId(rs.getInt("ClassId"));
						cla.setName(rs.getString("ClassName"));
						Hero hero = new Hero();
						hero.setId(rs.getInt("Id"));
						hero.setName(rs.getString("Name"));
						hero.setLogin(rs.getString("login"));
						hero.setCreatedDate(rs.getDate("CreatedDate"));
						hero.setChampLevel(rs.getDouble("ChampLevel"));
						hero.setWhichClass(cla);
						return hero;
					}
					return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		
	}

	@Override
	public List<Hero> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

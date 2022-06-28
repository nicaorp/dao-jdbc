package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					 "INSERT INTO hero "
					+ "(Name, login, CreatedDate, ChampLevel, ClassId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getName());
			st.setString(2, obj.getLogin());
			st.setDate(3, new java.sql.Date(obj.getCreatedDate().getTime()));
			st.setDouble(4, obj.getChampLevel());
			st.setInt(5, obj.getWhichClassId().getId());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro inesperado, nenhuma linha foi afetada.");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			
		}
		
	}

	@Override
	public void update(Hero obj) {

		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					 "UPDATE hero "
					+ "SET Name = ?, login = ?, CreatedDate = ?, ChampLevel = ?, ClassId = ? "
					+ "WHERE Id = ?");
			
			st.setString(1, obj.getName());
			st.setString(2, obj.getLogin());
			st.setDate(3, new java.sql.Date(obj.getCreatedDate().getTime()));
			st.setDouble(4, obj.getChampLevel());
			st.setInt(5, obj.getWhichClassId().getId());
			st.setInt(6, obj.getId());
			
			st.executeUpdate();
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			
		}

		
		
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
						Class cla = instantiateClass(rs);
						Hero hero = instantiateHero(rs, cla);
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

	private Hero instantiateHero(ResultSet rs, Class cla) throws SQLException {
		Hero hero = new Hero();
		hero.setId(rs.getInt("Id"));
		hero.setName(rs.getString("Name"));
		hero.setLogin(rs.getString("login"));
		hero.setCreatedDate(rs.getDate("CreatedDate"));
		hero.setChampLevel(rs.getDouble("ChampLevel"));
		hero.setWhichClass(cla);
		return hero;
	}


	private Class instantiateClass(ResultSet rs) throws SQLException {
		Class cla = new Class();
		cla.setId(rs.getInt("ClassId"));
		cla.setName(rs.getString("ClassName"));
		return cla;
	}


	@Override
	public List<Hero> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT hero.*, class.Name as ClassName "
					+ "FROM hero INNER JOIN class "
					+ "ON hero.ClassId = class.Id "
					+ "ORDER BY Id");
			
					
					
					rs = st.executeQuery();
					
					List<Hero> list = new ArrayList<>();
					Map<Integer, Class> map = new HashMap<>();
					
					while (rs.next()) {
						
						Class cla = map.get(rs.getInt("ClassId"));
						
						if (cla == null) {
							cla = instantiateClass(rs);
							map.put(rs.getInt("ClassId"), cla);
						}
						

						Hero hero = instantiateHero(rs, cla);
						list.add(hero);
					}
					return list;
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
	public List<Hero> findByDepartment(Class clas) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT hero.*, class.Name as ClassName "
					+ "FROM hero INNER JOIN class "
					+ "ON hero.ClassId = class.Id "
					+ "WHERE ClassId = ? "
					+ "ORDER BY Name");
			
					st.setInt(1, clas.getId());
					
					rs = st.executeQuery();
					
					List<Hero> list = new ArrayList<>();
					Map<Integer, Class> map = new HashMap<>();
					
					while (rs.next()) {
						
						Class cla = map.get(rs.getInt("ClassId"));
						
						if (cla == null) {
							cla = instantiateClass(rs);
							map.put(rs.getInt("ClassId"), cla);
						}
						

						Hero hero = instantiateHero(rs, cla);
						list.add(hero);
					}
					return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

}

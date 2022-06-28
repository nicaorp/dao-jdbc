package model.dao;

import java.util.List;

import model.entities.Hero;

public interface HeroDao {

	void insert(Hero obj);
	void update(Hero obj);
	void deleteById(Integer id);
	Hero findById(Integer id);
	List<Hero> findAll();
	
}
package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Hero implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String login;
	private Date createdDate;
	private Double champLevel;
	
	private Class whichClass;
	
	public Hero() {}

	public Hero(Integer id, String name, String login, Date createdDate, Double champLevel, Class classId) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.createdDate = createdDate;
		this.champLevel = champLevel;
		this.whichClass = whichClass;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Double getChampLevel() {
		return champLevel;
	}

	public void setChampLevel(Double champLevel) {
		this.champLevel = champLevel;
	}

	public Class getWhichClassId() {
		return whichClass;
	}

	public void setWhichClass(Class whichClass) {
		this.whichClass = whichClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hero other = (Hero) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", login=" + login + ", createdDate=" + createdDate
				+ ", champLevel=" + champLevel + ", whichClass=" + whichClass + "]";
	}

	
	
	
}

package model;

import java.util.ArrayList;
import java.util.List;

public class TownCatalogModel {
	
	private List<Town> towns;

	public List<Town> getTowns() {
		return towns;
	}

	public void setTowns(List<Town> towns) {
		this.towns = towns;
	}

	public TownCatalogModel() {
		towns = new ArrayList<>();
		towns.add(new Town("Szabadka", 1852));
		towns.add(new Town("Szeged", 1721));
	}

	public List<Town> ListTowns() {
		
		return getTowns();
	}

	public boolean addTown(Town t) {
		
		try {
			towns.add(t);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}

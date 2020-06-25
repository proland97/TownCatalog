package controller;

import java.util.List;
import model.Town;
import model.TownCatalogModel;
import view.TownCatalogGui;

public class TownCatalogController {
	
	private TownCatalogGui gui;
	private TownCatalogModel model;
	
	public TownCatalogController() {
	}

	public void startDesktop() {
		
		model = new TownCatalogModel();
		gui = new TownCatalogGui(this);
		
		gui.startGui();
	}
	
	public List<Town> ListTowns() {
		return model.ListTowns();
	}

	public boolean addTown(Town t) {
		return model.addTown(t);
		
	}

}

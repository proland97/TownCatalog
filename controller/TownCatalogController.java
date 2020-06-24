package controller;

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
	
	public void ListTowns() {
		model.sayHi();
	}

}

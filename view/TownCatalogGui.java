package view;
import javax.swing.*;

import controller.TownCatalogController;

public class TownCatalogGui extends JFrame{
	
	TownCatalogController controller;

	public TownCatalogGui(TownCatalogController townCatalogController) {
		controller = townCatalogController;
	}

	public void startGui() {
	
		SwingUtilities.invokeLater(()->{
			createAndShowGui();
		});
		
	}

	private void createAndShowGui() {
		
		setTitle("My first Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setJMenuBar(createMneBar());
		
		setSize(400, 400);
		setVisible(true);
	}

	private JMenuBar createMneBar() {
		
		JMenuBar menubar = new JMenuBar();
		
		JMenu menu = new JMenu("Towns");
		
		JMenuItem listTowns = new JMenuItem("List towns");
		menu.add(listTowns);
		menubar.add(menu);
		
		listTowns.addActionListener( e -> {
			controller.ListTowns();
		});
		
		return menubar;
	}

}

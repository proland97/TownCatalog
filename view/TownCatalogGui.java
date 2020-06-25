package view;
import javax.swing.*;

import controller.TownCatalogController;
import model.Town;

public class TownCatalogGui extends JFrame{
	
	private static final long serialVersionUID = 115085300564459765L;
	private TownCatalogController controller;

	public TownCatalogController getController() {
		return controller;
	}

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
		
		JMenuItem addTown = new JMenuItem("Add town");

		
		listTowns.addActionListener( e -> {
			
			for (Town t : controller.ListTowns()) {
				System.out.println(t);
			}
		});
		
		addTown.addActionListener( e -> {
			new AddTownDialog(this);
		});
		
		menu.add(listTowns);
		menu.add(addTown);
		
		menubar.add(menu);
		
		return menubar;
	}

}

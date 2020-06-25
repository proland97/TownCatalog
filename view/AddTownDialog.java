package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import model.Town;

public class AddTownDialog extends JDialog {

	private static final long serialVersionUID = 7220633192624934840L;
	private TownCatalogGui gui;
	private JTextField townName;
	private JSpinner townFunded;

	public AddTownDialog(TownCatalogGui townCatalogGui) {
		this.gui = townCatalogGui;
		
		createDialog();
	}

	private void createDialog() {
		
		setTitle("Add town");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		add(createInputPanel(), BorderLayout.CENTER);
		add(createButtonPanel(), BorderLayout.CENTER);
		
		pack();
		setVisible(true);
		
	}

	private JPanel createInputPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(new JLabel("Town name"));
		townName = new JTextField(10);
		panel.add(townName);
		panel.add(new JLabel("Town funded"));
		townFunded = new JSpinner();
		panel.add(townFunded);

		return panel;
	}
	
	private JPanel createButtonPanel() {
		JPanel panel = new JPanel();
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton okButton = new JButton("OK");
		JButton cancelButton = new JButton("Cancel");
		
		okButton.addActionListener(e->{
			String name = townName.getText();
			int funded = (int) townFunded.getValue();
			
			Town t = new Town(name, funded);
			
			if(gui.getController().addTown(t)) {
				System.out.println("Success");
				this.dispose();
			}else {
				System.out.println("Fail");
			}
			
		});
		
		cancelButton.addActionListener(e -> {
			this.dispose();
		});
		
		panel.add(okButton);
		panel.add(cancelButton);
		return panel;
	}

}

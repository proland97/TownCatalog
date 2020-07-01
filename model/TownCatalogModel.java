package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TownCatalogModel {
	
	private Connection conn;
	
	public TownCatalogModel() {
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/towntest", "roland", "roland");
			System.out.println("Database connected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Town> ListTowns() {
		
		ArrayList<Town> list = new ArrayList<>();
		ResultSet rs;
		
		try {
			Statement stat = conn.createStatement();
			rs = stat.executeQuery("SELECT * FROM towns");
			
			while(rs.next()) {
				Town t = new Town(rs.getString("Name"), rs.getInt("Funded"));
				list.add(t);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public boolean addTown(Town t) {
		return true;
	}

}

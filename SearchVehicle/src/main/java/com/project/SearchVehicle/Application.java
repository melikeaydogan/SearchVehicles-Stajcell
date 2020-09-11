package com.project.SearchVehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		Connection conn = null;
 
        try {
            // registers Oracle JDBC driver - though this is no longer required
            // since JDBC 4.0, but added here for backward compatibility
            Class.forName("oracle.jdbc.OracleDriver");
 
            // METHOD #1
            String dbURL1 = "jdbc:oracle:thin:/*username*/ / /*password*/ @ /*database*/";
            conn = DriverManager.getConnection(dbURL1);
            if (conn != null) {
                System.out.println("Connected.");
            }
 
            File file = new File("vehicles.txt");
    		
    		Scanner fileScan;
    		try {
    			fileScan = new Scanner(file);
    		} catch (FileNotFoundException e) {
    			System.out.print("File not found");
    			
    			return;
    		}
    		
    		while(fileScan.hasNext()) {
    			
    			String s = fileScan.next();
    			Vehicle nv = new Vehicle(s);
    			Statement st = conn.createStatement(); 
                st.executeUpdate("INSERT INTO MELIKE_VEHICLES " + 
                    "VALUES ("+nv.getId()+",'"+nv.getMarka()+"', '"+nv.getModel()+"', '"+nv.getSinif()+"')"); 
    			//System.out.print("Arac eklendi.\n" + nv.print());
    		}
    		
    		fileScan.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    System.out.print("Connection end.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
	}

}

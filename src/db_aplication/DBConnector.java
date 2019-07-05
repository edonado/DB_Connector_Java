/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_aplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Karo
 */
public class DBConnector {
    private final String DB = "mercado";
    private final String url = "jdbc:mysql://localhost/"+DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String user = "root";
    private final String pass = "";
    public String[] Sexo = new String[2];
    public int[] Total = new int[2];
    
    public void Connect(String sentence){
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection (url,user,pass);
            Statement query = connection.createStatement();
            ResultSet result = query.executeQuery(sentence);
            int n = 0;
            while(result.next()){
                Sexo[n] = result.getString("Sexo");
                Total[n] = Integer.parseInt(result.getString("Total"));
                n++;
            }
            connection.close();
        }catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "There is an error with the connection, please try again.", "ERROR",JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public String[] getSexo() {
        return Sexo;
    }

    public int[] getTotal() {
        return Total;
    }
    
}
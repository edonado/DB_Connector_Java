/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_aplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karo
 */
public class DB_Aplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBConnector con = new DBConnector();
        String sentence = "SELECT clientes.Sexo, SUM(compras.Cantidad * inventarios.Precio) AS Total FROM clientes AS clientes JOIN compras ON clientes.ID=compras.ID_Cliente JOIN inventarios ON inventarios.ID=compras.ID_Producto GROUP BY clientes.Sexo ORDER BY Total DESC";
        con.Connect(sentence);
        String[] Sexo = con.getSexo();
        int[] Total = con.getTotal();
        System.out.println("El sexo "+Sexo[0]+" fue el que más compró con un total de "+String.valueOf(Total[0])+".");
    }
    
}

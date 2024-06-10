/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private Connection cn;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdclinica", "root", "");
            System.out.println("CONECTADO");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
        return cn;
    }
}

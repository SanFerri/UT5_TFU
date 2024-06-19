package com.ada.olimpiadas.repositories;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ada.olimpiadas.models.Juez;
import com.ada.olimpiadas.models.Participante;

@Repository
public class JuezRepository implements IJuezRepository {

    @Override
    @Async
    public LinkedList<Juez> getJueces() {
        LinkedList<Juez> resultado = new LinkedList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/olimpiadas_db", "root", "olimpiadas");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT Juez.id, Juez.ci, Persona.nombre, Persona.apellido, Persona.contacto, Persona.email " +
                            "FROM Juez " +
                            "JOIN Persona ON Juez.ci = Persona.ci");

            while (rs.next()) {
                Juez juez = new Juez();
                juez.setId(rs.getInt("id"));
                juez.setCi(rs.getString("ci"));
                juez.setNombre(rs.getString("nombre"));
                juez.setApellido(rs.getString("apellido"));
                juez.setContacto(rs.getString("contacto"));
                juez.setEmail(rs.getString("email"));
                resultado.add(juez);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    @Override
    public boolean Puntuar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Puntuar'");
    }

    @Override
    public Juez getJuez(int id) {
        Juez resultado = new Juez();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/olimpiadas_db", "root", "olimpiadas");
            String query = "SELECT Juez.id, Juez.ci, Persona.nombre, Persona.apellido, Persona.contacto, Persona.email "
                    +
                    "FROM Juez " +
                    "JOIN Persona ON Juez.ci = Persona.ci WHERE Juez.id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                resultado.setId(rs.getInt("id"));
                resultado.setCi(rs.getString("ci"));
                resultado.setNombre(rs.getString("nombre"));
                resultado.setApellido(rs.getString("apellido"));
                resultado.setContacto(rs.getString("contacto"));
                resultado.setEmail(rs.getString("email"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

}

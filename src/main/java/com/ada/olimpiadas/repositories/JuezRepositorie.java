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

@Repository
public class JuezRepositorie implements IJuezRepositorie {

    @Override
    @Async
    public LinkedList<Juez> getJueces() {
        LinkedList<Juez> listaJueces = new LinkedList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/olimpiadas_db", "root", "olimpiadas");
            Statement stmt = con.createStatement();
            ResultSet ex = stmt.executeQuery("SELECT * FROM Juez");
            while (ex.next()) {
                Juez juez = new Juez();
                juez.setId(ex.getInt(1));
                juez.setCi(ex.getString(2));
                listaJueces.add(juez);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaJueces;
    }

    @Override
    public boolean Puntuar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Puntuar'");
    }

    @Override
    public Juez getJuez(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getJuez'");
    }

}

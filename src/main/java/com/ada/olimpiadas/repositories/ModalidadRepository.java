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

import com.ada.olimpiadas.models.Categoria;
import com.ada.olimpiadas.models.Disciplina;
import com.ada.olimpiadas.models.Juez;
import com.ada.olimpiadas.models.Modalidad;
import com.ada.olimpiadas.models.Participante;

@Repository
public class ModalidadRepository implements IModalidadRepository {

    @Override
    public LinkedList<Modalidad> getModalidades() {
        LinkedList<Modalidad> resultado = new LinkedList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/olimpiadas_db", "root", "olimpiadas");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM Modalidad ");

            while (rs.next()) {
                Modalidad mod = new Modalidad();
                mod.setId(rs.getInt("id"));
                mod.setNombre(rs.getString("nombre"));
                mod.setPuntaje_id(rs.getInt("puntaje_id"));
                mod.setDisciplina_id(rs.getInt("disciplina_id"));

                resultado.add(mod);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    @Override
    public Modalidad getModalidad(int id) {
        Modalidad resultado = new Modalidad();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/olimpiadas_db", "root", "olimpiadas");
            String query = "SELECT * FROM Modalidad where id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                resultado.setId(rs.getInt("id"));
                resultado.setDisciplina_id(rs.getInt("disciplina_id"));
                resultado.setNombre(rs.getString("nombre"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

}

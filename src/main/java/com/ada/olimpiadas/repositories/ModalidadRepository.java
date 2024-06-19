package com.ada.olimpiadas.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.springframework.stereotype.Repository;

import com.ada.olimpiadas.models.Modalidad;

@Repository
public class ModalidadRepository implements IModalidadRepository {

    @Override
    public LinkedList<Modalidad> getModalidades() {
        LinkedList<Modalidad> resultado = new LinkedList<>();
        try (Connection con = DatabaseConnection.getInstance().getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Modalidad");

            while (rs.next()) {
                Modalidad mod = new Modalidad();
                mod.setId(rs.getInt("id"));
                mod.setNombre(rs.getString("nombre"));
                mod.setPuntaje_id(rs.getInt("puntaje_id"));
                mod.setDisciplina_id(rs.getInt("disciplina_id"));

                resultado.add(mod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public Modalidad getModalidad(int id) {
        Modalidad resultado = new Modalidad();
        try (Connection con = DatabaseConnection.getInstance().getConnection()) {
            String query = "SELECT * FROM Modalidad WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                resultado.setId(rs.getInt("id"));
                resultado.setDisciplina_id(rs.getInt("disciplina_id"));
                resultado.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}

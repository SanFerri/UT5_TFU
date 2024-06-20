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
        LinkedList<Modalidad> modalidades = new LinkedList<>();
        try (Connection con = DatabaseConnection.getInstance().getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Modalidad")) {

            while (rs.next()) {
                Modalidad mod = mapResultSetToModalidad(rs);
                modalidades.add(mod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modalidades;
    }

    @Override
    public Modalidad getModalidad(int id) {
        Modalidad modalidad = new Modalidad();
        try (Connection con = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Modalidad WHERE id = ?")) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    modalidad = mapResultSetToModalidad(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modalidad;
    }

    private Modalidad mapResultSetToModalidad(ResultSet rs) throws SQLException {
        Modalidad resultado = new Modalidad();
        resultado.setId(rs.getInt("id"));
        resultado.setNombre(rs.getString("nombre"));
        resultado.setPuntaje_id(rs.getInt("puntaje_id"));
        resultado.setDisciplina_id(rs.getInt("disciplina_id"));
        return resultado;
    }
}

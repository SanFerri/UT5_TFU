package com.ada.olimpiadas.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.ada.olimpiadas.models.Juez;
import com.ada.olimpiadas.models.Modalidad;

@Repository
public class JuezRepository implements IJuezRepository {

    @Override
    @Async
    public LinkedList<Juez> getJueces() {
        LinkedList<Juez> resultado = new LinkedList<>();
        try (Connection con = DatabaseConnection.getInstance().getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT Juez.id, Juez.ci, Persona.nombre, Persona.apellido, Persona.contacto, Persona.email " +
                            "FROM Juez " +
                            "JOIN Persona ON Juez.ci = Persona.ci");

            while (rs.next()) {
                Juez juez = mapResultSetToJuez(rs);
                resultado.add(juez);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public Juez getJuez(int id) {
        Juez resultado = new Juez();
        try (Connection con = DatabaseConnection.getInstance().getConnection()) {
            String query = "SELECT Juez.id, Juez.ci, Persona.nombre, Persona.apellido, Persona.contacto, Persona.email "
                    +
                    "FROM Juez " +
                    "JOIN Persona ON Juez.ci = Persona.ci WHERE Juez.id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                resultado = mapResultSetToJuez(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    private Juez mapResultSetToJuez(ResultSet rs) throws SQLException {
        Juez resultado = new Juez();
        resultado.setId(rs.getInt("id"));
        resultado.setCi(rs.getString("ci"));
        resultado.setNombre(rs.getString("nombre"));
        resultado.setApellido(rs.getString("apellido"));
        resultado.setContacto(rs.getString("contacto"));
        resultado.setEmail(rs.getString("email"));
        return resultado;
    }
}

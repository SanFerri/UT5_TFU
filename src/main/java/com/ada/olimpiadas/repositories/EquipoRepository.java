package com.ada.olimpiadas.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.springframework.stereotype.Repository;

import com.ada.olimpiadas.models.Equipo;


@Repository
public class EquipoRepository implements IEquipoRepository {

    @Override
    public LinkedList<Equipo> getEquipos() {
        LinkedList<Equipo> resultado = new LinkedList<>();
        try (Connection con = DatabaseConnection.getInstance().getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM Equipo");

            while (rs.next()) {
                Equipo mod = mapResultSetToEquipo(rs);
                resultado.add(mod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
    
    private Equipo mapResultSetToEquipo(ResultSet rs) throws SQLException {
        Equipo resultado = new Equipo();
        resultado.setId(rs.getInt("id"));
        return resultado;
    }
}

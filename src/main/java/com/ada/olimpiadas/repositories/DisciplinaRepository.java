package com.ada.olimpiadas.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.springframework.stereotype.Repository;

import com.ada.olimpiadas.models.Disciplina;
import com.ada.olimpiadas.models.Modalidad;

@Repository
public class DisciplinaRepository implements IDisciplinaRepository {

    @Override
    public LinkedList<Disciplina> getDisciplinas() {
        LinkedList<Disciplina> resultado = new LinkedList<>();
        try (Connection con = DatabaseConnection.getInstance().getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Disciplina");

            while (rs.next()) {
                Disciplina mod = mapResultSetToDisciplina(rs);
                resultado.add(mod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public Disciplina getDisciplina(int id) {
        Disciplina resultado = new Disciplina();
        try (Connection con = DatabaseConnection.getInstance().getConnection()) {
            String query = "SELECT * FROM Disciplina WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                resultado = mapResultSetToDisciplina(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    private Disciplina mapResultSetToDisciplina(ResultSet rs) throws SQLException {
        Disciplina resultado = new Disciplina();
        resultado.setId(rs.getInt("id"));
        resultado.setNombre(rs.getString("nombre"));
        return resultado;
    }
}

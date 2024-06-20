package com.ada.olimpiadas.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.springframework.stereotype.Repository;

import com.ada.olimpiadas.models.Categoria;
import com.ada.olimpiadas.models.Modalidad;

@Repository
public class CategoriaRepository implements ICategoriaRepository {

    @Override
    public LinkedList<Categoria> getCategorias() {
        LinkedList<Categoria> resultado = new LinkedList<>();
        try (Connection con = DatabaseConnection.getInstance().getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Categoria");

            while (rs.next()) {
                Categoria mod = mapResultSetToModalidad(rs);
                resultado.add(mod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public Categoria getCategoria(int id) {
        Categoria resultado = new Categoria();
        try (Connection con = DatabaseConnection.getInstance().getConnection()) {
            String query = "SELECT * FROM Categoria WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                resultado = mapResultSetToModalidad(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    private Categoria mapResultSetToModalidad(ResultSet rs) throws SQLException {
        Categoria resultado = new Categoria();
        resultado.setId(rs.getInt("id"));
        resultado.setIdModalidad(rs.getInt("id_modalidad"));
        resultado.setEdadInicio(rs.getInt("edad_inicio"));
        resultado.setEdadFin(rs.getInt("edad_fin"));
        resultado.setSexo(rs.getString("sexo"));
        resultado.setPesoInicio(rs.getInt("peso_inicio"));
        resultado.setPesoFin(rs.getInt("peso_fin"));
        resultado.setTamanoGrupo(rs.getInt("tamano_grupo"));
        return resultado;
    }
}

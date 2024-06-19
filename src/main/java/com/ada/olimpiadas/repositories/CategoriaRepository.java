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
import com.ada.olimpiadas.models.Participante;

@Repository
public class CategoriaRepository implements ICategoriaRepository {

    @Override
    public LinkedList<Categoria> getCategorias() {
        LinkedList<Categoria> resultado = new LinkedList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/olimpiadas_db", "root", "olimpiadas");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM Categoria");

            while (rs.next()) {
                Categoria mod = new Categoria();
                mod.setId(rs.getInt("id"));
                mod.setIdModalidad(rs.getInt("id_modalidad"));
                mod.setEdadInicio(rs.getInt("edad_inicio"));
                mod.setEdadFin(rs.getInt("edad_fin"));
                mod.setSexo(rs.getString("sexo"));
                mod.setPesoInicio(rs.getInt("peso_inicio"));
                mod.setPesoFin(rs.getInt("peso_fin"));
                mod.setTamanoGrupo(rs.getInt("tamano_grupo"));


                resultado.add(mod);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    @Override
    public Categoria getCategoria(int id) {

        Categoria resultado = new Categoria();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/olimpiadas_db", "root", "olimpiadas");
            String query = "SELECT * FROM Categoria where id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                resultado.setId(rs.getInt("id"));
                resultado.setIdModalidad(rs.getInt("id_modalidad"));
                resultado.setEdadInicio(rs.getInt("edad_inicio"));
                resultado.setEdadFin(rs.getInt("edad_fin"));
                resultado.setSexo(rs.getString("sexo"));
                resultado.setPesoInicio(rs.getInt("peso_inicio"));
                resultado.setPesoFin(rs.getInt("peso_fin"));
                resultado.setTamanoGrupo(rs.getInt("tamano_grupo"));



            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }



}

package com.ada.olimpiadas.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.springframework.stereotype.Repository;

import com.ada.olimpiadas.models.Puntaje;

@Repository
public class PuntajeRepository implements IPuntajeRepository {

    @Override
    public void guardarPuntaje(Puntaje puntaje) {
        try (Connection con = DatabaseConnection.getInstance().getConnection()) {
            String query = "INSERT INTO Puntaje (juez_id, participante_id, categoria_id, valor_tiempo, valor_distancia, valor_estilo, valor_tecnica, faltas, round) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, puntaje.getJuezId());
            pstmt.setInt(2, puntaje.getParticipanteId());
            pstmt.setInt(3, puntaje.getCategoriaId());
            pstmt.setString(4, puntaje.getValorTiempo());

            Float valorDistancia = puntaje.getValorDistancia();
            if (valorDistancia != null) {
                pstmt.setFloat(5, valorDistancia);
            } else {
                pstmt.setNull(5, java.sql.Types.FLOAT);
            }

            Float valorEstilo = puntaje.getValorEstilo();
            if (valorEstilo != null) {
                pstmt.setFloat(6, valorEstilo);
            } else {
                pstmt.setNull(6, java.sql.Types.FLOAT);
            }

            Float valorTecnica = puntaje.getValorTecnica();
            if (valorTecnica != null) {
                pstmt.setFloat(7, valorTecnica);
            } else {
                pstmt.setNull(7, java.sql.Types.FLOAT);
            }

            Integer faltas = puntaje.getFaltas();
            if (faltas != null) {
                pstmt.setInt(8, faltas);
            } else {
                pstmt.setNull(8, java.sql.Types.INTEGER);
            }

            Integer round = puntaje.getRound();
            if (round != null) {
                pstmt.setInt(9, round);
            } else {
                pstmt.setNull(9, java.sql.Types.INTEGER);
            }

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList<Puntaje> getCalificados() {
        LinkedList<Puntaje> resultado = new LinkedList<>();
        try (Connection con = DatabaseConnection.getInstance().getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Puntaje");

            while (rs.next()) {
                Puntaje puntaje = new Puntaje();
                puntaje.setId(rs.getInt("id"));
                puntaje.setJuezId(rs.getInt("juez_id"));
                puntaje.setParticipanteId(rs.getInt("participante_id"));
                puntaje.setCategoriaId(rs.getInt("categoria_id"));
                puntaje.setValorTiempo(rs.getString("valor_tiempo"));
                puntaje.setValorDistancia(rs.getFloat("valor_distancia"));
                puntaje.setValorEstilo(rs.getFloat("valor_estilo"));
                puntaje.setValorTecnica(rs.getFloat("valor_tecnica"));
                puntaje.setFaltas(rs.getInt("faltas"));
                puntaje.setRound(rs.getInt("round"));
                resultado.add(puntaje);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}

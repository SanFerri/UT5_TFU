package com.ada.olimpiadas.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.springframework.stereotype.Repository;

import com.ada.olimpiadas.models.Modalidad;
import com.ada.olimpiadas.models.Participante;
import com.ada.olimpiadas.models.Puntaje;
import com.ada.olimpiadas.models.TipoPuntaje;

@Repository
public class TipoPuntajeRepository implements ITipoPuntajeRepository {

    @Override
    public TipoPuntaje TipoPuntajePorModalidad(int modalidadId) {
        TipoPuntaje resultado = new TipoPuntaje();
        String sql = "SELECT tp.id, tp.mide_tiempo, tp.mide_distancia, tp.mide_altura, " +
                "tp.mide_estilo, tp.mide_tecnica, tp.cuenta_faltas, tp.cantidad_rounds " +
                "FROM Modalidad m " +
                "INNER JOIN TipoPuntaje tp ON m.puntaje_id = tp.id " +
                "WHERE m.id = ?";
        ;

        try (Connection con = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, modalidadId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    resultado = mapTipoPuntaje(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    private TipoPuntaje mapTipoPuntaje(ResultSet rs) throws SQLException {
        TipoPuntaje resultado = new TipoPuntaje();
        resultado.setId(rs.getInt("id"));
        resultado.setMideTiempo(rs.getBoolean("mide_tiempo"));
        resultado.setMideDistancia(rs.getBoolean("mide_distancia"));
        resultado.setMideAltura(rs.getBoolean("mide_altura"));
        resultado.setMideEstilo(rs.getBoolean("mide_estilo"));
        resultado.setMideTecnica(rs.getBoolean("mide_tecnica"));
        resultado.setCuentaFaltas(rs.getBoolean("cuenta_faltas"));
        resultado.setCantidadRounds(rs.getInt("cantidad_rounds"));
        return resultado;
    }

}

package com.ada.olimpiadas.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.springframework.stereotype.Repository;

import com.ada.olimpiadas.models.Participante;

@Repository
public class ParticipanteRepository implements IParticipanteRepository {

    @Override
    public LinkedList<Participante> getParticipantes() {
        LinkedList<Participante> resultado = new LinkedList<>();
        String query = "SELECT Participante.*, Persona.* FROM Participante JOIN Persona ON Participante.ci = Persona.ci";

        try (Connection con = DatabaseConnection.getInstance().getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Participante participante = mapParticipante(rs);
                resultado.add(participante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public Participante getParticipante(int id) {
        Participante resultado = new Participante();
        String query = "SELECT Participante.*, Persona.* FROM Participante JOIN Persona ON Participante.ci = Persona.ci WHERE Participante.id = ?";

        try (Connection con = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    resultado = mapParticipante(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public LinkedList<Participante> getParticipantesPorModalidad(int modalidadId) {
        LinkedList<Participante> resultado = new LinkedList<>();
        String query = "SELECT Participante.*, Persona.* "
                + "FROM Participante "
                + "JOIN Persona ON Participante.ci = Persona.ci where Participante.modalidad_id = ?";

        try (Connection con = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, modalidadId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Participante participante = mapParticipante(rs);
                    resultado.add(participante);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public LinkedList<Participante> getParticipantesPorCategoria(int categoriaId) {
        LinkedList<Participante> resultado = new LinkedList<>();
        String query = "SELECT Participante.*, Persona.* FROM Participante "
                + "JOIN Persona ON Participante.ci = Persona.ci "
                + "JOIN Participacion ON Participante.id = Participacion.participante_id "
                + "WHERE Participacion.categoria_id = ?";

        try (Connection con = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, categoriaId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Participante participante = mapParticipante(rs);
                    resultado.add(participante);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public LinkedList<Participante> getParticipantesPorEquipo(int equipoId) {
        LinkedList<Participante> resultado = new LinkedList<>();
        String query = "SELECT Participante.*, Persona.* FROM Participante JOIN Persona ON Participante.ci = Persona.ci JOIN Equipo e ON Participante.equipo_id = e.id WHERE Participante.equipo_id = ?";

        try (Connection con = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, equipoId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Participante participante = mapParticipante(rs);
                    resultado.add(participante);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    private Participante mapParticipante(ResultSet rs) throws SQLException {
        Participante participante = new Participante();
        participante.setId(rs.getInt("id"));
        participante.setCi(rs.getString("ci"));
        participante.setEdad(rs.getInt("edad"));
        participante.setPeso(rs.getInt("peso"));
        participante.setModalidadId(rs.getInt("modalidad_id"));
        participante.setNombre(rs.getString("nombre"));
        participante.setApellido(rs.getString("apellido"));
        participante.setContacto(rs.getString("contacto"));
        participante.setEmail(rs.getString("email"));
        participante.setEquipoId(rs.getInt("equipo_id"));

        return participante;
    }
}

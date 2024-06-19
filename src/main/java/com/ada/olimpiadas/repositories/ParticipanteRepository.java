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
        try (Connection con = DatabaseConnection.getInstance().getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT Participante.id, Participante.ci, Participante.edad, Participante.peso, Participante.modalidad_id, "
                            + "Persona.nombre, Persona.apellido, Persona.contacto, Persona.email "
                            + "FROM Participante "
                            + "JOIN Persona ON Participante.ci = Persona.ci");

            while (rs.next()) {
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
        try (Connection con = DatabaseConnection.getInstance().getConnection()) {
            String query = "SELECT Participante.id, Participante.ci, Participante.edad, Participante.peso, Participante.modalidad_id, "
                    + "Persona.nombre, Persona.apellido, Persona.contacto, Persona.email "
                    + "FROM Participante "
                    + "JOIN Persona ON Participante.ci = Persona.ci WHERE Participante.id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                resultado.setId(rs.getInt("id"));
                resultado.setCi(rs.getString("ci"));
                resultado.setEdad(rs.getInt("edad"));
                resultado.setPeso(rs.getInt("peso"));
                resultado.setModalidadId(rs.getInt("modalidad_id"));
                resultado.setNombre(rs.getString("nombre"));
                resultado.setApellido(rs.getString("apellido"));
                resultado.setContacto(rs.getString("contacto"));
                resultado.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public LinkedList<Participante> getParticipantesPorModalidad(int modalidadId) {
        LinkedList<Participante> resultado = new LinkedList<>();
        try (Connection con = DatabaseConnection.getInstance().getConnection()) {
            String query = "SELECT Participante.*, Persona.* "
                    + "FROM Participante "
                    + "JOIN Persona ON Participante.ci = Persona.ci where Participante.modalidad_id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, modalidadId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
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

                resultado.add(participante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public LinkedList<Participante> getParticipantesPorCategoria(int categoriaId) {
        LinkedList<Participante> resultado = new LinkedList<>();
        try (Connection con = DatabaseConnection.getInstance().getConnection()) {
            String query = "SELECT Participante.id, Participante.ci, Participante.edad, Participante.peso, Participante.modalidad_id, "
                    + "Persona.nombre, Persona.apellido, Persona.contacto, Persona.email "
                    + "FROM Participante "
                    + "JOIN Persona ON Participante.ci = Persona.ci "
                    + "JOIN Participacion ON Participante.id = Participacion.participante_id "
                    + "WHERE Participacion.categoria_id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, categoriaId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
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

                resultado.add(participante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}

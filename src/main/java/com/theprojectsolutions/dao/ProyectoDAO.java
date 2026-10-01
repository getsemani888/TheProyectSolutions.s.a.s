package com.theprojectsolutions.dao;

import com.theprojectsolutions.conexion.Conexion;
import com.theprojectsolutions.modelo.Proyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAO {

    // INSERTAR
    public boolean insertar(Proyecto p) {
        String sql = "INSERT INTO proyectos (nombre, cliente, fecha_inicio, fecha_fin, estado, presupuesto) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCliente());
            ps.setString(3, p.getFechaInicio());
            ps.setString(4, p.getFechaFin());
            ps.setString(5, p.getEstado());
            ps.setDouble(6, p.getPresupuesto());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    // LISTAR
    public List<Proyecto> listar() {
        List<Proyecto> lista = new ArrayList<>();
        String sql = "SELECT * FROM proyectos";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proyecto p = new Proyecto();
                p.setIdProyecto(rs.getInt("id_proyecto"));
                p.setNombre(rs.getString("nombre"));
                p.setCliente(rs.getString("cliente"));
                p.setFechaInicio(rs.getString("fecha_inicio"));
                p.setFechaFin(rs.getString("fecha_fin"));
                p.setEstado(rs.getString("estado"));
                p.setPresupuesto(rs.getDouble("presupuesto"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    // ACTUALIZAR
    public boolean actualizar(Proyecto p) {
        String sql = "UPDATE proyectos SET nombre=?, cliente=?, fecha_inicio=?, fecha_fin=?, estado=?, presupuesto=? WHERE id_proyecto=?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCliente());
            ps.setString(3, p.getFechaInicio());
            ps.setString(4, p.getFechaFin());
            ps.setString(5, p.getEstado());
            ps.setDouble(6, p.getPresupuesto());
            ps.setInt(7, p.getIdProyecto());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminar(int id) {
        String sql = "DELETE FROM proyectos WHERE id_proyecto=?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entites.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asullom
 */
public class CompraData {

    static Connection cn = Conn.connectSQLite();
    static PreparedStatement ps;
    static Date dt = new Date();
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String currentTime = sdf.format(dt);

    public static Compra getById(int id) {
        Compra d = new Compra();

        String sql = "SELECT * FROM compra WHERE id = '" + id + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setFecha(rs.getDate("fecha"));
                d.setProve_id(rs.getInt("prove_id"));
                d.setProve_nom(rs.getString("prove_nom"));
                d.setCant_gr(rs.getDouble("cant_gr"));
                d.setEsdolares(rs.getInt("esdolares"));
                d.setTipo_cambio(rs.getDouble("tipo_cambio"));
                d.setPrecio_do(rs.getDouble("precio_do"));
                d.setPrecio_so(rs.getDouble("precio_so"));
                d.setTotal_do(rs.getDouble("total_do"));
                d.setTotal_so(rs.getDouble("total_so"));
                d.setSaldo_do_porpagar(rs.getDouble("saldo_do_porpagar"));
                d.setSaldo_so_porpagar(rs.getDouble("saldo_so_porpagar"));
                d.setUser(rs.getInt("user"));
                d.setActivo(rs.getInt("activo"));
                d.setDate_created(rs.getDate("date_created"));
                d.setLast_updated(rs.getDate("last_updated"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public static int registrar(Compra d) {
        int rsu = 0;
        String sql = "INSERT INTO compra(fecha,  prove_id, prove_nom, cant_gr, esdolares, "
                +"tipo_cambio, precio_do, precio_so, total_do, total_so, "
                + "saldo_do_porpagar, saldo_so_porpagar, user, activo "
                + ") "
                + "VALUES(?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?)";
        int i = 0;
        try {
            String fecha = sdf.format(d.getFecha());
            ps = cn.prepareStatement(sql);
            ps.setString(++i, fecha);
            ps.setInt(++i, d.getProve_id());
            ps.setString(++i, d.getProve_nom());
            ps.setDouble(++i, d.getCant_gr());
            ps.setInt(++i, d.getEsdolares());
            ps.setDouble(++i, d.getTipo_cambio());
            ps.setDouble(++i, d.getPrecio_do());
            ps.setDouble(++i, d.getPrecio_so());
            ps.setDouble(++i, d.getTotal_do());
            ps.setDouble(++i, d.getTotal_so());
            ps.setDouble(++i, d.getSaldo_do_porpagar());
            ps.setDouble(++i, d.getSaldo_so_porpagar());
            ps.setInt(++i, d.getUser());
            ps.setInt(++i, 1);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompraData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsu;
    }

    public static int actualizar(Compra d) {
        int rsu = 0;
        String sql = "UPDATE compra SET "
                + "fecha=?, "
                + "prove_id=?, "
                + "prove_nom=?, "
                + "cant_gr=?, "
                + "esdolares=?, "
                + "tipo_cambio=?, "
                + "precio_do=?, "
                + "precio_so=?, "
                + "total_do=?, "
                + "total_so=?, "
                + "saldo_do_porpagar=?, "
                + "saldo_so_porpagar=?, "
                + "user=?, "
                + "activo=?, "
                + "last_updated=? "
                + "WHERE id=?";
        int i = 0;
        try {
            String fecha = sdf.format(d.getFecha());
            ps = cn.prepareStatement(sql);
            ps.setString(++i, fecha);
            ps.setInt(++i, d.getProve_id());
            ps.setString(++i, d.getProve_nom());
            ps.setDouble(++i, d.getCant_gr());
            ps.setInt(++i, d.getEsdolares());
            ps.setDouble(++i, d.getTipo_cambio());
            ps.setDouble(++i, d.getPrecio_do());
            ps.setDouble(++i, d.getPrecio_so());
            ps.setDouble(++i, d.getTotal_do());
            ps.setDouble(++i, d.getTotal_so());
            ps.setDouble(++i, d.getSaldo_do_porpagar());
            ps.setDouble(++i, d.getSaldo_so_porpagar());
            ps.setInt(++i, d.getUser());
            ps.setInt(++i, d.getActivo());
            ps.setString(++i, sdf.format(dt) );
            ps.setInt(++i, d.getId());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompraData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsu;
    }

    public static int eliminar(int id) {
        int rsu = 0;
        String sql = "DELETE FROM compra WHERE id = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompraData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsu;
    }

    public static List<Compra> list(String busca) {
        List<Compra> ls = new ArrayList<Compra>();
        String sql = "";
        if (busca.equals("")) {
            sql = "SELECT * FROM compra ORDER BY id";
        } else {
            sql = "SELECT * FROM compra WHERE (id LIKE'" + busca + "%' OR "
                    + "fecha LIKE'" + busca + "%' OR cant_gr LIKE'" + busca + "%' OR "
                    + "id LIKE'" + busca + "%') "
                    + "ORDER BY fecha";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Compra d = new Compra();
                d.setId(rs.getInt("id"));
                d.setFecha(rs.getDate("fecha"));
                d.setProve_id(rs.getInt("prove_id"));
                d.setProve_nom(rs.getString("prove_nom"));
                d.setCant_gr(rs.getDouble("cant_gr"));
                d.setEsdolares(rs.getInt("esdolares"));
                d.setTipo_cambio(rs.getDouble("tipo_cambio"));
                d.setPrecio_do(rs.getDouble("precio_do"));
                d.setPrecio_so(rs.getDouble("precio_so"));
                d.setTotal_do(rs.getDouble("total_do"));
                d.setTotal_so(rs.getDouble("total_so"));
                d.setSaldo_do_porpagar(rs.getDouble("saldo_do_porpagar"));
                d.setSaldo_so_porpagar(rs.getDouble("saldo_so_porpagar"));
                d.setUser(rs.getInt("user"));
                d.setActivo(rs.getInt("activo"));
                d.setDate_created(rs.getDate("date_created"));
                d.setLast_updated(rs.getDate("last_updated"));
                ls.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
}

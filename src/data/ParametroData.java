/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entites.Parametro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.math.BigDecimal;
//import java.math.RoundingMode; https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/

/**
 *
 * @author Asullom
 */
public class ParametroData {

    static Connection cn = Conn.connectSQLite();
    static PreparedStatement ps;

    public static Parametro getById(int id) {
        Parametro d = new Parametro();

        String sql = "SELECT * FROM parametro WHERE id = " + id + "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setOnza(rs.getDouble("onza"));
                d.setPorc(rs.getDouble("porc"));
                d.setLey(rs.getDouble("ley"));
                d.setSistema(rs.getDouble("sistema"));
                d.setTcambio(rs.getDouble("tcambio"));
                d.setPrecio_do(rs.getDouble("precio_do"));
                d.setPrecio_so(rs.getDouble("precio_so"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ParametroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public static int registrar(Parametro d) {
        int rsu = 0;
        String sql = "INSERT INTO parametro(onza, porc, ley, sistema, tcambio,  "
                + "precio_do, precio_so) "
                + "VALUES(?,?,?,?,?  ,?,?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setDouble(++i, d.getOnza());
            ps.setDouble(++i, d.getPorc());
            ps.setDouble(++i, d.getLey());
            ps.setDouble(++i, d.getSistema());
            ps.setDouble(++i, d.getTcambio());
            double pre_do = (d.getOnza() / d.getSistema() - (d.getOnza() / d.getSistema()) * d.getPorc() / 100) * d.getLey();
            ps.setDouble(++i, Math.round(pre_do * 100.0) / 100.0);
            ps.setDouble(++i, Math.round(pre_do * d.getTcambio() * 100.0) / 100.0);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParametroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsu;
    }

    public static int actualizar(Parametro d) {
        int rsu = 0;
        String sql = "UPDATE parametro SET "
                + "onza=?, "
                + "porc=?, "
                + "ley=?, "
                + "sistema=?, "
                + "tcambio=?, "
                + "precio_do=?, "
                + "precio_so=? "
                + "WHERE id=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setDouble(++i, d.getOnza());
            ps.setDouble(++i, d.getPorc());
            ps.setDouble(++i, d.getLey());
            ps.setDouble(++i, d.getSistema());
            ps.setDouble(++i, d.getTcambio());
            double pre_do = (d.getOnza() / d.getSistema() - (d.getOnza() / d.getSistema()) * d.getPorc() / 100) * d.getLey();
            ps.setDouble(++i, Math.round(pre_do * 100.0) / 100.0);
            ps.setDouble(++i, Math.round(pre_do * d.getTcambio() * 100.0) / 100.0);
            ps.setInt(++i, d.getId());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParametroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsu;
    }

    public static int eliminar(int id) {
        int rsu = 0;
        String sql = "DELETE FROM parametro WHERE id = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParametroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsu;
    }

    public static List<Parametro> list(String busca) {
        List<Parametro> ls = new ArrayList<Parametro>();
        String sql = "";
        if (busca.equals("")) {
            sql = "SELECT * FROM parametro ORDER BY id";
        } else {
            sql = "SELECT * FROM parametro WHERE (id LIKE'" + busca + "%' OR "
                    + "onza LIKE'" + busca + "%' OR porc LIKE'" + busca + "%' OR "
                    + "id LIKE'" + busca + "%') "
                    + "ORDER BY onza";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Parametro d = new Parametro();
                d.setId(rs.getInt("id"));
                d.setOnza(rs.getDouble("onza"));
                d.setPorc(rs.getDouble("porc"));
                d.setLey(rs.getDouble("ley"));
                d.setSistema(rs.getDouble("sistema"));
                d.setTcambio(rs.getDouble("tcambio"));
                d.setPrecio_do(rs.getDouble("precio_do"));
                d.setPrecio_so(rs.getDouble("precio_so"));
                ls.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParametroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
}

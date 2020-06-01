/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.reports;

import data.Conn;
import entites.views.ProveSaldo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.SQLiteConfig;

/**
 *
 * @author Asullom
 */
public class ProveSaldoReport {
    static Connection cn = Conn.connectSQLite();
    static PreparedStatement ps;

    public static ProveSaldo getSaldoById(int id) {
        ProveSaldo d = new ProveSaldo();
        String sql = "SELECT "
                +"p.id, p.nombres "
                +",sum(DISTINCT pm.adelanto_do) - sum(DISTINCT c.saldo_do_porpagar) - sum(DISTINCT pm.porpagar_do) as saldo_do "
                +",sum(DISTINCT pm.adelanto_so) - sum(DISTINCT c.saldo_so_porpagar) - sum(DISTINCT pm.porpagar_so) as saldo_so "
                +"FROM compra as c "
                +"  inner join proveedor as p on p.id = c.prove_id "
                +"  inner join prove_mov as pm on pm.prove_id = p.id "
                +"WHERE p.id = '" + id + "'"
                +"GROUP BY p.id, p.nombres ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setNombres(rs.getString("nombres"));
                d.setSaldo_do(rs.getDouble("saldo_do"));
                d.setSaldo_so(rs.getDouble("saldo_so"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveSaldoReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
}

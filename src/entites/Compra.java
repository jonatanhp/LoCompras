/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;

/**
 *
 * @author Asullom
 */
public class Compra {

    private int id;
    private Date fecha;
    private int prove_id;
    private String prove_nom;
    private double cant_gr;
    private int esdolares;
    private double tipo_cambio;
    private double precio_do;
    private double precio_so;
    private double total_do;
    private double total_so;
    private double saldo_do_porpagar;
    private double saldo_so_porpagar;
    private int user;
    private int activo;
    private Date date_created;
    private Date last_updated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getProve_id() {
        return prove_id;
    }

    public void setProve_id(int prove_id) {
        this.prove_id = prove_id;
    }

    public String getProve_nom() {
        return prove_nom;
    }

    public void setProve_nom(String prove_nom) {
        this.prove_nom = prove_nom;
    }

    public double getCant_gr() {
        return cant_gr;
    }

    public void setCant_gr(double cant_gr) {
        this.cant_gr = cant_gr;
    }

    public int getEsdolares() {
        return esdolares;
    }

    public void setEsdolares(int esdolares) {
        this.esdolares = esdolares;
    }

    public double getTipo_cambio() {
        return tipo_cambio;
    }

    public void setTipo_cambio(double tipo_cambio) {
        this.tipo_cambio = tipo_cambio;
    }

    public double getPrecio_do() {
        return precio_do;
    }

    public void setPrecio_do(double precio_do) {
        this.precio_do = precio_do;
    }

    public double getPrecio_so() {
        return precio_so;
    }

    public void setPrecio_so(double precio_so) {
        this.precio_so = precio_so;
    }

    public double getTotal_do() {
        return total_do;
    }

    public void setTotal_do(double total_do) {
        this.total_do = total_do;
    }

    public double getTotal_so() {
        return total_so;
    }

    public void setTotal_so(double total_so) {
        this.total_so = total_so;
    }

    public double getSaldo_do_porpagar() {
        return saldo_do_porpagar;
    }

    public void setSaldo_do_porpagar(double saldo_do_porpagar) {
        this.saldo_do_porpagar = saldo_do_porpagar;
    }

    public double getSaldo_so_porpagar() {
        return saldo_so_porpagar;
    }

    public void setSaldo_so_porpagar(double saldo_so_porpagar) {
        this.saldo_so_porpagar = saldo_so_porpagar;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Date last_updated) {
        this.last_updated = last_updated;
    }

   
}

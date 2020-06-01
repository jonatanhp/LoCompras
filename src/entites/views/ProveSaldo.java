/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites.views;

/**
 *
 * @author Asullom
 */
public class ProveSaldo {
    private int id;
    private String nombres;
    private double saldo_do;
    private double saldo_so;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public double getSaldo_do() {
        return saldo_do;
    }

    public void setSaldo_do(double saldo_do) {
        this.saldo_do = saldo_do;
    }

    public double getSaldo_so() {
        return saldo_so;
    }

    public void setSaldo_so(double saldo_so) {
        this.saldo_so = saldo_so;
    }
    
    
}

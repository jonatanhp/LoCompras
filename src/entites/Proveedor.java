package entites;

import java.util.Date;

/**
 *
 * @author Asullom
 */
public class Proveedor {

    private int id;
    private String nombres;
    private String infoadic;
    // temp para practicar
    private Date fecha_nac;
    private Date date_created;
    private Date last_updated;

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

    public String getInfoadic() {
        return infoadic;
    }

    public void setInfoadic(String infoadic) {
        this.infoadic = infoadic;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
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

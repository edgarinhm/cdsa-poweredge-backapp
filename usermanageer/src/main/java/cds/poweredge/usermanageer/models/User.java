package cds.poweredge.usermanageer.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 105698423297670473L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id_usuario;

    private Long id_rol;    
    private String nombre;    
    private String activo;

    public User(){};

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public Long getId() {
        return id_usuario;
    }
    public void setId(Long userId) {
        this.id_usuario = userId;
    }
    public Long getRolId() {
        return id_rol;
    }
    public void setRolId(Long rolId) {
        this.id_rol = rolId;
    }
    public String getName() {
        return nombre;
    }
    public void setName(String name) {
        this.nombre = name;
    }
    public String getActive() {
        return activo;
    }
    public void setActive(String active) {
        this.activo = active;
    }
       
}

package pe.backend.entities;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="proyectos")
@NamedQueries({
	@NamedQuery(
			name = "Proyecto.getProyectosFromSueldo",
			query = "select p from Proyecto p where p.sueldo > ?1"
			),
	@NamedQuery(
			name = "Proyecto.findProyectoByName",
			query = "SELECT p from Proyecto p where p.nombre = ?1"
            ),
    @NamedQuery(
			name = "Proyecto.getProyectosFromTipo",
			query = "select p from Proyecto p where p.tipoProyecto = ?1"
			)
})
@ApiModel(value="Representa la tabla player.")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","inspection"})
public class Proyecto{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="Es la PK de la tabla, entero, auto incremental")
	private int id;

    @NotNull(message="El nombre no puede ser nulo")
    @Size(max=75, min=1, message="El nombre debe estar entre 3 y 75 caracteres")
    private String nombre;

    @Size(max=75, min=3, message="El juego preferido debe estar entre 3 y 75 caracteres")
    private String descripcion;

    @NotNull(message = "Sueldo")
    private double sueldo;

    @NotNull(message = "tipoProyecto")
    @Size(max=75, min=3, message="El juego preferido debe estar entre 3 y 75 caracteres")
    private String tipoProyecto;

    public double getSueldo() {
        return sueldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

}
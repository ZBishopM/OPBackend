package pe.backend.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="mode")
/*@NamedQueries({
	@NamedQuery(
			name="Categoria.buscarPorNombre", 
			query="select c from Categoria c where c.nombre like concat(?1, '%')" // like '%texto%'
			//query="select c from Categoria c where c.nombre like concat(:nombreParam, '%')" // like '%texto%'
	),
	@NamedQuery(
			name="Categoria.buscarPorEstado", 
			query="select c from Categoria c where c.estado = ?1"
	)
})*/
@ApiModel(value="Representa la tabla modos.")
public class Mode{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Format;
	
	@JsonIgnoreProperties("mode") //para evitar entrar en un bucle al enviar la información
	@OneToMany(mappedBy="mode", fetch=FetchType.LAZY)
	private List<Tournament> tournaments;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public List<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}
	
	

}
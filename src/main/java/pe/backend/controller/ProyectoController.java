package pe.backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.backend.entities.Proyecto;
import pe.backend.exception.ModeloNotFoundException;
import pe.backend.services.ProyectoService;

@RestController
@RequestMapping(value="/api/Proyecto")
@Api(value="REST API de Proyecto")
@CrossOrigin
public class ProyectoController{
	@Autowired
	ProyectoService ProyectoService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Listado de todos los jugadores de la BD")
	public ResponseEntity<List<Proyecto>> listar() {
		try {
			List<Proyecto> Proyectos = ProyectoService.listarTodas();
			System.out.print("Hey");
			return new ResponseEntity<List<Proyecto>>(Proyectos, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
			return new ResponseEntity<List<Proyecto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Registro de un nuevo jugador")
	public ResponseEntity insertar(@Valid @RequestBody Proyecto entity){
		
		try {
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(this.ProyectoService.insertar(entity));
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en insertar, Proyecto controller");
		}
	}
	
	@ApiOperation(value="Eliminar un jugador")
	@DeleteMapping(value="/{id}")
	public ResponseEntity eliminar(@PathVariable int id){
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(ProyectoService.eliminar(id));		
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en eliminar, Proyecto controller");
		}
	}
	
	@PutMapping
	@ApiOperation(value="Actualizar un jugador")
	public ResponseEntity actualizar(@RequestBody Proyecto entity){
		
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(ProyectoService.actualizar(entity));
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en actualizar, Proyecto controller");
		}
	}
	
	@GetMapping(value="/{id}")
	@ApiOperation(value="Obtener un jugadr en base a su ID")
	public ResponseEntity<Proyecto> buscarPorID(@PathVariable int id){
		try {
			Optional<Proyecto> entity = ProyectoService.buscarPorID(id);
			if(entity.isPresent()){
				return new ResponseEntity<Proyecto>(entity.get(), HttpStatus.OK);				
			}else {
				throw new ModeloNotFoundException("Jugador no encontrado");
			}			
		} catch (Exception e) {
			throw new ModeloNotFoundException("Jugador no encontrado");
		}
	}
	
	@GetMapping(value="/sueldo/{id}")
	public ResponseEntity<List<Proyecto>> buscarProyectosPorTeamID(@PathVariable float id){
		try {
			List<Proyecto> entity = ProyectoService.getProyectosFromSueldo(id);
			if(entity.isEmpty() == false){
				return new ResponseEntity<List<Proyecto>>(entity, HttpStatus.OK);		
			}else {
				throw new ModeloNotFoundException("Jugador no encontrado");
			}			
		} catch (Exception e) {
			throw new ModeloNotFoundException("Jugador no encontrado");
		}
    }
    
    @GetMapping(value="/tipo/{id}")
	public ResponseEntity<List<Proyecto>> buscarProytectosPorTipo(@PathVariable String id){
		try {
			List<Proyecto> entity = ProyectoService.getProyectosFromTipo(id);
			if(entity.isEmpty() == false){
				return new ResponseEntity<List<Proyecto>>(entity, HttpStatus.OK);		
			}else {
				throw new ModeloNotFoundException("Jugador no encontrado");
			}			
		} catch (Exception e) {
			throw new ModeloNotFoundException("Jugador no encontrado");
		}
	}
	
}

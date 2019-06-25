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
import pe.backend.entities.Team;
import pe.backend.exception.ModeloNotFoundException;
import pe.backend.services.TeamService;

@RestController
@RequestMapping(value="/api/team")
@Api(value="REST API de team")
@CrossOrigin
public class TeamController{
	@Autowired
	TeamService teamService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Listado de todos los equipos de la BD")
	public ResponseEntity<List<Team>> listar() {
		try {
			List<Team> teams = teamService.listarTodas();
			
			return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
			return new ResponseEntity<List<Team>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Registro de un nuevo equipo")
	public ResponseEntity<Team> insertar(@Valid @RequestBody Team entity){
		
		try {
			boolean flag = teamService.insertar(entity);
			if(flag) {
				return new ResponseEntity<Team>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Team>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Eliminar un equipo")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Team> eliminar(@PathVariable int id){
		try {
			boolean flag = teamService.eliminar(id);
			if(flag){
				return new ResponseEntity<Team>(HttpStatus.OK);				
			}else {
				return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Team>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	@ApiOperation(value="Actualizar un equipo")
	public ResponseEntity<Team> actualizar(@RequestBody Team entity){
		
		try {
			boolean flag = teamService.actualizar(entity);
			if(flag) {
				return new ResponseEntity<Team>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Team>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{id}")
	@ApiOperation(value="Obtener un torneo en base a su ID")
	public ResponseEntity<Team> buscarPorID(@PathVariable int id){
		try {
			Optional<Team> entity = teamService.buscarPorID(id);
			if(entity.isPresent()){
				return new ResponseEntity<Team>(entity.get(), HttpStatus.OK);				
			}else {
				throw new ModeloNotFoundException("Torneo no encontrado");
			}			
		} catch (Exception e) {
			throw new ModeloNotFoundException("Torneo no encontrado");
		}
	}
}

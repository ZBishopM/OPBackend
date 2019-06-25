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
import pe.backend.entities.Player;
import pe.backend.exception.ModeloNotFoundException;
import pe.backend.services.PlayerService;

@RestController
@RequestMapping(value="/api/player")
@Api(value="REST API de player")
@CrossOrigin
public class PlayerController{
	@Autowired
	PlayerService playerService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Listado de todos los jugadores de la BD")
	public ResponseEntity<List<Player>> listar() {
		try {
			List<Player> players = playerService.listarTodas();
			
			return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
			return new ResponseEntity<List<Player>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Registro de un nuevo jugador")
	public ResponseEntity<Player> insertar(@Valid @RequestBody Player entity){
		
		try {
			boolean flag = playerService.insertar(entity);
			if(flag) {
				return new ResponseEntity<Player>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Player>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Eliminar un jugador")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Player> eliminar(@PathVariable int id){
		try {
			boolean flag = playerService.eliminar(id);
			if(flag){
				return new ResponseEntity<Player>(HttpStatus.OK);				
			}else {
				return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Player>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	@ApiOperation(value="Actualizar un jugador")
	public ResponseEntity<Player> actualizar(@RequestBody Player entity){
		
		try {
			boolean flag = playerService.actualizar(entity);
			if(flag) {
				return new ResponseEntity<Player>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Player>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{id}")
	@ApiOperation(value="Obtener un jugadr en base a su ID")
	public ResponseEntity<Player> buscarPorID(@PathVariable int id){
		try {
			Optional<Player> entity = playerService.buscarPorID(id);
			if(entity.isPresent()){
				return new ResponseEntity<Player>(entity.get(), HttpStatus.OK);				
			}else {
				throw new ModeloNotFoundException("Jugador no encontrado");
			}			
		} catch (Exception e) {
			throw new ModeloNotFoundException("Jugador no encontrado");
		}
	}
}

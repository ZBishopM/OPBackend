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
import pe.backend.entities.Mode;
import pe.backend.exception.ModeloNotFoundException;
import pe.backend.services.ModeService;

@RestController
@RequestMapping(value="/api/mode")
@Api(value="REST API de mode")
@CrossOrigin
public class ModeController{
	@Autowired
	ModeService serviceMode;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Listado de todas los modos")
	public ResponseEntity<List<Mode>> listar() {
		try {
			List<Mode> modes = serviceMode.listarTodas();
			
			return new ResponseEntity<List<Mode>>(modes, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
			return new ResponseEntity<List<Mode>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Registro de un nuevo modo")
	public ResponseEntity<Mode> insertar(@Valid @RequestBody Mode objMode){
		
		try {
			boolean flag = serviceMode.insertar(objMode);
			if(flag) {
				return new ResponseEntity<Mode>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Mode>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Mode>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Eliminar un modo")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Mode> eliminar(@PathVariable int id){
		try {
			boolean flag = serviceMode.eliminar(id);
			if(flag){
				return new ResponseEntity<Mode>(HttpStatus.OK);				
			}else {
				return new ResponseEntity<Mode>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Mode>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	@ApiOperation(value="Actualizar un torneo")
	public ResponseEntity<Mode> actualizar(@RequestBody Mode objMode){
		
		try {
			boolean flag = serviceMode.actualizar(objMode);
			if(flag) {
				return new ResponseEntity<Mode>(HttpStatus.OK);
			}else{
				return new ResponseEntity<Mode>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<Mode>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{id}")
	@ApiOperation(value="Obtener un modo en base a su ID")
	public ResponseEntity<Mode> buscarPorID(@PathVariable int id){
		try {
			Optional<Mode> objMode = serviceMode.buscarPorID(id);
			if(objMode.isPresent()){
				return new ResponseEntity<Mode>(objMode.get(), HttpStatus.OK);				
			}else {
				throw new ModeloNotFoundException("Torneo no encontrado");
			}			
		} catch (Exception e) {
			throw new ModeloNotFoundException("Torneo no encontrado");
		}
	}
}

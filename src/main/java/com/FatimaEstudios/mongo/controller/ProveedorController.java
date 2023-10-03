package com.FatimaEstudios.mongo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FatimaEstudios.mongo.documentos.Proveedor;
import com.FatimaEstudios.mongo.repository.ProveedorRepository;

/*Marca la clase*/
/*Devuelve datos en lugar de vista, devolverá respuestas en formato JSON*/
@RestController
@RequestMapping("/Proveedor")
public class ProveedorController {
	@Autowired
	private ProveedorRepository proveedorRepo;
	/*realizar la solicitud de operaciones dentro de la pg,
	 * conexion directa con el servidor*/
	
	
	/*NSERTA PROVEEDOR*/
	@PostMapping
    public ResponseEntity<?> saveProveedor(
    		@RequestBody Proveedor proveedor){
		try {
			Proveedor provesave=proveedorRepo.save(proveedor);
			return new ResponseEntity<Proveedor>(provesave, HttpStatus.CREATED);
			
		} catch (Exception e) {
         return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*LISTA PROVEEDORES*/
	
	/*Obtener todos los datos del mongo*/
	/*@GetMapping*/
	/*Le decimos que vamos a recibir, vamos a recibir una lista ResponseEntity*/
	/*ResponseEntity=     Enviar o recibir dtos, personalizar la respuesta y la obtencion de datos*/
	@GetMapping
	public ResponseEntity<?> findAllProveedor() {
	    try {
	        List<Proveedor> proveedor = proveedorRepo.findAll();
	        return new ResponseEntity<List<Proveedor>>(proveedor, HttpStatus.OK);
	    } catch (Exception e) {
	         return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);

	    }
	}
	
	
	/*ACTUALIZA*/
	@PutMapping
    public ResponseEntity<?> updateProveedor(
    		@RequestBody Proveedor proveedor){
		try {
			Proveedor provesave=proveedorRepo.save(proveedor);
			return new ResponseEntity<Proveedor>(provesave, HttpStatus.CREATED);
			
		} catch (Exception e) {
         return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}")
	  public ResponseEntity<?> deleteProveedor(
	    		@PathVariable("id") Integer id){
			try {
				proveedorRepo.deleteById(id);

				return new ResponseEntity<String>("Fue eliminado", HttpStatus.OK);
				
			} catch (Exception e) {
	         return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	
	
}
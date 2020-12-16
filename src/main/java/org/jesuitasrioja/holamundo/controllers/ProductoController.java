package org.jesuitasrioja.holamundo.controllers;

import java.util.List;

import org.jesuitasrioja.holamundo.modelo.Producto;
import org.jesuitasrioja.holamundo.repository.ProductosRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ProductoController implements IProductosRepository {

	private ProductosRepository pr = new ProductosRepository();

	@Override
	@GetMapping("/productos")
	public List<Producto> allProducts() {

		return pr.getAll();
	}

	@Override
	@GetMapping("/producto/{id}")
	public Producto getProducto(@PathVariable String id) {
		return pr.getById(id);
	}

	@Override
	@GetMapping("/producto")
	public Producto getProducto2(@RequestParam String id) {
		return pr.getById(id);
	}

	@Override
	@PostMapping("/producto")
	public String postProducto(@RequestBody Producto nuevoProducto) {
		return String.valueOf(pr.aniadirProducto(nuevoProducto));
	}

	@Override
	@PutMapping("/producto")
	public String putProducto(@RequestBody Producto editadoProducto) {
		return null;
	}

	@Override
	@DeleteMapping("/producto/{id}")
	public String deleteProducto(@PathVariable String id) {
		return String.valueOf(pr.eliminarProducto(id));
	}

//	@GetMapping("/saludos/{nombre}")
//	public String getSaludo(@PathVariable String nombre) {
//		return "hola " + nombre;
//	}
//	
//	@GetMapping("/saludos/{nombre}")
//	public String getSaludo2(@PathVariable String nombre) {
//		return "hola " + nombre;
//	}
//	
//	/**
//	 * 
//	 * PathVariable: 
//	 * 
//	 * RequestParam: 
//	 * 
//	 * 
//	 * */
//	
//	@GetMapping("/saludos")
//	public String getSaludo(@RequestParam String nombre) {
//		return "hola " + nombre;
//	}
//	
//	@PostMapping("/saludos")
//	public String postSaludo(@RequestBody String cuerpo) {
//		return "hola mundo con post";
//	}
//	
//	@DeleteMapping("/saludos")
//	public String deleteSaludo() {
//		return "hola mundo con delete";
//	}
//	
//	@PutMapping("/saludos")
//	public String putSaludo() {
//		return "hola mundo con put";
//	}
}

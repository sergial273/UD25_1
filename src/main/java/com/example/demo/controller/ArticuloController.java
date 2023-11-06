package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Articulo;
import com.example.demo.service.ArticuloServiceImpl;


@RestController
@RequestMapping("/api")
public class ArticuloController {

	@Autowired
	ArticuloServiceImpl ArticuloServideImpl;
	
	@GetMapping("/articulos")
	public List<Articulo> listarArticulos(){
		return ArticuloServideImpl.listarArticulos();
	}
	
	@PostMapping("/articulos")
	public Articulo salvarArticulo(@RequestBody Articulo Articulo) {
		
		return ArticuloServideImpl.guardarArticulos(Articulo);
	}
	
	@GetMapping("/articulos/{id}")
	public Articulo ArticuloXID(@PathVariable(name="id") Long id) {
		
		Articulo Articulo_xid= new Articulo();
		
		Articulo_xid=ArticuloServideImpl.articuloXID(id);
		
		System.out.println("Articulo XID: "+Articulo_xid);
		
		return Articulo_xid;
	}
	
	@PutMapping("/articulos/{id}")
	public Articulo actualizarArticulo(@PathVariable(name="id")Long id,@RequestBody Articulo Articulo) {
		
		Articulo Articulo_seleccionado= new Articulo();
		Articulo Articulo_actualizado= new Articulo();
		
		Articulo_seleccionado= ArticuloServideImpl.articuloXID(id);
		
		Articulo_seleccionado.setNombre(Articulo.getNombre());
		Articulo_seleccionado.setPrecio(Articulo.getPrecio());
		Articulo_seleccionado.setFabricante(Articulo.getFabricante());
		
		Articulo_actualizado = ArticuloServideImpl.actualizarArticulo(Articulo_seleccionado);
		
		System.out.println("El Articulo actualizado es: "+ Articulo_actualizado);
		
		return Articulo_actualizado;
	}
	
	@DeleteMapping("/articulos/{id}")
	public void eliminarArticulo(@PathVariable(name="id")Long id) {
		ArticuloServideImpl.eliminarArticulo(id);
	}
	
}

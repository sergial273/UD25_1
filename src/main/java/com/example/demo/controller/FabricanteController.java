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

import com.example.demo.dto.Fabricante;
import com.example.demo.service.FabricanteServiceImpl;

@RestController
@RequestMapping("/api")
public class FabricanteController {
	
	@Autowired
	FabricanteServiceImpl FabricanteServideImpl;
	
	@GetMapping("/fabricantes")
	public List<Fabricante> listarFabricantes(){
		return FabricanteServideImpl.listarFabricantes();
	}
	
	@PostMapping("/fabricantes")
	public Fabricante salvarFabricante(@RequestBody Fabricante Fabricante) {
		
		return FabricanteServideImpl.guardarFabricantes(Fabricante);
	}
	
	@GetMapping("/fabricantes/{id}")
	public Fabricante FabricanteXID(@PathVariable(name="id") Long id) {
		
		Fabricante Fabricante_xid= new Fabricante();
		
		Fabricante_xid=FabricanteServideImpl.fabricanteXID(id);
		
		System.out.println("Fabricante XID: "+Fabricante_xid);
		
		return Fabricante_xid;
	}
	
	@PutMapping("/fabricantes/{id}")
	public Fabricante actualizarFabricante(@PathVariable(name="id")Long id,@RequestBody Fabricante Fabricante) {
		
		Fabricante Fabricante_seleccionado= new Fabricante();
		Fabricante Fabricante_actualizado= new Fabricante();
		
		Fabricante_seleccionado= FabricanteServideImpl.fabricanteXID(id);
		
		Fabricante_seleccionado.setNombre(Fabricante.getNombre());
		
		Fabricante_actualizado = FabricanteServideImpl.actualizarFabricante(Fabricante_seleccionado);
		
		System.out.println("El Fabricante actualizado es: "+ Fabricante_actualizado);
		
		return Fabricante_actualizado;
	}
	
	@DeleteMapping("/fabricantes/{id}")
	public void eleiminarFabricante(@PathVariable(name="id")Long id) {
		FabricanteServideImpl.eliminarFabricante(id);
	}
	
	
}

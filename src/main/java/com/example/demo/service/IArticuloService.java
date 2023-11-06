package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Articulo;


public interface IArticuloService {

	//Metodos del CRUD
		public List<Articulo> listarArticulos(); //Listar All 
		
		public Articulo guardarArticulos(Articulo video);	//Guarda un Articulo CREATE
		
		public Articulo articuloXID(Long id); //Leer datos de un Articulo READ
		
		public Articulo actualizarArticulo(Articulo video); //Actualiza datos del Articulo UPDATE
		
		public void eliminarArticulo(Long id);// Elimina el Articulo DELETE
}

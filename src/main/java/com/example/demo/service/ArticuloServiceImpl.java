package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IArticuloDAO;
import com.example.demo.dto.Articulo;

@Service
public class ArticuloServiceImpl implements IArticuloService{

	@Autowired
	IArticuloDAO iFabricanteDAO;
	
	@Override
	public List<Articulo> listarArticulos() {
		
		return iFabricanteDAO.findAll();
	}
	
	@Override
	public Articulo guardarArticulos(Articulo video) {
		
		return iFabricanteDAO.save(video);
	}

	@Override
	public Articulo articuloXID(Long id) {
		
		return iFabricanteDAO.findById(id).get();
	}

	@Override
	public Articulo actualizarArticulo(Articulo video) {
		
		return iFabricanteDAO.save(video);
	}

	@Override
	public void eliminarArticulo(Long id) {
		
		iFabricanteDAO.deleteById(id);
		
	}
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IFabricanteDAO;
import com.example.demo.dto.Fabricante;

@Service
public class FabricanteServiceImpl implements IFabricanteService{

	@Autowired
	IFabricanteDAO iFabricanteDAO;
	
	@Override
	public List<Fabricante> listarFabricantes() {
		
		return iFabricanteDAO.findAll();
	}
	
	@Override
	public Fabricante guardarFabricantes(Fabricante video) {
		
		return iFabricanteDAO.save(video);
	}

	@Override
	public Fabricante fabricanteXID(Long id) {
		
		return iFabricanteDAO.findById(id).get();
	}

	@Override
	public Fabricante actualizarFabricante(Fabricante video) {
		
		return iFabricanteDAO.save(video);
	}

	@Override
	public void eliminarFabricante(Long id) {
		
		iFabricanteDAO.deleteById(id);
		
	}
}
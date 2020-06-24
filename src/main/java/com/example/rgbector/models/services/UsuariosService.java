package com.example.rgbector.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rgbector.models.dao.IUsuarios;
import com.example.rgbector.models.entities.usuarios;

@Service
public class UsuariosService implements IUsuariosService{

	@Autowired //Inyeccion de dependencia
	private IUsuarios dao;

	@Override
	@Transactional
	public void save(usuarios a) {
		dao.save(a);		
	}

	@Override
	@Transactional
	public usuarios findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional
	public List<usuarios> findAll() {
		return (List<usuarios>)dao.findAll();
	}
	
}
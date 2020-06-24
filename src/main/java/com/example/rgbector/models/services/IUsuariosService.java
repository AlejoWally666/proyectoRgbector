package com.example.rgbector.models.services;

import java.util.List;

import com.example.rgbector.models.entities.usuarios;

public interface IUsuariosService {
	
	public void save(usuarios a);
	public usuarios findById(Long id);
	public void delete(Long id);
	public List<usuarios> findAll();
}

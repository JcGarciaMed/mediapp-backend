package com.greymatter.service;


import com.greymatter.model.Archivo;

public interface IArchivoService {

	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);
}

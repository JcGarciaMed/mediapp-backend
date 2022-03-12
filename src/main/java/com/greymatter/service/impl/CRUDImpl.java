package com.greymatter.service.impl;

import java.util.List;


import com.greymatter.repo.IGenericRepo;
import com.greymatter.service.ICrud;

public abstract class CRUDImpl<T, ID> implements ICrud<T, ID> {

	protected abstract IGenericRepo<T, ID> getRepo();	
	
	@Override
	public T registrar(T p) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().save(p);
	}

	@Override
	public T modificar(T p) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().save(p);
	}

	@Override
	public List<T> listar() throws Exception {
		// TODO Auto-generated method stub
		return getRepo().findAll();
	}

	@Override
	public T listarPorId(ID id) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void eliminar(ID id) throws Exception {
		// TODO Auto-generated method stub
		getRepo().deleteById(id);
	}
	
}

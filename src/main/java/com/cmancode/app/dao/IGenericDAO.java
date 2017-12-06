package com.cmancode.app.dao;

import java.io.Serializable;
import java.util.List;

import com.cmancode.app.exeptions.InstanceNotFoundException;


public interface IGenericDAO <E, PK extends Serializable>{

	void save(E entity);

	E find(PK id) throws InstanceNotFoundException;

	boolean exists(PK id);

	void remove(PK id) throws InstanceNotFoundException;
	
	List<E> findAll() throws InstanceNotFoundException;
}

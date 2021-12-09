package com.bilgeadam.boost.momdb.clientside.dao;

import java.sql.Connection;

import com.bilgeadam.boost.momdb.clientside.dto.ActorDto;
import com.bilgeadam.boost.momdb.dbconnect.DatabaseConnection;

public interface IDAOImplements<T> {
	
	public ActorDto read(T dto);
	
	public void write(T dto);
	
	public void delete(T dto);
	
	default Connection getInterfaceConnection() {
		return DatabaseConnection.getInstance().getConnection();
	}
}

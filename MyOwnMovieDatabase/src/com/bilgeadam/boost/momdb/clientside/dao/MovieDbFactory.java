package com.bilgeadam.boost.momdb.clientside.dao;

import com.bilgeadam.boost.momdb.clientside.dao.*;

public class MovieDbFactory {
	public IDAOImplements getDao(int choice) {
		switch (choice) {
			case 1:
				return new ActorDao();
			case 2:
				return new MovieDao();
			default:
				return null;
		}
	}
}

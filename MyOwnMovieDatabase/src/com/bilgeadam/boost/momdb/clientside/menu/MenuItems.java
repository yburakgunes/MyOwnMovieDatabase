package com.bilgeadam.boost.momdb.clientside.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.bilgeadam.bautils.BAUtils;
import com.bilgeadam.boost.momdb.clientside.dao.IDAOImplements;
import com.bilgeadam.boost.momdb.clientside.dao.MovieDbFactory;
import com.bilgeadam.boost.momdb.clientside.dto.MovieDto;
import com.bilgeadam.boost.momdb.globalization.Globalization;

public class MenuItems {
	// To Create a single MenuItems object
	private static final MenuItems instance = new MenuItems();
	
	// To avoid MenuItems instantiated, constuctors will set private
	private MenuItems() {
	}
	
	// To access object
	public static MenuItems getInstance() {
		return instance;
	}
	
	public List<String> getLanQueryList() {
		List<String> lanQueryList = new ArrayList<>();
		lanQueryList.add("Türkçe Devam Etmek İçin Lütfen 1'e Basınız.");
		lanQueryList.add("To Continue In English, Please Press 2.");
			return lanQueryList;
	}
	
	public List<String> getMainMenuList(ResourceBundle lang) {
		List<String> mainMenuList = new ArrayList<>();
		mainMenuList.add(lang.getString("Globalization.CREATEDB"));
		mainMenuList.add(lang.getString("Globalization.DELETEDB"));
		mainMenuList.add(lang.getString("Globalization.NEWQUERY"));
		mainMenuList.add(lang.getString("Globalization.EXITREQUEST"));
		return mainMenuList;
	}
	
	public void showMainMenu(ResourceBundle lang) {
		Scanner scanner = new Scanner(System.in);
		IDAOImplements commonDao;
		MovieDto movieDto = new MovieDto();
		MovieDbFactory movieDbFactory = new MovieDbFactory();
		BAUtils baUtils = BAUtils.getInstance();
		
		int choice;
		do {
			baUtils.menuBodyCreator(getMainMenuList(Globalization.getLanguageBundle()),
					Globalization.getLanguageBundle().getString("Globalization.CHOICEQUERY"));
			choice = scanner.nextInt();
			if (choice < 0 || choice > 4)
				System.out.println(lang.getString("Globalization.INVALIDENTRY"));
		} while (choice < 0 || choice > 4);
		
		switch (choice) {
			case 1:
				commonDao = movieDbFactory.getDao(2);
				commonDao.write(movieDto); // in this case movieDto is null. Because we are creating a new database
				break;
			case 2:
				commonDao = movieDbFactory.getDao(2);
				commonDao.delete(movieDto); // in this case movieDto is null. Because we are deleting a new database
				break;
			case 3:
				commonDao = movieDbFactory.getDao(2);
				commonDao.read(movieDto);
				break;
			case 4:
				System.out.println(lang.getString("Globalization.EXITMESSAGE"));
				System.exit(0);
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + choice);
		}
		scanner.close();
		
	}
	
	public List<String> getDbQueryList(ResourceBundle lang) {
		List<String> dbQueryList = new ArrayList<>();
		dbQueryList.add(lang.getString("Globalization.YEARBASEDQ"));
		dbQueryList.add(lang.getString("Globalization.GENREBASEDQ"));
		dbQueryList.add(lang.getString("Globalization.MOVIEBASEDQ"));
		dbQueryList.add(lang.getString("Globalization.ACTORBASEDQ"));
		dbQueryList.add(lang.getString("Globalization.RETURNTOPROG"));
		return dbQueryList;
	}
	
	public List<String> getGenresList(ResourceBundle lang) {
		List<String> genresList = new ArrayList<>();
		genresList.add(lang.getString("Globalization.ACTION"));
		genresList.add(lang.getString("Globalization.ADVENTURE"));
		genresList.add(lang.getString("Globalization.ANIMATION"));
		genresList.add(lang.getString("Globalization.CHILDREN'S"));
		genresList.add(lang.getString("Globalization.COMEDY"));
		genresList.add(lang.getString("Globalization.CRIME"));
		genresList.add(lang.getString("Globalization.DOCUMENTARY"));
		genresList.add(lang.getString("Globalization.DRAMA"));
		genresList.add(lang.getString("Globalization.FANTASY"));
		genresList.add(lang.getString("Globalization.FILMNOIR"));
		genresList.add(lang.getString("Globalization.HORROR"));
		genresList.add(lang.getString("Globalization.MUSICAL"));
		genresList.add(lang.getString("Globalization.MYSTERY"));
		genresList.add(lang.getString("Globalization.ROMANCE"));
		genresList.add(lang.getString("Globalization.SCI-FI"));
		genresList.add(lang.getString("Globalization.THRILLER"));
		genresList.add(lang.getString("Globalization.WAR"));
		genresList.add(lang.getString("Globalization.WESTERN"));
		genresList.add(lang.getString("Globalization.NOGENRESLISTED"));
		return genresList;
	}
	
	public List<String> genresForQuery(ResourceBundle lang) {
		List<String> genres = new ArrayList<>();
		genres.add("Action");
		genres.add("Adventure");
		genres.add("Animation");
		genres.add("Children's");
		genres.add("Comedy");
		genres.add("Crime");
		genres.add("Documentary");
		genres.add("Drama");
		genres.add("Fantasy");
		genres.add("Film-Noir");
		genres.add("Horror");
		genres.add("Musical");
		genres.add("Mystery");
		genres.add("Romance");
		genres.add("Sci-Fi");
		genres.add("Thriller");
		genres.add("War");
		genres.add("Western");
		genres.add("No genres listed");
		return genres;
	}
	
	public List<String> getMessages(ResourceBundle lang) {
		List<String> messagesList = new ArrayList<>();
		messagesList.add(lang.getString("Globalization.GETFIRST"));
		messagesList.add(lang.getString("Globalization.RETRY"));
		
		return messagesList;
	}
	
}

package com.bilgeadam.boost.momdb.clientside.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.bilgeadam.boost.momdb.clientside.dto.ActorDto;
import com.bilgeadam.boost.momdb.clientside.dto.MovieDto;
import com.bilgeadam.boost.momdb.resources.Resources;

public class ActorDao implements IDAOImplements<ActorDto>, Serializable {
	
	private static final long serialVersionUID = 1766167175450194417L;
	
	@Override
	public ActorDto read(ActorDto dto) {
		String str;
		ActorDto actorDto = null;
		try (BufferedReader bR = new BufferedReader(new FileReader(new File(Resources.getUtils("names"))))) {
			while ((str = bR.readLine()) != null) {
				if (str.contains(dto.getName())) {
					actorDto = new ActorDto();
					StringTokenizer tk = new StringTokenizer(str, "\t");
					tk.nextToken();
					if (tk.hasMoreTokens())
						actorDto.setName(tk.nextToken());
					if (tk.hasMoreTokens())
						actorDto.setBirthYear(tk.nextToken());
					if (tk.hasMoreTokens())
						actorDto.setDeathYear(tk.nextToken());
					if (tk.hasMoreTokens())
						actorDto.setPrimaryProfession(tk.nextToken());
					if (tk.hasMoreTokens())
						actorDto.setKnownForTitles(tk.nextToken());
					actorDto = findActorMovies(actorDto);
					actorDto.logActorInformation();
					break;
				}
			}
			if (actorDto == null) {
				System.out.println("Aktör bulunamadı");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actorDto;
	}
	
	private ActorDto findActorMovies(ActorDto dto) {
		
		List<String> titles = new ArrayList<>();
		List<MovieDto> tempList = new ArrayList<MovieDto>();
		StringTokenizer st = new StringTokenizer(dto.getKnownForTitles(), ",");
		while (st.hasMoreElements()) {
			titles.add(st.nextToken());
		}
		try (BufferedReader br = new BufferedReader(new FileReader(Resources.getUtils("movies")))) {
			String line;
			while ((line = br.readLine()) != null) {
				for (String title : titles) {
					if (line.startsWith(title)) {
						MovieDto mdto = new MovieDto();
						StringTokenizer st2 = new StringTokenizer(line, "\t");
						while (st2.hasMoreTokens()) {
							st2.nextToken();
							st2.nextToken();
							mdto.setPrimaryTitle(st2.nextToken());
							st2.nextToken();
							st2.nextToken();
							mdto.setStartYear(st2.nextToken());
							st2.nextToken();
							st2.nextToken();
							mdto.setGenres(st2.nextToken());
						}
						tempList.add(mdto);
					}
				}
				
			}
			dto.setListArtistMovies(tempList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	@Override
	public void write(ActorDto dto) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Resources.getUtils("filePath"), true))) {
			bufferedWriter.newLine();
			bufferedWriter.write(dto.toString());
			bufferedWriter.flush();
		} catch (IOException e) {
			System.out.println("ActorDao Write Error." + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(ActorDto dto) {
		// will not be used
	}
	
	public static void main(String[] args) {
		ActorDto dto = new ActorDto();
		dto.setName("tuti sakarya");
		ActorDao dao = new ActorDao();
		dao.read(dto);
	}
}

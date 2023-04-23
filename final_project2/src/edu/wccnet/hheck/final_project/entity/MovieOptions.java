package edu.wccnet.hheck.final_project.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MovieOptions {
	
	public Map<String, String> populateGenres(){
		Map<String,String> genreList = new LinkedHashMap<String, String>();
		genreList.put("Action", "Action");
		genreList.put("Comedy", "Comedy");
		genreList.put("Drama", "Drama");
		genreList.put("SciFi", "SciFi");
		return genreList;
	}

}

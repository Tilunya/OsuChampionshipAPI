package com.tilundev.ocapi.data;

import com.tilundev.ocapi.utilexcept.NoGenreFoundException;

public enum GenreEnum {
	
	ANY("any",0),
	UNSPECIFIED("unspecified",1),
	VIDEO_GAME("Video Game",2),
	ANIME("Anime",3),
	ROCK("Rock",4),
	POP("Pop",5),
	OTHER("Other",6),
	NOVELTY("Novelty",7),
	HIP_HOP("Hip Hop",9),
	ELECTRONIC("Electronic",10);
	
	private String name;
	private int qualifier;
	
	GenreEnum(String name, int qualifier){
		this.name = name;
		this.qualifier = qualifier;
	}

	public String getName() {
		return this.name;
	}

	public int getQualifier() {
		return this.qualifier;
	}
	
	public static GenreEnum getEnum(int key) throws NoGenreFoundException {
		switch (key) {
		case 0:
			return GenreEnum.ANY;
		case 1:
			return GenreEnum.UNSPECIFIED;
		case 2:
			return GenreEnum.VIDEO_GAME;
		case 3:
			return GenreEnum.ANIME;
		case 4:
			return GenreEnum.ROCK;
		case 5:
			return GenreEnum.POP;
		case 6:
			return GenreEnum.OTHER;
		case 7:
			return GenreEnum.NOVELTY;
		case 9:
			return GenreEnum.HIP_HOP;
		case 10:
			return GenreEnum.ELECTRONIC;
		default:
			String message = "No Genre found for this key (" + key +").";
			throw new NoGenreFoundException(message);
		}
	}

}

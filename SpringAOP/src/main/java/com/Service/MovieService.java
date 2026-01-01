package com.Service;

import com.model.Movie;

public interface MovieService {

	public Movie saveMovie(Movie movie);

	public Movie fetchMovie(int id);

}

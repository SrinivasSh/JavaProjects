package com.Service;

import org.springframework.stereotype.Service;

import com.Exception.MovieNotFoundException;
import com.Repository.MovieRepository;
import com.model.Movie;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

	private final MovieRepository movieRepository;

	public MovieServiceImpl(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	@Override
	public Movie saveMovie(Movie movie) {
		Movie savedMovie = movieRepository.save(movie);
		return savedMovie;
	}

	@Override
	public Movie fetchMovie(int id) {
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new MovieNotFoundException("Movie not found with the given id:" + id));
		return movie;
	}

}

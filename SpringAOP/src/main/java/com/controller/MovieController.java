package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.MovieService;
import com.model.Movie;

@RestController
@RequestMapping("/movie")
public class MovieController {

	private final MovieService movieService;

	private MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}

	@PostMapping("/save")
	public Movie saveMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}

	@GetMapping("/get/{id}")
	public Movie getMovie(@PathVariable(name = "id") int id) {
		return movieService.fetchMovie(id);
	}

}

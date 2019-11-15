package com.vivekchutke.reactive.ReactiveProgramming.repository;

import com.vivekchutke.reactive.ReactiveProgramming.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}

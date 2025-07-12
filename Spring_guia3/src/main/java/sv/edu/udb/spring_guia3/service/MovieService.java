package sv.edu.udb.spring_guia3.service;

import sv.edu.udb.spring_guia3.repository.domain.Movie;

public interface MovieService {

    Movie findMovieById(final Long id);

}

package sv.edu.udb.spring_guia3.service.implementation;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.spring_guia3.repository.MovieRepository;
import sv.edu.udb.spring_guia3.repository.domain.Movie;
import sv.edu.udb.spring_guia3.service.MovieService;

@Getter
@Service
@RequiredArgsConstructor //Inyeccion de dependencias por constructor
public class MovieServiceImpl implements MovieService {
    @NonNull // Agrega una condicion para que este valor no pueda ser nulo
    private final MovieRepository movieRepository;
    @Override
    public Movie findMovieById(final Long id) {
        return movieRepository.findMovieById(id);
    }
}
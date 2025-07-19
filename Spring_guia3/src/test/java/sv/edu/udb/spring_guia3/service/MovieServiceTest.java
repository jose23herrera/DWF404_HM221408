package sv.edu.udb.spring_guia3.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sv.edu.udb.spring_guia3.repository.domain.Movie;
import sv.edu.udb.spring_guia3.service.implementation.MovieServiceImpl;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieServiceImpl movieService;

    @Test
    void shouldMovieServiceNotNull_When_SpringContextWorks() {
        assertNotNull(movieService);
    }

    @Test
    void shouldMovieRepositoryNotNull_When_DIWorks() {
        assertNotNull(movieService.getMovieRepository());
    }

    @Test
    void shouldGetAMovie_When_TheMovieIdExists() {
        final Long expectedMovieId = 1L;
        final String expectedMovieName = "Inception";
        final Integer expectedReleaseYear = 2010;

        final Movie actualMovie = movieService.findMovieById(expectedMovieId);

        assertEquals(actualMovie.getId(), expectedMovieId);
        assertEquals(actualMovie.getName(), expectedMovieName);
        assertEquals(actualMovie.getReleaseYear(), expectedReleaseYear);
    }

    @Test
    void shouldThrowNoSuchElementException_When_MovieIdDoesNotExists() {
        final Long fakeId = 4L;
        final String expectedErrorMessage = "Movie doesn't exists";
        final Exception exception = assertThrows(NoSuchElementException.class,
                () -> movieService.findMovieById(fakeId));
        assertEquals(expectedErrorMessage, exception.getMessage());
    }

    // --- Nuevos casos de prueba agregados ---
    @Test
    void shouldReturnCorrectMovieType_When_MovieIdExists() {
        final Long expectedMovieId = 2L;
        final String expectedMovieType = "Science Fiction Thriller";

        final Movie actualMovie = movieService.findMovieById(expectedMovieId);

        assertEquals(expectedMovieType, actualMovie.getType());
    }

    @Test
    void shouldRepositoryContainMovies_When_Initialized() {
        assertNotNull(movieService.getMovieRepository().findMovieById(1L));
        assertNotNull(movieService.getMovieRepository().findMovieById(2L));
        assertNotNull(movieService.getMovieRepository().findMovieById(3L));
    }

    @Test
    void shouldThrowNoSuchElementException_When_MovieIdIsNull() {
        final String expectedErrorMessage = "Movie doesn't exists";

        final Exception exception = assertThrows(NoSuchElementException.class,
                () -> movieService.findMovieById(null));

        assertEquals(expectedErrorMessage, exception.getMessage());
    }
}

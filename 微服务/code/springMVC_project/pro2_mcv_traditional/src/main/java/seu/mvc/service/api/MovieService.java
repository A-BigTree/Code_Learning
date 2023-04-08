/**
 * ==================================================
 * Project: springMVC_project
 * Package: seu.mvc.service.api
 * =====================================================
 * Title: MovieService.java
 * Created: [2023/4/7 11:03] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/7, created by Shuxin-Wang.
 * 2.
 */


package seu.mvc.service.api;

import seu.mvc.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();

    Movie getMovieById(String movieId);

    void saveMovie(Movie movie);

    void updateMovie(Movie movie);

    void removeMovieById(String movieId);
}

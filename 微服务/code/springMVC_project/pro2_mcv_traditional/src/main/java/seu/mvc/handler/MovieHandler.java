/**
 * ==================================================
 * Project: springMVC_project
 * Package: seu.mvc.handler
 * =====================================================
 * Title: MovieHandler.java
 * Created: [2023/4/7 13:17] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/7, created by Shuxin-Wang.
 * 2.
 */

package seu.mvc.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import seu.mvc.entity.Movie;
import seu.mvc.service.api.MovieService;

import java.util.List;

@Controller
@AllArgsConstructor
public class MovieHandler {

    private final MovieService movieService;

    @RequestMapping("/show/list")
    public String showList(Model model){
        List<Movie> movieList = movieService.getAll();

        model.addAttribute("movieList", movieList);

        return "movie-list";
    }

    @RequestMapping("/remove/movie")
    public String removeMovie(
            @RequestParam("movieId") String moveId
    ){
        movieService.removeMovieById(moveId);

        return "redirect:/show/list";
    }

    @RequestMapping("/save/movie")
    public String saveMovie(Movie movie){
        movieService.saveMovie(movie);

        return "redirect:/show/list";
    }

    @RequestMapping("/edit/movie/page")
    public String editMovie(
            @RequestParam("movieId") String movieId,
            Model model
    ){
        Movie movie = movieService.getMovieById(movieId);

        model.addAttribute("movie", movie);

        return "movie-edit";
    }

    @RequestMapping("/update/movie")
    public String updateMovie(
            Movie movie
    ){
        movieService.updateMovie(movie);
        return "redirect:/show/list";
    }

}

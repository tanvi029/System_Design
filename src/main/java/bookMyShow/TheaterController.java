package bookMyShow;

import bookMyShow.enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterController {

    Map<City, List<Theater>> cityVsTheater;
    List<Theater> allTheater;

    TheaterController() {
        cityVsTheater = new HashMap<>();
        allTheater = new ArrayList<>();
    }

    void addTheater(Theater theater, City city) {
        allTheater.add(theater);
        List<Theater> theaterList = cityVsTheater.get(city);
        theaterList.add(theater);
        cityVsTheater.put(city, theaterList);
    }

    Map<Theater, List<Show>> getAllShow (Movie movie, City city) {
        Map<Theater, List<Show>> theaterVsShows = new HashMap<>();
        List<Theater> theaters = cityVsTheater.get(city);
        //filter the theaters that run this movie
        for (Theater theater:theaters) {
            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theater.getShows();
            for (Show show: shows) {
                if(show.movie.getMovieId() == movie.getMovieId()) {
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()) {
                theaterVsShows.put(theater, givenMovieShows);
            }



        }
        return theaterVsShows;
    }
}

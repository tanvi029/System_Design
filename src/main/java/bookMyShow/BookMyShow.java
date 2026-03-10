package bookMyShow;

import bookMyShow.enums.City;
import bookMyShow.enums.SeatCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
  MovieController movieController;
  TheaterController theaterController;

  BookMyShow() {
    movieController = new MovieController();
    theaterController = new TheaterController();
  }

    public static void main(String args[]) {

        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialize();

        //user1
        bookMyShow.createBooking(City.Bengaluru, "BAAHUBALI");
        //user2
        bookMyShow.createBooking(City.Bengaluru, "BAAHUBALI");

    }

    private void createBooking(City city, String movieName) {

      List<Movie> movies = movieController.getMoviesByCity(city);
        Movie interestedMovie = null;
        for (Movie movie : movies) {

            if ((movie.getMovieName()).equals(movieName)) {
                interestedMovie = movie;
            }
        }
        Map<Theater, List<Show>> showsTheatreWise = theaterController.getAllShow(interestedMovie, city);
        Map.Entry<Theater,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        int seatNumber =30;
        List<Integer> bookedSeats = interestedShow.getBookSeatIds();
        if(!bookedSeats.add(seatNumber)) {
            bookedSeats.add(seatNumber);
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
      for (Seat screenSeat : interestedShow.getScreen().getSeats()) {
        if (screenSeat.getSeatId() == seatNumber) {
          myBookedSeats.add(screenSeat);
        }
                }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;




        }

        System.out.println("BOOKING SUCCESSFUL");









    }

    private void initialize() {

        //create movies
        createMovies();

        //create theater with screens, seats and shows
        createTheatre();
    }

    private void createMovies() {
      Movie avengers = new Movie();
      avengers.setMovieId(1);
      avengers.setMovieName("AVENGERS");
      avengers.setMovieDurationInmInutes(128);

      Movie baahubali = new Movie();
      baahubali.setMovieId(2);
      baahubali.setMovieName("BAAHUBALI");
      baahubali.setMovieDurationInmInutes(180);

      movieController.addMovie(avengers, City.Bengaluru);
      movieController.addMovie(avengers, City.Delhi);
      movieController.addMovie(avengers, City.Bengaluru);
      movieController.addMovie(avengers, City.Delhi);
    }


    private void createTheatre() {

      Movie avengerMovie = movieController.getMovieByName("AVENGER");
      Movie baahubali = movieController.getMovieByName("BAAHUBALI");
      Theater inoxTheater = new Theater();
      inoxTheater.setTheaterId(1);
      inoxTheater.setScreens(createScreen());
      inoxTheater.setCity(City.Bengaluru);
      List<Show> inoxShows = new ArrayList<>();
      Show inoxMorningShow = createShows(1, inoxTheater.getScreens().get(0), avengerMovie, 8);
      Show inoxEveningShow = createShows(2, inoxTheater.getScreens().get(0), baahubali, 16);
      inoxShows.add(inoxMorningShow);
      inoxShows.add(inoxEveningShow);
      inoxTheater.setShows(inoxShows);

        Theater pvrTheatre = new Theater();
        pvrTheatre.setTheaterId(2);
        pvrTheatre.setScreens(createScreen());
        pvrTheatre.setCity(City.Delhi);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvrTheatre.getScreens().get(0), avengerMovie, 13);
        Show pvrEveningShow = createShows(4, pvrTheatre.getScreens().get(0), baahubali, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShows(pvrShows);

        theaterController.addTheater(inoxTheater, City.Bengaluru);
        theaterController.addTheater(pvrTheatre, City.Delhi);





    }

    private Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {
      Show show = new Show();
      show.setShowId(showId);
      show.setScreen(screen);
      show.setMovie(movie);
      show.setShowStartTime(showStartTime);
      return show;
    }

    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);

        return screens;

    }

    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        //41 to 70 : SILVER
        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        //1 to 40 : SILVER
        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        return seats;

    }


}

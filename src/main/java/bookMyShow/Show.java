package bookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Show {

    int showId;
    Movie movie;
    Screen screen;
    int showStartTime;
    List<Integer> bookSeatIds = new ArrayList<>();

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<Integer> getBookSeatIds() {
        return bookSeatIds;
    }

    public void setBookSeatIds(List<Integer> bookSeatIds) {
        this.bookSeatIds = bookSeatIds;
    }

    public int getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(int showStartTime) {
        this.showStartTime = showStartTime;
    }
}

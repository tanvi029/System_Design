package compositePattern.FileSystem;

public class FileSystemDemo {
    public static void main(String[] args) {
        System.out.println("=============== Composite Design Pattern==================");

        //create files
        File receipt = new File("receipt.pdf");
        File invoice = new File("invoice.pdf");
        File torrentLinks = new File ("torrentLinks.txt");
        File tomCruise = new File("tomCruise.jpg");
        File dumbAndDumber = new File ("DumbAndDumber.mp4");
        File hangoverI = new File ("HangoverI.mp4");

        //create Directories
        Directory moviesDirectory = new Directory("Movues");
        Directory comedyMovieDirectory = new Directory("ComedyMovies");

        // Builds the tree structure hierarchically
        moviesDirectory.add(receipt);
        moviesDirectory.add(invoice);
        moviesDirectory.add(torrentLinks);
        moviesDirectory.add(tomCruise);
        moviesDirectory.add(comedyMovieDirectory);
        comedyMovieDirectory.add(dumbAndDumber);
        comedyMovieDirectory.add(hangoverI);

        moviesDirectory.printContents();

    }
}

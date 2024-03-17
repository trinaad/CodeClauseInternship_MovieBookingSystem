import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Movie {
    private String title;
    private String genre;
    private int duration;

    public Movie(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }
}

class Seat {
    private int row;
    private int seatNumber;
    private boolean isBooked;

    public Seat(int row, int seatNumber) {
        this.row = row;
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public int getRow() {
        return row;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void book() {
        isBooked = true;
    }

    public void unbook() {
        isBooked = false;
    }
}

class Theater {
    private List<Movie> movies;
    private Seat[][] seats;

    public Theater() {
        movies = new ArrayList<>();
        // Initialize seats (example: 5 rows, 10 seats per row)
        seats = new Seat[5][10];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                seats[i][j] = new Seat(i + 1, j + 1);
            }
        }
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void displayMovies() {
        System.out.println("Available Movies:");
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            System.out.println((char) ('a' + i) + ") " + movie.getTitle() + " - " + movie.getGenre() + " - " + movie.getDuration() + " minutes");
        }
    }

    public void displaySeats() {
        System.out.println("Available Seats:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                Seat seat = seats[i][j];
                if (!seat.isBooked()) {
                    System.out.print("[" + seat.getRow() + "," + seat.getSeatNumber() + "] ");
                } else {
                    System.out.print("[X] "); // X represents booked seat
                }
            }
            System.out.println();
        }
    }

    public void bookSeat(int row, int seatNumber) {
        Seat seat = seats[row - 1][seatNumber - 1];
        if (!seat.isBooked()) {
            seat.book();
            System.out.println("Seat [" + row + "," + seatNumber + "] booked successfully.");
        } else {
            System.out.println("Seat [" + row + "," + seatNumber + "] is already booked.");
        }
    }
}

public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        Theater theater = new Theater();
        theater.addMovie(new Movie("To Kill A Tiger", "Documentary", 127)); // Released on 10 Mar 2024
        theater.addMovie(new Movie("Dune: Part Two", "Adventure, Action, Drama", 166)); // Released on 01 Mar 2024
        theater.addMovie(new Movie("Monster", "Drama, Thriller", 128)); // Released on 09 Feb 2024
        theater.addMovie(new Movie("All Of Us Strangers", "Drama, Fantasy, Romance", 105)); // Released on 08 Mar 2024
        theater.addMovie(new Movie("The Zone Of Interest", "Drama, History, War", 107)); // Released on 01 Mar 2024
        theater.addMovie(new Movie("Poor Things", "Romance, Sci-Fi", 141)); // Released on 27 Feb 2024
        theater.addMovie(new Movie("American Fiction", "Drama, Comedy", 118)); // Released on 27 Feb 2024
        theater.addMovie(new Movie("The Holdovers", "Comedy, Drama", 133)); // Released on 16 Feb 2024
        theater.addMovie(new Movie("The Iron Claw", "Biography, Drama, Sport", 132)); // Released on 09 Feb 2024
        theater.addMovie(new Movie("Anatomy Of A Fall", "Crime, Drama, Thriller", 151)); // Released on 02 Feb 2024
        theater.addMovie(new Movie("Renaissance: A Film By Beyoncé", "Music", 170)); // Released on 05 Jan 2024
        theater.addMovie(new Movie("Dream Scenario", "Comedy, Horror", 102)); // Released on 05 Jan 2024
        theater.addMovie(new Movie("The Color Purple", "Drama, Musical", 143)); // Released on 08 Mar 2024
        theater.addMovie(new Movie("Damsel", "Fantasy", 109)); // Released on 08 Mar 2024
        theater.addMovie(new Movie("May December", "Comedy, Drama", 117)); // Released on 01 Mar 2024
        theater.addMovie(new Movie("Demon Slayer: Kimetsu No Yaiba - To The Hashira Training", "Animation", 104)); // Released on 23 Feb 2024
        theater.addMovie(new Movie("Land Of Bad", "Action, Thriller", 115)); // Released on 16 Feb 2024
        theater.addMovie(new Movie("Argylle", "Action, Thriller", 139)); // Released on 02 Feb 2024
        theater.addMovie(new Movie("Kung Fu Panda 4", "Animation, Action, Adventure", 93)); // Released on 15 Mar 2024

        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("Welcome to the Movie Ticket Booking System");
            System.out.println("1. Display Movies");
            System.out.println("2. Display Available Seats");
            System.out.println("3. Book a Seat");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            if (input.matches("[1-4]")) {
                choice = Integer.parseInt(input);
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                continue;
            }

            switch (choice) {
                case 1:
                    theater.displayMovies();
                    break;
                case 2:
                    theater.displayMovies();
                    System.out.print("Enter the letter corresponding to the movie: ");
                    String movieLetter = scanner.nextLine().toLowerCase();
                    if (movieLetter.length() == 1 && movieLetter.charAt(0) >= 'a' && movieLetter.charAt(0) < 'a' + theater.getMovies().size()) {
                        int movieIndex = movieLetter.charAt(0) - 'a';
                        Movie selectedMovie = theater.getMovies().get(movieIndex);
                        System.out.println("Available Seats for " + selectedMovie.getTitle() + ":");
                        theater.displaySeats();
                    } else {
                        System.out.println("Invalid movie selection.");
                    }
                    break;

                case 3:
                    theater.displayMovies();
                    System.out.print("Enter the letter corresponding to the movie: ");
                    input = scanner.nextLine().toLowerCase();
                    if (input.length() == 1 && input.charAt(0) >= 'a' && input.charAt(0) < 'a' + theater.getMovies().size()) {
                        int movieIndex = input.charAt(0) - 'a';
                        Movie selectedMovie = theater.getMovies().get(movieIndex);
                        System.out.println("Available Seats for " + selectedMovie.getTitle() + ":");
                        theater.displaySeats();
                        System.out.print("Enter row number: ");
                        int row = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter seat number: ");
                        int seatNumber = Integer.parseInt(scanner.nextLine());
                        theater.bookSeat(row, seatNumber);
                    } else {
                        System.out.println("Invalid movie selection.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

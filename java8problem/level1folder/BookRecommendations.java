package java8problem.level1folder;

import java.util.*;
import java.util.stream.Collectors;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', genre='" + genre + "', rating=" + rating + "}";
    }
}

class BookRecommendation {
    String title;
    double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "BookRecommendation{title='" + title + "', rating=" + rating + "}";
    }
}

public class BookRecommendations {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
                new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.2),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.1),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 3.9),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.0),
                new Book("The Moon is a Harsh Mistress", "Robert Heinlein", "Science Fiction", 4.3),
                new Book("Stranger in a Strange Land", "Robert Heinlein", "Science Fiction", 4.4),
                new Book("The War of the Worlds", "H.G. Wells", "Science Fiction", 3.8),
                new Book("Project Hail Mary", "Andy Weir", "Science Fiction", 4.8),
                new Book("Old Man's War", "John Scalzi", "Science Fiction", 4.1),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.6),
                new Book("The Dark Forest", "Cixin Liu", "Science Fiction", 4.7));

        processBooks(books, 1, 5); // Page 1
        processBooks(books, 2, 5); // Page 2
    }

    public static void processBooks(List<Book> books, int pageNumber, int pageSize) {
        // 1. Filter: Genre "Science Fiction" and rating > 4.0
        // 2. Transform: Create BookRecommendation objects
        // 3. Sort: Rating descending
        // 4. Paginate: Skip (pageNumber-1)*pageSize and limit pageSize
        List<BookRecommendation> recommendations = books.stream()
                .filter(b -> "Science Fiction".equals(b.getGenre()) && b.getRating() > 4.0)
                .map(b -> new BookRecommendation(b.getTitle(), b.getRating()))
                .sorted(Comparator.comparingDouble(BookRecommendation::getRating).reversed())
                .skip((long) (pageNumber - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());

        System.out.println("Book Recommendations (Page " + pageNumber + "):");
        recommendations.forEach(System.out::println);
        System.out.println();
    }
}

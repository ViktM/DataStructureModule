package domain;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private BooksRepository booksRepository;

    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    List<Book> getBooks() throws Exception {
        try {
            return booksRepository.getAllBooks();

        } catch (Exception e) {
            throw new Exception("Service failed to get books");
        }
    }

    List<Book> getBooksByAuthors(String author) throws Exception {
        try {
            return booksRepository.getAllBooks().stream().filter(
                    book -> book.getAuthor().contains(author)).collect(Collectors.toList());

        } catch (Exception e) {
            throw new Exception("Service failed to get books");
        }
    }
}

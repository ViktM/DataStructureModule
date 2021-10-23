package domain;

import java.util.List;

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


}

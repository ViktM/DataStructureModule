package domain;

import java.util.List;

public interface BooksRepository {
    List<Book> getAllBooks() throws Exception;
}

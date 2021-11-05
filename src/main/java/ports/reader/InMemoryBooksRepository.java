package ports.reader;

import domain.Book;
import domain.BooksRepository;

import java.util.List;

public class InMemoryBooksRepository implements BooksRepository {
    List<Book> bookList;

    public InMemoryBooksRepository(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public List<Book> getAllBooks() throws Exception {
        return bookList;
    }
}

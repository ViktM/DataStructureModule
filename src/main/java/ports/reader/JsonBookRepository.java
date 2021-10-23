package ports.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Book;
import domain.Books;
import domain.BooksRepository;

import java.io.File;
import java.util.List;

public class JsonBookRepository implements BooksRepository {
    private String path;
    private ObjectMapper objectMapper;

    public JsonBookRepository(String path, ObjectMapper objectMapper) {
        this.path = path;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Book> getAllBooks() throws Exception {
        return readJson();
    }

    public List<Book> readJson() throws Exception {
        try {
            Books books = objectMapper.readValue(new File(path), Books.class);
            return books.getBooks();
        } catch (Exception e) {
            throw new Exception("Could not get list of books");
        }
    }
}

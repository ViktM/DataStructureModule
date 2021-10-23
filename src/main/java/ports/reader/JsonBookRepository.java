package ports.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Book;
import domain.Books;
import domain.BooksRepository;
import domain.exception.JsonReaderException;

import java.io.File;
import java.io.IOException;
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

    public List<Book> readJson() throws JsonReaderException {
        try {
            Books books = objectMapper.readValue(new File(path), Books.class);
            return books.getBooks();
        } catch (IOException e) {
            throw new JsonReaderException("Could not read in list of books");
        }
    }
}

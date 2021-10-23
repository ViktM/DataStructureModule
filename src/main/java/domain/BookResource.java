package domain;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/library")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    private BookService bookService;

    private String defaultAuthor;

    public BookResource(BookService bookService, String defaultAuthor) {
        this.bookService = bookService;
        this.defaultAuthor = defaultAuthor;
    }

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    @Path("/allbooks")
    public List<Book> showAllBooks() throws Exception {
        return bookService.getBooks();
    }

    @GET
    @Timed
    @Path("/authorSearch")
    public List<Book> showAllBooksByAuthor(@QueryParam("author") Optional<String> author) throws Exception {
        final String finalAuthor = author.orElse(defaultAuthor);
        return bookService.getBooksByAuthors(finalAuthor);
    }
}

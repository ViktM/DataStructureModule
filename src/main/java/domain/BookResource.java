package domain;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/library")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    private BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    @Path("/allbooks")
    public List<Book> showAllBooks() throws Exception {
        return bookService.getBooks();
    }
}

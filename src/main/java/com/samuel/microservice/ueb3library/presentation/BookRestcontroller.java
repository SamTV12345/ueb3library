package com.samuel.microservice.ueb3library.presentation;

import com.samuel.microservice.ueb3library.model.rest.BookPostRest;
import com.samuel.microservice.ueb3library.model.rest.BookRest;
import com.samuel.microservice.ueb3library.rest.BookRestImpl;
import com.samuel.microservice.ueb3library.rest.BookRestPostImpl;
import com.samuel.microservice.ueb3library.service.BookService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/books")
public class BookRestcontroller {
    private final BookService bookService;
    private final HttpServletRequest request;

    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = BookRest.class)))),
            @ApiResponse(responseCode = "400", description = "Missing or invalid request body", content =
            @Content(mediaType = "application/json"))})
    @GetMapping("")
    public ResponseEntity<List<BookRest>> getAllBooks() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "The found book",content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = BookRest.class))),
            @ApiResponse(responseCode = "404", description = "Book not found", content = @Content(mediaType =
                    "application/json")),
            @ApiResponse(responseCode = "400", description = "Missing or invalid request body",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal error",
                    content = @Content(mediaType = "application/json"))})
    @GetMapping("/{id}")
    public ResponseEntity<BookRest> getBook(@PathVariable(value = "id") int idToBeFound) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Optional<BookRestImpl> optionalBook = bookService.findBookById(idToBeFound);

            if (optionalBook.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = BookRest.class))),
            @ApiResponse(responseCode = "400", description = "Missing or invalid request body",
                    content = @Content(mediaType = "application/json"))})
    @PostMapping("")
    public ResponseEntity<BookRest> postBook(@RequestBody BookPostRest bookRestPost) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<>(bookService.saveBook(bookRestPost), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = BookPostRest.class))),
            @ApiResponse(responseCode = "400", description = "Missing or invalid request body")})
    @PutMapping("/{id}")
    public ResponseEntity<BookRest> putBook(@RequestBody BookPostRest bookRestPost,
                                            @PathVariable(value = "id") int idToBeFound) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            BookRest bookRest = new BookRestImpl(idToBeFound, bookRestPost.getAuthor(), bookRestPost.getTitle());
            return new ResponseEntity<>(bookService.saveBook(bookRest), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"),
            description = "If the book could be removed"),
            @ApiResponse(responseCode = "404", description = "If the book could be found"),
            @ApiResponse(responseCode = "400", description = "Missing or invalid request body")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable(value = "id") int bookId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Optional<BookRestImpl> optionalBook = bookService.findBookById(bookId);
            if (optionalBook.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else {
                bookService.deleteBookById(optionalBook.get().getId());
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

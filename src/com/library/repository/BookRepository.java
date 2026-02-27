package com.library.repository;
import com.library.model.Book;
import java.util.HashMap;
import java.util.Map;
/**
 * @author
 **/
public class BookRepository {
    private final Map<String, Book> books;
    public BookRepository(){
        this.books = new HashMap<>();
    }
    public void save(Book book){
        books.put(book.getBookId(),book);
    }
    public Book findById(String bookId){
        return books.get(bookId);
    }
}

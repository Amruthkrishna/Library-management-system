package com.library.model;

/**
 * @author
 **/
public class Book {
    private final String bookId;
    private final String isbn;
    private final String title;
    private final String author;
    private final String edition;
    private final String category;
    private BookStatus bookStatus;

    public Book(String bookId, String isbn, String title, String author, String edition, String category){
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.category = category;
        this.bookStatus = BookStatus.AVAILABLE;
    }

    public String getBookId(){
        return bookId;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return  author;
    }
    public String getEdition(){
        return edition;
    }
    public String getCategory(){
        return category;
    }
    public BookStatus getBookStatus(){
        return bookStatus;
    }
}

package com.library.service;
import com.library.model.Book;
import com.library.model.Member;
import com.library.model.MembershipType;
import com.library.repository.BookRepository;
import com.library.repository.MemberRepository;
/**
 * @author
 **/
public class LibraryService {
    private final MemberRepository memberRepo;
    private final BookRepository bookRepo;

    public LibraryService(MemberRepository repo,BookRepository bookRepo){
        this.memberRepo=repo;
        this.bookRepo=bookRepo;
    }

    public Member findMemberById(String id){
        return memberRepo.findById(id);
    }

    public Member registerMember(String id, String firstName, String lastName, String email, MembershipType membershipType){
        if(findMemberById(id)==null){
            Member m = new Member(id,firstName,lastName,email,membershipType);
            memberRepo.save(m);
            return m;
        }
        else{
            return null;
        }
    }

    public Book findBookById(String id){
        return bookRepo.findById(id);
    }

    public Book addBook(String id, String isbn, String title, String author, String edition, String category){
        if(findBookById(id)==null){
            Book b = new Book(id,isbn,title,author,edition,category);
            bookRepo.save(b);
            return b;
        }
        else{
            return null;
        }
    }
}
package com.library.app;
import com.library.model.Book;
import com.library.model.Member;
import com.library.model.MembershipType;
import com.library.repository.BookRepository;
import com.library.repository.MemberRepository;
import com.library.service.LibraryService;
import java.util.Scanner;

/**
 * @author
 **/
public class Main {
    public static void main(String[] args) {
        MemberRepository repo = new MemberRepository();
        BookRepository bookRepo = new BookRepository();
        LibraryService service = new LibraryService(repo,bookRepo);

        Scanner sc = new Scanner(System.in);
        System.out.println("========Library Management System========");
        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1.Register as new Member.");
            System.out.println("2.Find existing member.");
            System.out.println("3.Add book.");
            System.out.println("4.Borrow Book.");
            System.out.println("5.Return Book.");
            System.out.println("6.Exit");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Member Id:");
                    String memberId = sc.nextLine();
                    System.out.println("Enter your first name:");
                    String firstName = sc.nextLine();
                    System.out.println("Enter your last name:");
                    String lastName = sc.nextLine();
                    System.out.println("Enter email:");
                    String email = sc.nextLine();
                    MembershipType membershipType;
                    System.out.println("Choose your Membership Type:\n1.Student\n2.Staff");
                    int typeChoice = sc.nextInt();
                    sc.nextLine();
                    if (typeChoice==1){
                        membershipType = MembershipType.STUDENT;
                    }
                    else{
                        membershipType = MembershipType.STAFF;
                    }

                    Member result = service.registerMember(memberId,firstName,lastName,email,membershipType);

                    if(result!=null){
                        System.out.println("Registration Successful.\n");
                        System.out.println(result);
                    }
                    else {
                        System.out.println("Member ID already exist");
                    }
                    break;

                case 2:
                    System.out.println("Enter your Member Id:");
                    String id = sc.nextLine();
                    Member resultId = service.findMemberById(id);
                    if(resultId==null){
                        System.out.println("Member Does not exist. Please register!");
                    }
                    else{
                        System.out.println(resultId);
                    }
                    break;
                case 3:
                    System.out.println("Enter the BookId:");
                    String bookId = sc.nextLine();
                    System.out.println("Enter the isbn:");
                    String isbn = sc.nextLine();
                    System.out.println("Enter title:");
                    String title = sc.nextLine();
                    System.out.println("Enter author name:");
                    String author = sc.nextLine();
                    System.out.println("Enter the edition:");
                    String edition = sc.nextLine();
                    System.out.println("Enter category:");
                    String category = sc.nextLine();
                    Book bookResult = service.addBook(bookId,isbn,title,author,edition,category);
                    if(bookResult!=null){
                        System.out.println("Book successfully added.\n");
                        System.out.println(bookResult);
                    }
                    else{
                        System.out.println("Book already exist. Please try again!");
                    }
                    break;
                case 4:
                    System.out.println("Enter your MemberId: ");
                    memberId = sc.nextLine();
                    System.out.println("Enter the BookId: ");
                    bookId = sc.nextLine();
                    boolean borrowResult = service.borrow(memberId,bookId);
                    if(borrowResult){
                        System.out.println("Book has been issued. ThankYou!!");
                    }
                    else{
                        System.out.print("Book has already been issued. Please choose another book.!");
                    }
                    break;
                case 5:
                    System.out.println("Enter your MemberId: ");
                    memberId = sc.nextLine();
                    System.out.println("Enter the BookId: ");
                    bookId = sc.nextLine();
                    boolean returnResult = service.returnBook(memberId,bookId);
                    if(returnResult){
                        System.out.println("ThankYou for returning the book. Hope you enjoyed it!");
                    }
                    else{
                        System.out.println("Book has already been returned! ThankYou.");
                    }
                    break;
                case 6:
                    System.out.println("Thank you for coming!.");
                    return;
            }

        }
    }
}
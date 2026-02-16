package com.library.app;
import com.library.model.Member;
import com.library.model.MembershipType;
import com.library.repository.MemberRepository;
import com.library.service.LibraryService;
import java.util.Scanner;

/**
 * @author
 **/
public class Main {
    public static void main(String[] args) {
        MemberRepository repo = new MemberRepository();
        LibraryService service = new LibraryService(repo);

        Scanner sc = new Scanner(System.in);
        System.out.println("========Library Management System========");
        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1.Register as new Member.");
            System.out.println(("2.Find existing member."));
            System.out.println("3.Exit");

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
                        System.out.println("Registration Successfull.\n");
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
                    System.out.println("Thank you for coming!.");
                    return;
            }

        }
    }
}
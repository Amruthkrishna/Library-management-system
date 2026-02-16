package com.library.model;

/**
 * @author
 **/
public class Member {
    private final String memberId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final MembershipType membershipType;

    public Member(String memberId, String firstName, String lastName, String email, MembershipType membershipType){
        this.memberId = memberId;
        this.firstName=firstName;
        this.lastName = lastName;
        this.email = email;
        this.membershipType = membershipType;
    }

    public String getMemberId(){
        return memberId;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public MembershipType getMembershipType(){
        return membershipType;
    }

    @Override
    public String toString() {
        return "Member Details:\n" + "1.MemberId: " + memberId + "\n2.First Name: " + firstName + "\n3.Last Name: " + lastName + "\n4.Email: " + email + "\n5.Membership Type: " + membershipType;
    }
}

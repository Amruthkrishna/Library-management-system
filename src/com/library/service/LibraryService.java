package com.library.service;
import com.library.model.Member;
import com.library.model.MembershipType;
import com.library.repository.MemberRepository;
/**
 * @author
 **/
public class LibraryService {
    private final MemberRepository repo;
    public LibraryService(MemberRepository repo){
        this.repo=repo;
    }
    public Member findMemberById(String id){
        return repo.findById(id);
    }
    public Member registerMember(String id, String firstName, String lastName, String email, MembershipType membershipType){
        if(findMemberById(id)==null){
            Member m = new Member(id,firstName,lastName,email,membershipType);
            repo.save(m);
            return m;
        }
        else{
            return null;
        }
    }
}
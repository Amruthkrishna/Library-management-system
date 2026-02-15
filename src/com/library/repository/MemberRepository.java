package com.library.repository;
import com.library.model.Member;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 **/
public class MemberRepository {
    private final Map<String, Member> members;
    public MemberRepository(){
        this.members = new HashMap<>();
    }
    public void save(Member member){
        members.put(member.getMemberId(),member);
    }
    public Member findById(String memberId){
        return members.get(memberId);
    }
}

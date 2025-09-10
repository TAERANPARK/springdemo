package com.multi.di.di3;

public class MemberService {
    private final MemberRepository memberRepository;
    //생성자가 DI를 수행
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        memberRepository.save(member);
    }
    public Member get(Long id){
        return memberRepository.findById(id);
    }
}
//memberRepository 의존객체
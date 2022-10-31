package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    /**
    * 회원가입
    */
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member) {
        validateDuplicateMember(member);  // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 같은 이름의 중복 회원 X
        // null이 있을 거 같으면 Optional로 감싸서 반환해주고, ifPresent를 씀.
        // 직접 꺼내고 싶으면 get으로 꺼내도 되는데, 바로 꺼내는 걸 별로 권장하진 않음.
        memberRepository.findByName(member.getName())  // 반환이 Optional로 꺼내지니까, 바로 ifPresent를 씀.
                .ifPresent(m -> {  // null이 아니라 어떤 값이 있으면 반환
                        throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
    * 전체 회원 조회
    */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

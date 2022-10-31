package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 멤버에서 멤버 겟네임이 파라미터 네임이랑 같은지 확인.
        // 같다면 필터링이 됨. 하나 찾아지면 반환을 함.
        // 끝까지 돌렸는데 없으면 옵셔널에 널이 포함돼서 반환.
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        // 멤버들이 쭉 반환 됨.
        return new ArrayList<>(store.values());
    }

    public void clearstore() {
        store.clear();
    }
}

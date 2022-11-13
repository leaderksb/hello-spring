package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 스프링이 뜰 때 컨피그레이션을 읽어오고
public class SpringConfig {

    @Bean  // 스프링 빈에 등록하란 뜻이네 하고 인식
    public MemberService memberService() {  // MemberService 로직을 호출해서 등록해줌
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

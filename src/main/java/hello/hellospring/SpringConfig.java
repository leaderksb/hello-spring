package hello.hellospring;

import hello.hellospring.aop.TimeTraceApp;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 스프링이 뜰 때 컨피그레이션을 읽어오고
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @PersistenceContext

    /*
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }


    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
     */

    @Bean  // 스프링 빈에 등록하란 뜻이네 하고 인식
    public MemberService memberService() {  // MemberService 로직을 호출해서 등록해줌
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceApp timeTraceApp() {
//        return new TimeTraceApp();
//    }

//    @Bean  // 스프링 빈에 등록하란 뜻이네 하고 인식
//    public MemberService memberService() {  // MemberService 로직을 호출해서 등록해줌
//        return new MemberService(memberRepository());
//    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}

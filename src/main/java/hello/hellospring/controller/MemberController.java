package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller  // 1. 컨트롤러로 외부 요청을 받음
public class MemberController {

    /*
    1) 수정자 주입(Setter Injection)
    private MemberService memberService;

    @Autowired  // MemberController를 호출했을 때 public으로 열려있어야 함. 중간에 바꿀 일이 없는데 public으로 노출돼서 잘못 바꾸면 문제가 됨.
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    2) 필드 주입(Field Injection)
    @Autowired private MemberService memberService;
    */

    // 3) 생성자 주입(Constructor Injection) : 의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장함
    private final MemberService memberService;

    @Autowired  // 멤버 컨트롤러가 생성이 될 때 스프링빈에 등록돼 있는 객체를 가져다가 넣어줌.
    // 이게 바로 의존성 주입(디펜던시 인젝션) : 하나의 객체가 다른 객체의 의존성을 제공하는 테크닉.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

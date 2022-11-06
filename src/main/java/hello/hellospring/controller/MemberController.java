package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller  // 1. 컨트롤러로 외부 요청을 받음
public class MemberController {
    private final MemberService memberService;

    @Autowired  // 멤버 컨트롤러가 생성이 될 때 스프링빈에 등록돼 있는 객체를 가져다가 넣어줌.
    // 이게 바로 의존성 주입(디펜던시 인젝션) : 하나의 객체가 다른 객체의 의존성을 제공하는 테크닉.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

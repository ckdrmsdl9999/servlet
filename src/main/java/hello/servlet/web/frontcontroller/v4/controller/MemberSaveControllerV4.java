package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();//<--이거는 안되는건가 ?? id출력 이유알기
//      private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {


        String username = paramMap.get("username");
        int age=Integer.parseInt(paramMap.get("age"));
        //    String test = paramMap.get("id");////////////////테스트필요
        //   System.out.print("히히"+test);

        Member member = new Member(username,age);//->paramMap.get("username")으로 바꾸는게 더 짧고 간결하지않을까?
        memberRepository.save(member);

  //      model.put("member",paramMap);//////////////id안뜨는거 이거원인<-----왜안됏지
        model.put("member",member);

        return "save-result";
    }
}

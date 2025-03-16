package practice.week2practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practice.week2practice.domain.Member;
import practice.week2practice.service.MemberService;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/members/new")
    public String membersNew(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String membersNewPost(@RequestParam("name") String name){
        Member member = new Member();
        member.setName(name);
        memberService.accountCreate(member);
        return "redirect:/";
    }
    @GetMapping("/members")
    public String members(Model model){
        List<Member> members = memberService.findAllMember();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}

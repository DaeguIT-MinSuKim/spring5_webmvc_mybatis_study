package spring5_webmvc_mybatis_study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring5_webmvc_mybatis_study.dto.ListCommand;
import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.service.MemberListService;

@Controller
public class ListController {
    @Autowired
    private MemberListService memberListService;

    @RequestMapping("/members")
    public String list(@ModelAttribute("cmd") ListCommand listCommand, Errors errors, Model model) {
    	if (errors.hasErrors()) {
            return "member/memberList";
        }
        if (listCommand.getFrom() != null && listCommand.getTo() != null) {
            List<Member> members = memberListService.showMemberByRegdate(listCommand);
            model.addAttribute("members", members);
        }
        return "member/memberList";
    }

}

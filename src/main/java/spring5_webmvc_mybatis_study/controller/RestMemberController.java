package spring5_webmvc_mybatis_study.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.dto.RegisterRequest;
import spring5_webmvc_mybatis_study.exception.DuplicateMemberException;
import spring5_webmvc_mybatis_study.exception.MemberNotFoundException;
import spring5_webmvc_mybatis_study.service.RestMemberService;

@RestController
public class RestMemberController {
	@Autowired
    private RestMemberService service;
	
	@GetMapping("/api/members")
	public List<Member> members(){
		return service.showMembers();
	}
	
	@GetMapping("/api/members/{id}")
    public Member member(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Member member = service.showMemberById(id);
        if (member == null) {
        	throw new MemberNotFoundException();
        }
        return member;
    }

//    @ExceptionHandler(MemberNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleNoData(){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member"));
//    }

    
	@PostMapping("/api/members")
    public void newMember(@RequestBody @Valid RegisterRequest regReq, Errors errors, HttpServletResponse response) throws IOException {
        try {
    		if (errors.hasErrors()) {
    			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
    		}
            Long newMemberId = service.regist(regReq);
            response.setHeader("Location", "/api/members/" + newMemberId);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (DuplicateMemberException e) {
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }
}

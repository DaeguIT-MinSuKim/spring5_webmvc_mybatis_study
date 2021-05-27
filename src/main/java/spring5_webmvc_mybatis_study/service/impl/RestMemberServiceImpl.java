package spring5_webmvc_mybatis_study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.mappers.MemberMapper;
import spring5_webmvc_mybatis_study.service.RestMemberService;

@Service
public class RestMemberServiceImpl implements RestMemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public Member showMemberById(Long memId) {
		return memberMapper.selectMemberById(memId);
	}

	@Override
	public List<Member> showMembers() {
		return memberMapper.selectMemberAll();
	}

}

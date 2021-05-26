package spring5_webmvc_mybatis_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.mappers.MemberMapper;
import spring5_webmvc_mybatis_study.service.MemberDetailService;

@Service
public class MemberDetailServiceImpl implements MemberDetailService {
	@Autowired
    private MemberMapper memberMapper;
	
	@Override
	public Member showMemberById(Long memId) {
		return memberMapper.selectMemberById(memId);
	}

}

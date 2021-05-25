package spring5_webmvc_mybatis_study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import spring5_webmvc_mybatis_study.dto.ListCommand;
import spring5_webmvc_mybatis_study.dto.Member;

@Service
public interface MemberListService {
	List<Member> showMemberByRegdate(ListCommand listCommand);
}

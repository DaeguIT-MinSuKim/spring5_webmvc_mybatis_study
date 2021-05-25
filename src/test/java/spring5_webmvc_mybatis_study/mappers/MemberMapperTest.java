package spring5_webmvc_mybatis_study.mappers;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_webmvc_mybatis_study.config.ContextRoot;
import spring5_webmvc_mybatis_study.dto.ListCommand;
import spring5_webmvc_mybatis_study.dto.Member;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class MemberMapperTest {
	protected static final Log log = LogFactory.getLog(MemberMapperTest.class);

	@Autowired
	private MemberMapper mapper;
		
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void test1SelectMemberByEmail() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		String email="test@test.co.kr";
		
		Member member = mapper.selectMemberByEmail(email);
		log.debug(member.toString());
		
		Assert.assertNotNull(member);
	}

	@Test
	public void test2SelectMemberAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Member> list = mapper.selectMemberAll();
		Assert.assertNotNull(list);
		
		list.forEach(s->log.debug(s.toString()));
	}

	@Test
	public void test3CountMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int cnt = mapper.countMember();
		
		Assert.assertNotEquals(-1, cnt);
		log.debug("cnt >> " + cnt);
	}

	@Test
	public void test4InsertMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member newMember = new Member("test20@test.co.kr", "1111", "test20");
		
		int res = mapper.insertMember(newMember);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test5UpdateMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Member newMember = new Member("test20@test.co.kr", "2222", "테스트20");
		
		int res = mapper.updateMember(newMember);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test6DeleteMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member newMember = new Member("test20@test.co.kr", "2222", "테스트20");
		int res = mapper.deleteMember(newMember);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test7SelectMemberByRegdate() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		ListCommand listCommand = new ListCommand();
		LocalDateTime from = LocalDateTime.of(2021, 5, 20, 00, 00);
		LocalDateTime to = LocalDateTime.of(2021, 5, 21, 00, 00);
		listCommand.setFrom(from);
		listCommand.setTo(to);
		
		List<Member> list = mapper.selectMemberByRegdate(listCommand);
		Assert.assertNotNull(list);
		
		list.forEach(s->log.debug(s.toString()));
	}
}

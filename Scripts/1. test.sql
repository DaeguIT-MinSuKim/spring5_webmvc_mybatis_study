select id, email, password, name, regdate from member;

delete from member where id >46;

select * 
  from member 
 where regdate between '2021-05-20 00' and '2021-05-21 00' 
 order by regdate desc;
package mms.member.svc;
//8-2. 회원목록 보기 요청을 처리하는 Business Logic이 구현되는 Service 클래스 구현

import java.sql.Connection;
import java.util.ArrayList;
import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberListService {
	Connection con;
	public ArrayList<Member> getMemberList() {
		JdbcUtil.getConnection();
		
		MemberDAO mdao = new MemberDAO(con);
		ArrayList<Member> amb = new ArrayList<Member>();
		amb = mdao.selectMemberList();
		//JdbcUtil.close(con);
		return amb;
	
	}
}

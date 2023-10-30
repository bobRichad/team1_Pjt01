package mms.member.svc;
//8-1. 회원등록 Business Logic이 구현되는 Service 클래스 구현

import java.sql.Connection;
import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberAddService {
	Connection con;
	
	public boolean addMember(Member newMember) throws Exception {
		boolean jb = (newMember != null);
		MemberDAO mdao = new MemberDAO(con);
		
		if(jb) {
			JdbcUtil.getConnection();
			mdao.insertNewMember(newMember);
		}else {
			System.out.println("입력된 값이 전달되지 못했습니다.");
		}
		return jb;
	}
}

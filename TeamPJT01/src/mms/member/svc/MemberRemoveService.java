package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;

//8-4. 회원정보 삭제 요청을 처리하는 Business Logic이 구현되는 Service 클래스 구현

public class MemberRemoveService {

	public boolean removeMember(String name) {
		JdbcUtil.getConnection();
		
		MemberDAO mdao = new MemberDAO(JdbcUtil.con);
		mdao.deleteMember(name);
		
		JdbcUtil.close(JdbcUtil.con);
		return false;

	}

}

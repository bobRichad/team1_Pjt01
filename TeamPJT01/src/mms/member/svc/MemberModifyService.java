package mms.member.svc;

import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
//8-3. 회원정보 수정 요청을 처리하는 Business Logic이 구현되는 Service 클래스 구현
import mms.member.vo.Member;

public class MemberModifyService {
	Connection con;
	MemberDAO mdao =new MemberDAO(con);
	public Member getOldMember(String name) {
		JdbcUtil.getConnection();
		
		
		Member mb = mdao.selectOldMember(name);
		
		return mb;
	}

	public boolean modifyMember(Member updateMember) {
		if(updateMember != null) {
			mdao.updateMember(updateMember);
			return true;
		}else {
			System.out.println("존재하지 않는 멤버같습니다");
			return false;
		}

	}

}

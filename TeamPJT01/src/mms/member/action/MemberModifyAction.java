package mms.member.action;
import java.sql.Connection;
//7-3 회원 정보 수정 요청을 처리하는 Action 클래스 구현
import java.util.Scanner;
import mms.member.svc.MemberModifyService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberModifyAction implements Action {
	Connection con;
	@Override
	public void execute(Scanner sc) throws Exception {
		MemberModifyService mms = new MemberModifyService();
		
		System.out.print("수정하려는 멤버의 이름을 입력해주세요 :");
		String name = sc.next();
		
		//MemberDAO mdao = new MemberDAO(con);
		Member orimem = mms.getOldMember(name);
		ConsoleUtil cu = new ConsoleUtil();
		
		Member newmem = cu.getUpdateMember(sc, orimem);
		
		mms.modifyMember(newmem);
	
	}

}

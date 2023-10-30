package mms.member.action;
//7-1 회원등록 요청 처리하는 Action 클래스 구현
import java.util.Scanner;
import mms.member.svc.MemberAddService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberAddAction implements Action {
//여기서 콘솔유틸로 넘어가고 Addservice에서 중복확인
	@Override
	public void execute(Scanner sc) throws Exception {
		
		ConsoleUtil cu = new ConsoleUtil();
		MemberAddService mas = new MemberAddService();
		Member mb = new Member();
		mb = cu.getNewMember(sc);
		mas.addMember(mb);
		
	}

}

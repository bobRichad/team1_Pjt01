package mms.member.action;
//7-4 회원 정보 삭제 요청을 처리하는 Action 클래스 구현

import java.util.Scanner;

import mms.member.svc.MemberRemoveService;


public class MemberRemoveAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		MemberRemoveService mrs = new MemberRemoveService();
		System.out.print("삭제하려는 멤버의 이름을 작성해주세요 : ");
		String name = sc.next();
		
		mrs.removeMember(name);

	}

}

package mms.member.ui;

import java.util.Scanner;

import mms.member.action.MemberAddAction;
import mms.member.action.MemberListAction;
import mms.member.action.MemberModifyAction;
import mms.member.action.MemberRemoveAction;
import mms.member.controller.MemberController;

public class MemberUI {

	public static void main(String[] args) {
		boolean isStop = false;

		Scanner sc = new Scanner(System.in);
		MemberController memberController = new MemberController();
		MemberAddAction maa = new MemberAddAction();
		MemberListAction mla = new MemberListAction();
		MemberModifyAction mma = new MemberModifyAction();
		MemberRemoveAction mra = new MemberRemoveAction();

		do {
			System.out.println("=====멤버 관리 프로그램=====");
			System.out.println("1.회원 등록");
			System.out.println("2.회원목록보기");
			System.out.println("3.회원정보수정");
			System.out.println("4.회원삭제");
			System.out.println("5.종료");
			System.out.print("메뉴번호를선택해주세요 : ");
			int select = sc.nextInt();
			if (select == 1) {

				memberController.processRequest(maa, sc);

			} else if (select == 2) {

				memberController.processRequest(mla, sc);

			} else if (select == 3) {

				memberController.processRequest(mma, sc);

			} else if (select == 4) {
				
				memberController.processRequest(mra, sc);
			} else if (select == 5) {
				isStop = true;
			} else {
				System.out.println("범위에 벗어난 번호를 입력하셨습니다. 다시 시도해주세요");
			}

		} while (!isStop);
		System.out.println("프로그램 종료.");

	}

}

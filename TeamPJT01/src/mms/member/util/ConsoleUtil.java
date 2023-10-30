package mms.member.util;

import java.util.ArrayList;
import java.util.Scanner;
import mms.member.vo.Member;

//5. 사용자로부터의 입력을 콘솔에서 읽어 들이거나 콘솔로 메시지를 출력하는 역할을 하는 클래스 구현
public class ConsoleUtil {
	Member mb = new Member();
	public Member getNewMember(Scanner sc) {
		System.out.print("이름 : ");
		mb.setName(sc.next());
		System.out.print("주소 : ");
		mb.setAddr(sc.next());
		System.out.print("국가 : ");
		mb.setNation(sc.next());
		System.out.print("메일 : ");
		mb.setEmail(sc.next());
		System.out.print("나이 : ");
		mb.setAge(sc.nextInt());
		return mb;
	}

	public void printAddSuccessMessage(Member newMember) {
		System.out.println("####" + newMember.getName() + "회원 등록 성공");
	}

	public void printAddFailMessage(Member newMember) {
		System.out.println(newMember.getName() + "회원 등록 실패");
	}

	public void printMemberList(ArrayList<Member> memberList) {
		// size() : 컬렉션에 저장되어 있는 요소의 개수를 리턴하는 메소드
		System.out.print("멤버의 수 : ");
		System.out.println(memberList.size());
		
		for(int i = 0; i<memberList.size(); i++) {
			
				System.out.println("name :"+memberList.get(i).getName()
									+" "+"addr:"+memberList.get(i).getAddr()
									+" "+"nation:"+memberList.get(i).getNation()
									+" "+"email:"+memberList.get(i).getEmail()
									+" "+"age :"+memberList.get(i).getAge());
		
		}

	}

	public String getName(String msgKind, Scanner sc) {
		
		
		
		return msgKind;

	}

	public Member getUpdateMember(Scanner sc, Member oldMember) {//업데이트 할거 구. 신. 입력하는곳인듯
		
		System.out.println("이전국가 : "+oldMember.getNation());
		System.out.print("수정할국가 : ");
		oldMember.setNation(sc.next());
		
		System.out.println("이전주소 : "+oldMember.getAddr());
		System.out.print("수정할주소 : ");
		oldMember.setAddr(sc.next());
		
		System.out.println("이전이메일 : "+oldMember.getEmail());
		System.out.print("수정할이메일 : ");
		oldMember.setEmail(sc.next());
		
		System.out.println("이전나이 : "+oldMember.getAge());
		System.out.print("수정할나이 : ");
		oldMember.setAge(sc.nextInt());
		
		return oldMember;
	}

	public void printModifySuccessMessage(Member updateMember) {
		System.out.println(updateMember.getName() + " 회원 정보 수정 성공.");
	}

	public void printModifyFailMessage(Member updateMember) {
		System.out.println(updateMember.getName() + " 회원 정보 수정 실패.");
	}

	public void printRemoveSuccessMessage(String name) {
		System.out.println(name + " 회원의 정보 삭제 성공.");
	}

	public void printRemoveFailMessage(String name) {
		System.out.println(name + " 회원의 정보 삭제 실패.");
	}

}

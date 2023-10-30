package mms.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mms.member.db.JdbcUtil;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

//9. Oracle DB로 필요한 SQL구문을 전송하는 클래스 구현
public class MemberDAO {
	Connection con;
	Member mb = new Member();
	ConsoleUtil cu = new ConsoleUtil();

	public MemberDAO(Connection con) {
		this.con = con;
	}

	public int insertNewMember(Member newMember) {

		try {
			String insert = "INSERT INTO member (ID,NAME,ADDR,NATION,EMAIL,AGE) VALUES(mem_seq.nextval,?,?,?,?,?)";
			// String insert = "INSERT INTO member VALUES(p_seq.nextval,?,?,?,?,?)";
			PreparedStatement pstmt = JdbcUtil.con.prepareStatement(insert);

			pstmt.setString(1, newMember.getName());
			pstmt.setString(2, newMember.getAddr());
			pstmt.setString(3, newMember.getNation());
			pstmt.setString(4, newMember.getEmail());
			pstmt.setInt(5, newMember.getAge());
			pstmt.execute();
			pstmt.close();
			JdbcUtil.close(JdbcUtil.con);
			
			cu.printAddSuccessMessage(newMember);
		} catch (SQLException e) {
			cu.printAddFailMessage(newMember);
		}
		
		return 0;

	}

	public ArrayList<Member> selectMemberList() {
		String list = "Select * from member";
		ArrayList<Member> mb = new ArrayList<Member>();
		try {
			PreparedStatement pstmt = JdbcUtil.con.prepareStatement(list);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				mb.add(new Member(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mb;

	}

	public Member selectOldMember(String name) {// 수정할 회원이름 where 받는곳 인듯?

		String select = "Select * from member where NAME = '" + name + "'";
		try {
			PreparedStatement pstmt = JdbcUtil.con.prepareStatement(select);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
			mb.setName(rs.getString(2));
			mb.setAddr(rs.getString(3));
			mb.setNation(rs.getString(4));
			mb.setEmail(rs.getString(5));
			mb.setAge(rs.getInt(6));
			}

		} catch (SQLException e) {
			System.out.println("해당 멤버를 찾을 수 없습니다");

		}
		return mb;
	}

	public int updateMember(Member updateMember) {// 위의 올드멤버 리턴값을 받아 svc에서 업데이트멤버 값으로 받고 다시 여기로
		String update = "Update member set ADDR = ? , NATION = ? , EMAIL = ? , AGE = ?  where name = '" +updateMember.getName()+"'";
		try {
			PreparedStatement pstmt = JdbcUtil.con.prepareStatement(update);

			pstmt.setString(1, updateMember.getAddr());
			pstmt.setString(2, updateMember.getNation());
			pstmt.setString(3, updateMember.getEmail());
			pstmt.setInt(4, updateMember.getAge());
			pstmt.execute();
			pstmt.close();
			JdbcUtil.close(JdbcUtil.con);
		} catch (SQLException e) {
			cu.printModifyFailMessage(updateMember);
		}
		cu.printModifySuccessMessage(updateMember);
		return 0;

	}

	public int deleteMember(String name) {// svc에서 입력받은 이름 가져옴
		String delete = "Delete from member where name = '"+ name +"'" ;
		System.out.println(name);
		try {
			PreparedStatement pstmt = JdbcUtil.con.prepareStatement(delete);

			pstmt.execute();
			pstmt.close();
			JdbcUtil.close(JdbcUtil.con);
		} catch (SQLException e) {
			cu.printRemoveFailMessage(name);
		}
		cu.printRemoveSuccessMessage(name);
		return 0;

	}

}

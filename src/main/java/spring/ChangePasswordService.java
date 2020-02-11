package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {

	private MemberDao memberDao;
	
	public ChangePasswordService() {}
	

	public ChangePasswordService(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	//생성자가 하나라도있으면 default생성자를 만들지 않음
	
	public void changePassword(String email, String oldPwd, String newPwd){
		Member member = memberDao.selectByEmail(email);
		if(member == null){
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd,  newPwd);
		memberDao.update(member);
	}
}

package spring;

import java.util.Date;

import javax.annotation.Resource;

public class MemberRegisterService {
	@Resource
	private MemberDao memberDao;
	
	//어노테이션 @Resource도 같은 역할 but 생성자에 선언 불가
	//@Autowired
	
	public MemberRegisterService() {}
	
	public MemberRegisterService(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req){
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null){
			throw new AlreadyExistingMemberException(
						"dup email " + req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(),
				req.getPassword(),
				req.getName(),
				new Date()
				);
		memberDao.insert(newMember);		
	}
}

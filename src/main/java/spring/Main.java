package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appctx.xml");
		
		//xml에 선언된 객체 생성한후 Autowired선언을 본 타입을 보고 같은 타입의 자료형을 먼저 찾음 
		
		MemberInfoPrinter infoPrinter = 
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		
		infoPrinter.printMemberInfo("7575");
		
	}
}

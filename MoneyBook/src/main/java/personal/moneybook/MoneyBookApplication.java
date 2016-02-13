package personal.moneybook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import personal.moneybook.domain.Member;
import personal.moneybook.repository.MemberRepository;

@Slf4j
@SpringBootApplication
public class MoneyBookApplication implements CommandLineRunner {

	@Autowired
	private MemberRepository memberRepository;

	public static void main(String[] args) {
		SpringApplication.run(MoneyBookApplication.class, args);
		System.out.println("커밋여러번하면그게다 올라가네!!222");
	}

	@Override
	public void run(String... arg0) throws Exception {
		log.info("초기 데이터 생성!!");
		log.info(memberRepository.save(new Member(null, "강상규", 29)).toString());
		log.info(memberRepository.save(new Member(null, "장현지", 24)).toString());
	}
}

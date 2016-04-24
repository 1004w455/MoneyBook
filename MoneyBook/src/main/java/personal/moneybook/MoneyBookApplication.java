package personal.moneybook;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;
import personal.moneybook.domain.Role;
import personal.moneybook.domain.User;
import personal.moneybook.repository.UserRepository;

@Slf4j
@SpringBootApplication
public class MoneyBookApplication implements CommandLineRunner {

	@Autowired
	private UserRepository memberRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(MoneyBookApplication.class, args);
	}

	@PostConstruct
	public void init() {
		log.info("초기 데이터 생성!! 11111");
		log.info(memberRepository.save(new User(null, "admin@a.a", bCryptPasswordEncoder.encode("123"), Role.ADMIN, "강상규", 29)).toString());
	}

	@Override
	public void run(String... arg0) throws Exception {
		log.info("초기 데이터 생성!! 22222");
		log.info(memberRepository.save(new User(null, "user@a.a", bCryptPasswordEncoder.encode("123"), Role.USER, "유저", 19)).toString());
		log.info(memberRepository.save(new User(null, "etc@a.a", bCryptPasswordEncoder.encode("123"), Role.ETC, "etc", 19)).toString());
	}
}

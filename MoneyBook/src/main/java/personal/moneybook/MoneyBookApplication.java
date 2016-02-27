package personal.moneybook;

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

	public static void main(String[] args) {
		SpringApplication.run(MoneyBookApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		log.info("초기 데이터 생성!!");
		BCryptPasswordEncoder password = new BCryptPasswordEncoder();
		log.info(memberRepository.save(new User(null, "a@a.a", password.encode("123"), Role.ADMIN, "강상규", 29))
				.toString());
	}
}

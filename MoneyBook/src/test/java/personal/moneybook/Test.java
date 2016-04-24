package personal.moneybook;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
	public static void main(String[] args) {
		BCryptPasswordEncoder pwe = new BCryptPasswordEncoder();

		String rawPassword = "123123";
		String encodedPassword = pwe.encode(rawPassword);

		System.out.println(encodedPassword);
		System.out.println(pwe.matches(rawPassword, encodedPassword));
	}
}
// $2a$10$2f4xGOx7km4fYLS6/hcKiOMYkNP2idDqLhYG.0JFX7slWtNZeRvw6
// $2a$10$qeK2M5HJfs7pp35UG5E.gO46iySuclnBCv4lEiMy/ag6atXZTmbS6
// $2a$10$vsU9i2BHVBB1K4F0D8SQLeEyjzfqjJ4IEW3YoWrn8LbJqdDW5GTza

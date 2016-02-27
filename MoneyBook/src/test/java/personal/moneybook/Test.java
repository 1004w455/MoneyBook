package personal.moneybook;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
	public static void main(String[] args) {
		BCryptPasswordEncoder a = new BCryptPasswordEncoder();
		System.out.println(a.encode("123123"));
		System.out.println(a.encode("123123"));
	}
}
// $2a$10$2f4xGOx7km4fYLS6/hcKiOMYkNP2idDqLhYG.0JFX7slWtNZeRvw6
// $2a$10$qeK2M5HJfs7pp35UG5E.gO46iySuclnBCv4lEiMy/ag6atXZTmbS6

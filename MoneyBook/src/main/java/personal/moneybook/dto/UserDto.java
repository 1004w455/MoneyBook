package personal.moneybook.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import lombok.Data;
import personal.moneybook.domain.Role;

@Component
public class UserDto {

	@Data
	public static class Signup {
		@NotEmpty
		private String email;
		@NotEmpty
		private String password;
		private Role role;
		private String name;
		private int age;

	}

}

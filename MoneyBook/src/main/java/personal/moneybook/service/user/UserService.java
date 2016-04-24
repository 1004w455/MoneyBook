package personal.moneybook.service.user;

import java.util.Optional;

import personal.moneybook.domain.User;
import personal.moneybook.dto.UserDto.Signup;

public interface UserService {

	Optional<User> getUserById(long id);

	Optional<User> getUserByEmail(String email);

	boolean signup(Signup signup);
}

package personal.moneybook.service.user;

import java.util.Optional;

import personal.moneybook.domain.User;

public interface UserService {

	Optional<User> getUserById(long id);

	Optional<User> getUserByEmail(String email);
}

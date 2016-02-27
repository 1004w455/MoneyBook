package personal.moneybook.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import personal.moneybook.domain.User;
import personal.moneybook.repository.UserRepository;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	// @Autowired
	// public UserServiceImpl(UserRepository userRepository) {
	// this.userRepository = userRepository;
	// }

	@Override
	public Optional<User> getUserById(long id) {
		log.info("Getting user={}", id);
		return Optional.ofNullable(userRepository.findOne(id));
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		log.info("Getting user by email={}", email.replaceFirst("@.*", "@***"));
		return userRepository.findOneByEmail(email);
	}

}

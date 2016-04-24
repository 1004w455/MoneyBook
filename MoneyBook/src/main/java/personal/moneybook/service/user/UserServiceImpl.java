package personal.moneybook.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import personal.moneybook.domain.User;
import personal.moneybook.dto.UserDto.Signup;
import personal.moneybook.repository.UserRepository;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;

	// @Autowired
	// public UserServiceImpl(UserRepository userRepository) {
	// this.userRepository = userRepository;
	// }

	@Override
	@Transactional(readOnly = true)
	public Optional<User> getUserById(long id) {
		log.info("Getting user={}", id);
		return Optional.ofNullable(userRepository.findOne(id));
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> getUserByEmail(String email) {
		log.info("Getting user by email={}", email.replaceFirst("@.*", "@***"));
		return userRepository.findOneByEmail(email);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean signup(Signup signup) {
		userRepository.save(new User(null, signup.getEmail(), bCryptPasswordEncoder.encode(signup.getPassword()), signup.getRole(), signup.getName(), signup.getAge()));
		return true;
	}

}

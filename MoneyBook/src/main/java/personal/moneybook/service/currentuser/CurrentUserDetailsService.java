package personal.moneybook.service.currentuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import personal.moneybook.domain.CurrentUser;
import personal.moneybook.domain.User;
import personal.moneybook.service.user.UserService;

@Slf4j
@Service
public class CurrentUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	// @Autowired
	// public CurrentUserDetailsService(UserService userService) {
	// this.userService = userService;
	// }

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.info("이메일 = {} 의 사용자를 인증 시도합니다.", email);
		User user = userService.getUserByEmail(email) //
				.orElseThrow(() -> new UsernameNotFoundException(String.format("이메일 = %s 의 사용자를 찾을 수 없습니다.", email)));
		return new CurrentUser(user);
	}

}

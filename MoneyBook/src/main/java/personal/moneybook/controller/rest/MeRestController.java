package personal.moneybook.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import personal.moneybook.domain.CurrentUser;
import personal.moneybook.domain.User;
import personal.moneybook.repository.UserRepository;

@RestController
public class MeRestController {

	@Autowired
	private UserRepository userRepository;

	// 메소드별 권한 지정 예제.
	// @Secured("ROLE_ADMIN")
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public User me() {
		return userRepository.findMe().get();
	}

	// spring-security에 인증된 유저를 메소드 이용하여 조회하는 방법.
	@RequestMapping(value = "/me/p", method = RequestMethod.GET)
	public User principal() {
		CurrentUser cu = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return cu.getUser();
	}

	// spring-security-data를 이용하여 데이터베이스를 조회하는 방법.
	@RequestMapping(value = "/me/s", method = RequestMethod.GET)
	public User securityData() {
		return userRepository.findMe().get();
	}

}

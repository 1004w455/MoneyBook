package personal.moneybook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import personal.moneybook.domain.User;
import personal.moneybook.repository.UserRepository;

@RestController
public class AdminController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public List<User> admin() {
		return userRepository.findAll();
	}
}

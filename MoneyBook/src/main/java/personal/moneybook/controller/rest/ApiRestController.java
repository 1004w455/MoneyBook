package personal.moneybook.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import personal.moneybook.domain.Role;
import personal.moneybook.domain.User;
import personal.moneybook.repository.UserRepository;

@RestController
public class ApiRestController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@RequestMapping(value = "/api/{id}", method = RequestMethod.GET)
	public User getById(@PathVariable Long id) {
		return userRepository.findOne(id);
	}

	@RequestMapping(value = "/api/name/{name}", method = RequestMethod.GET)
	public User getByName(@PathVariable String name) {
		return userRepository.findOneByName(name).get();
	}

	@RequestMapping(value = "/api/age/{age}", method = RequestMethod.GET)
	public User getByAge(@PathVariable int age) {
		return userRepository.findOneByAge(age).get();
	}

	@RequestMapping(value = "/api/create/{name}/{age}", method = RequestMethod.GET)
	public User api1(@PathVariable String name, @PathVariable int age) {
		return userRepository.save(new User(null, name, "", Role.USER, name, age));
	}
}

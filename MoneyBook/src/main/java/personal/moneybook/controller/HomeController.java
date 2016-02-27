package personal.moneybook.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import personal.moneybook.domain.User;
import personal.moneybook.repository.UserRepository;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ObjectMapper mapper;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() throws JsonProcessingException {
		ModelAndView mav = new ModelAndView("index");

		Collection<User> users = userRepository.findAll();

		users = users.stream() //
				.map(u -> new User(u.getId(), u.getEmail(), null, u.getRole(), u.getName(), u.getAge())) //
				.collect(Collectors.toList());

		String s = mapper.writeValueAsString(users);
		mav.addObject("members", s);

		log.info("home 접속!");
		return mav;
	}

}

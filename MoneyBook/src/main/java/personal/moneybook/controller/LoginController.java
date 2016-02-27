package personal.moneybook.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
		log.debug("Getting login page, error={}", error);
		return new ModelAndView("common/signin", "error", error);
	}

}

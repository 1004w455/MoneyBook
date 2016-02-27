package personal.moneybook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorPageController {

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView page403() {
		return new ModelAndView("common/403");
	}

}

package personal.moneybook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import personal.moneybook.domain.Member;
import personal.moneybook.repository.MemberRepository;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	private MemberRepository memberRepository;

	@RequestMapping(value = { "", "/", "home", "index" })
	public ModelAndView home() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		ModelAndView mav = new ModelAndView("index");

		List<Member> m = memberRepository.findAll();
		String s = mapper.writeValueAsString(m);
		mav.addObject("members", s);

		log.info("home 접속!");
		return mav;
	}
}

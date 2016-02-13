package personal.moneybook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import personal.moneybook.domain.Member;
import personal.moneybook.repository.MemberRepository;

@RestController
public class ApiController {

	@Autowired
	private MemberRepository memberRepository;

	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public List<Member> getAll() {
		return memberRepository.findAll();
	}

	@RequestMapping(value = "/api/{id}", method = RequestMethod.GET)
	public Member getById(@PathVariable Long id) {
		return memberRepository.findOne(id);
	}

	@RequestMapping(value = "/api/name/{name}", method = RequestMethod.GET)
	public Member getByName(@PathVariable String name) {
		return memberRepository.findOneByName(name);
	}

	@RequestMapping(value = "/api/age/{age}", method = RequestMethod.GET)
	public Member getByAge(@PathVariable int age) {
		return memberRepository.findOneByAge(age);
	}

	@RequestMapping(value = "/api/create/{name}/{age}", method = RequestMethod.GET)
	public Member api1(@PathVariable String name, @PathVariable int age) {
		return memberRepository.save(new Member(null, name, age));
	}
}

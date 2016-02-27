package personal.moneybook.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import personal.moneybook.domain.User;
import personal.moneybook.service.user.UserService;

@Slf4j
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	// private final UserCreateFormValidator userCreateFormValidator;

	// @Autowired
	// public UserController(UserService userService, UserCreateFormValidator
	// userCreateFormValidator) {
	// this.userService = userService;
	// this.userCreateFormValidator = userCreateFormValidator;
	// }

	// @InitBinder("form")
	// public void initBinder(WebDataBinder binder) {
	// binder.addValidators(userCreateFormValidator);
	// }

	@PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
	@RequestMapping("/user/{id}")
	public ModelAndView getUserPage(@PathVariable Long id) {
		log.info("Getting user page for user={}", id);

		Optional<User> user = userService.getUserById(id);
		System.out.println(user);

		return new ModelAndView("common/server_response", "data", userService.getUserById(id)
				.orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
	}
	//
	// @PreAuthorize("hasAuthority('ADMIN')")
	// @RequestMapping(value = "/user/create", method = RequestMethod.GET)
	// public ModelAndView getUserCreatePage() {
	// log.info("Getting user create form");
	// return new ModelAndView("user_create", "form", new UserCreateForm());
	// }
	//
	// @PreAuthorize("hasAuthority('ADMIN')")
	// @RequestMapping(value = "/user/create", method = RequestMethod.POST)
	// public String handleUserCreateForm(@Valid @ModelAttribute("form")
	// UserCreateForm form,
	// BindingResult bindingResult) {
	// log.info("Processing user create form={}, bindingResult={}", form,
	// bindingResult);
	// if (bindingResult.hasErrors()) {
	// // failed validation
	// return "user_create";
	// }
	// try {
	// userService.create(form);
	// } catch (DataIntegrityViolationException e) {
	// // probably email already exists - very rare case when multiple
	// // admins are adding same user
	// // at the same time and form validation has passed for more than one
	// // of them.
	// LOGGER.warn("Exception occurred when trying to save the user, assuming
	// duplicate email", e);
	// bindingResult.reject("email.exists", "Email already exists");
	// return "user_create";
	// }
	// // ok, redirect
	// return "redirect:/users";
	// }

}

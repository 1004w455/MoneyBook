package personal.moneybook.domain;

import org.springframework.security.core.authority.AuthorityUtils;

import lombok.Data;

@Data
public class CurrentUser extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = -3987287944669290425L;

	private User user;

	// userdetails의 User를 상속 받아 인증에 필요한 정보를 정보를 포함 할 수 있다.
	public CurrentUser(User user) {
		super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		this.user = user;
	}

}

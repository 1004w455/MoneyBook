package personal.moneybook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import personal.moneybook.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findOneByEmail(String email);

	Optional<User> findOneByName(String name);

	Optional<User> findOneByAge(int age);

	// security-data 예제
	@Query("select u from User u where u.email = ?#{principal.Username}")
	Optional<User> findMe();
}

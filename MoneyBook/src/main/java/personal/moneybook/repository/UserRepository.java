package personal.moneybook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import personal.moneybook.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findOneByEmail(String email);

	User findOneByName(String name);

	User findOneByAge(int age);
}

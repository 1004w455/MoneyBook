package personal.moneybook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import personal.moneybook.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findOneByName(String name);
	Member findOneByAge(int age);
}

package personal.moneybook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;

	@Column(nullable = false, updatable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String passwordHash;

	@Column(columnDefinition = "CHAR", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(length = 128)
	private String name;

	@Column(columnDefinition = "SMALLINT", length = 15)
	private int age;

}

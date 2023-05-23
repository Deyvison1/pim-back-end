package api.auth.api.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.auth.api.domain.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}

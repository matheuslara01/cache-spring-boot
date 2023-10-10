package br.com.incode.cache.repository;

import br.com.incode.cache.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

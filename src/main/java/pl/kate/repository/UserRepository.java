package pl.kate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kate.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

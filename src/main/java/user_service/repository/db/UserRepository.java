package user_service.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user_service.enity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

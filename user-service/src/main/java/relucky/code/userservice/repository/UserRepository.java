package relucky.code.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import relucky.code.userservice.entity.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}

package cds.poweredge.usermanageer.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import cds.poweredge.usermanageer.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
     void deleteById(Long id);
     Boolean existsBynombre (String name);

    Optional<User> findById(Long id);
    List <User> findBynombre(String name);
    
}
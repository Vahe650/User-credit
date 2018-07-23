package credit.credit.repository;

import credit.credit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {


    @Query("SELECT t FROM User t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :searchItem, '%')) OR LOWER(t.country)" +
            "LIKE LOWER(CONCAT('%', :searchItem, '%')) ORDER BY t.name ASC\n" + "  ")
    List<User> findUserByNameLike(@Param("searchItem") String find);

    List<User> findAllByOrderByNameAsc();

}

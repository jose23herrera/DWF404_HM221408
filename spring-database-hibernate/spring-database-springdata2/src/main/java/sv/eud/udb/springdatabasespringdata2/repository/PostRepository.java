package sv.edu.udb.springdatabasespringdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.springdatabasespringdata.repository.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}

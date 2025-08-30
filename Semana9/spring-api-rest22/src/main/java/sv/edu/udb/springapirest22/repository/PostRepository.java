package sv.edu.udb.springapirest22.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.springapirest22.repository.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
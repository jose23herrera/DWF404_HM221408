package sv.edu.udb.springapirest22.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.springapirest22.repository.repository.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
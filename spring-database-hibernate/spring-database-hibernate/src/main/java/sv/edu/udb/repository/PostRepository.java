package sv.edu.udb.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.repository.domain.Post;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class PostRepository {

    private final SessionFactory sessionFactory;

    public PostRepository(final SessionFactory sessionFactory) {
        this.sessionFactory = Objects.requireNonNull(sessionFactory);
    }

    public List<Post> findAll() {
        final String QUERY = "from Post p";
        return sessionFactory.getCurrentSession()
                .createQuery(QUERY, Post.class)
                .getResultList();
    }

    public Post findById(final Long id) {
        return sessionFactory.getCurrentSession().find(Post.class, id);
    }

    @Transactional
    public void save(final Post post) {
        sessionFactory.getCurrentSession().persist(post);
    }

    public void delete(final Post post) {
        sessionFactory.getCurrentSession().remove(post);
    }

    public void deleteById(final Long id) {
        final String QUERY = "delete from Post post where post.id=:id";
        sessionFactory.getCurrentSession()
                .createMutationQuery(QUERY)
                .setParameter("id", id)
                .executeUpdate();
    }

    // Complementario: método con Criteria API
    public List<Post> findByTitleCriteria(String title) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Post> cq = cb.createQuery(Post.class);
        Root<Post> root = cq.from(Post.class);
        cq.select(root).where(cb.equal(root.get("title"), title));
        return session.createQuery(cq).getResultList();
    }
}

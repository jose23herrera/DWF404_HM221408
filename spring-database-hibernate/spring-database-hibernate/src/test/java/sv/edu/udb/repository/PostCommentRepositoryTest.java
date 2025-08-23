package sv.edu.udb.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.repository.domain.Post;
import sv.edu.udb.repository.domain.PostComment;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostCommentRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostCommentRepository postCommentRepository;

    private Post testPost;

    @BeforeEach
    @Transactional
    void setUp() {
        testPost = Post.builder()
                .id(10L)
                .title("Post de prueba")
                .postDate(LocalDate.now())
                .build();
        postRepository.save(testPost);
    }

    @Test
    @Transactional
    void shouldSaveComment_When_NewCommentIsAdded() {
        PostComment comment = PostComment.builder()
                .id(1L)
                .review("Buen post")
                .post(testPost)
                .build();

        postCommentRepository.save(comment);

        PostComment saved = postCommentRepository.findById(1L);
        assertNotNull(saved);
        assertEquals("Buen post", saved.getReview());
        assertEquals(10L, saved.getPost().getId());
    }

    @Test
    @Transactional
    void shouldFindAllComments_When_CommentsExist() {
        PostComment comment1 = PostComment.builder().id(2L).review("Comentario 1").post(testPost).build();
        PostComment comment2 = PostComment.builder().id(3L).review("Comentario 2").post(testPost).build();
        postCommentRepository.save(comment1);
        postCommentRepository.save(comment2);

        List<PostComment> comments = postCommentRepository.findAll();
        assertTrue(comments.size() >= 2);
    }

    @Test
    @Transactional
    void shouldFindByReviewLike_When_UsingCriteriaAPI() {
        PostComment a = PostComment.builder().id(4L).review("Excelente artículo").post(testPost).build();
        PostComment b = PostComment.builder().id(5L).review("Artículo regular").post(testPost).build();
        postCommentRepository.save(a);
        postCommentRepository.save(b);

        List<PostComment> results = postCommentRepository.findByReviewLikeCriteria("Excelente");
        assertEquals(1, results.size());
        assertEquals(4L, results.get(0).getId());
    }
}

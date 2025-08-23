package sv.edu.udb.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.repository.domain.Post;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    @Transactional
    void initData() {
        final Long expectedId = 1L;
        final String expectedTitle = "SpringBoot as a back-end";
        final LocalDate expectedDate = LocalDate.of(2023, 9, 29);
        final Post newPost = Post.builder()
                .id(expectedId)
                .title(expectedTitle)
                .postDate(expectedDate)
                .build();
        postRepository.save(newPost);
    }

    @AfterEach
    @Transactional
    void cleanData(){
        postRepository.deleteById(1L);
    }

    @Test
    @Transactional
    void shouldHasOnePost_When_FindAll() {
        int expectedPostNumber = 1;
        final List<Post> actualPostList = postRepository.findAll();
        assertNotNull(actualPostList);
        assertEquals(expectedPostNumber, actualPostList.size());
    }

    @Test
    @Transactional
    void shouldGetPost_When_IdExist() {
        Long expectedId = 1L;
        final String expectedTitle = "SpringBoot as a back-end";
        final LocalDate expectedDate = LocalDate.of(2023, 9, 29);
        final Post actualPost = postRepository.findById(expectedId);
        assertNotNull(actualPost);
        assertEquals(expectedId, actualPost.getId());
        assertEquals(expectedTitle, actualPost.getTitle());
        assertEquals(expectedDate, actualPost.getPostDate());
    }

    @Test
    @Transactional
    void shouldSavePost_When_PostIsNew() {
        final Long expectedId = 2L;
        final String expectedTitle = "Anything you want to write";
        final LocalDate expectedDate = LocalDate.of(2024, 8, 24);
        final Post newPost = Post.builder()
                .id(expectedId)
                .title(expectedTitle)
                .postDate(expectedDate)
                .build();
        postRepository.save(newPost);

        final Post actualPost = postRepository.findById(expectedId);
        assertNotNull(actualPost);
        assertEquals(expectedId, actualPost.getId());
        assertEquals(expectedTitle, actualPost.getTitle());
        assertEquals(expectedDate, actualPost.getPostDate());

        postRepository.delete(newPost);
    }

    @Test
    @Transactional
    void shouldDeletePost_When_PostExist() {
        final Long expectedId = 3L;
        final String expectedTitle = "Deleted";
        final LocalDate expectedDate = LocalDate.of(2024, 8, 24);

        final Post newPost = Post.builder()
                .id(expectedId)
                .title(expectedTitle)
                .postDate(expectedDate)
                .build();

        postRepository.save(newPost);

        final Post actualPost = postRepository.findById(expectedId);
        assertNotNull(actualPost);

        postRepository.delete(newPost);

        final Post deletedPost = postRepository.findById(expectedId);
        assertNull(deletedPost);
    }

    @Test
    @Transactional
    void shouldFindByTitle_When_UsingCriteriaAPI() {
        final Long expectedId = 4L;
        final String expectedTitle = "Criteria Rocks";
        final LocalDate expectedDate = LocalDate.of(2024, 8, 25);
        final Post newPost = Post.builder()
                .id(expectedId)
                .title(expectedTitle)
                .postDate(expectedDate)
                .build();
        postRepository.save(newPost);

        List<Post> results = postRepository.findByTitleCriteria("Criteria Rocks");
        assertFalse(results.isEmpty());
        assertEquals(expectedId, results.get(0).getId());

        postRepository.delete(newPost);
    }
}

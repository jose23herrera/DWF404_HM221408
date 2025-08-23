package sv.edu.udb.repository.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(name = "post_date", nullable = false)
    private LocalDate postDate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<PostComment> comments = new ArrayList<>();
}

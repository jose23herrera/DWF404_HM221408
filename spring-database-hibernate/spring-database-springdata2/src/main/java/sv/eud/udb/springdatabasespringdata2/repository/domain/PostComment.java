package sv.eud.udb.springdatabasespringdata2.repository.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "post_comments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
}

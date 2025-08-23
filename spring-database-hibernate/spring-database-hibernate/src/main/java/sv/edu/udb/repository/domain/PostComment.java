package sv.edu.udb.repository.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "post_comments")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostComment {

    @Id
    private Long id;

    @Column(nullable = false, length = 400)
    private String review;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
}

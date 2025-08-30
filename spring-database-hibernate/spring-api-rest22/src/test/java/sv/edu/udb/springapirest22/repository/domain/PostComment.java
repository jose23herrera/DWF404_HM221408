package sv.edu.udb.springapirest22.repository.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "post_comments")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //Generacion automatica de id
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(nullable = false, length = 500)
    private String text;

    @Column(name = "comment_date", nullable = false)
    private LocalDate commentDate;
}

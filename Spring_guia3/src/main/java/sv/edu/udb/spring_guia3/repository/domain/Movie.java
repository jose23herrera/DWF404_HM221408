package sv.edu.udb.spring_guia3.repository.domain;

import lombok.*;

@Getter
@Setter
@Builder // ¡Esta anotación genera el Builder!
@NoArgsConstructor // Default constructor
@AllArgsConstructor //All attribute constructor
public class Movie {
    private Long id;
    private String name;
    private String type;
    private Integer releaseYear;
}
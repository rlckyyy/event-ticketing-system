package relucky.code.userservice.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
@Builder
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}

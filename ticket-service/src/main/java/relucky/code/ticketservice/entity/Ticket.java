package relucky.code.ticketservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Builder
public class Ticket {
    @Id
    private Long id;
    private LocalDateTime boughtTime;
    private Long eventId;
    private String userId;
    private String code;
}

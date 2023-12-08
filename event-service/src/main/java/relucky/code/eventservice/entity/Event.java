package relucky.code.eventservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;
import relucky.code.eventservice.enums.EventType;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Builder
public class Event {
    @Id
    private Long id;
    private String title;
    private LocalDate time;
    private String description;
    @Enumerated(EnumType.STRING)
    private EventType type;
}

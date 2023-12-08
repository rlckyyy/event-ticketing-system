package relucky.code.eventservice.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate time;
    private String description;
}

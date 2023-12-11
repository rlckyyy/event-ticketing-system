package relucky.code.eventservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import relucky.code.eventservice.dto.EventDTO;
import relucky.code.eventservice.service.EventService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;
    @GetMapping
    ResponseEntity<?> findAll(){
        return ResponseEntity.ok(eventService.getAll());
    }
    @GetMapping("{id}")
    ResponseEntity<?> findOne(@PathVariable Long id){
        return ResponseEntity.ok(eventService.getOne(id));
    }
    @PostMapping
    ResponseEntity<?> create(@RequestBody EventDTO eventDTO){
        return ResponseEntity.ok(eventService.save(eventDTO));
    }
    @DeleteMapping("{id}")
    void delete(@PathVariable Long id){
        eventService.delete(id);
    }
}
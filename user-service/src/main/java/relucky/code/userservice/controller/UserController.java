package relucky.code.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import relucky.code.userservice.dto.UserDTO;
import relucky.code.userservice.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;
    @GetMapping
    ResponseEntity<?> findAll(){
        return ResponseEntity.ok(userService.getAll());
    }
    @GetMapping("{id}")
    ResponseEntity<?> findOne(@PathVariable String id){
        return ResponseEntity.ok(userService.getOne(id));
    }
    @PostMapping
    ResponseEntity<?> create(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.save(userDTO));
    }
    @DeleteMapping("{id}")
    void delete(@PathVariable String id){
        userService.delete(id);
    }
}

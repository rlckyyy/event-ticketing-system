package relucky.code.userservice.dto;

public record UserDTO(
        String firstName,
        String lastName,
        String email,
        Integer age
) {
}

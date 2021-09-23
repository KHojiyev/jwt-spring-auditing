package uzdev.jwtspringauditing.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @Size(min = 3,max = 50)
    private String firstName;

    @Size(min = 3,max = 50)
    private String lastName;

    private String email;

    private String password;



}

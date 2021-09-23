package uzdev.jwtspringauditing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import uzdev.jwtspringauditing.entity.enums.RoleName;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RoleName name;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;


    @Override
    public String getAuthority() {
        return roleName.name();  //  .toString()  can  use
    }
}

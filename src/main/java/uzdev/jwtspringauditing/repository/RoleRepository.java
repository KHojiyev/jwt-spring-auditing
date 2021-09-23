package uzdev.jwtspringauditing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uzdev.jwtspringauditing.entity.Role;
import uzdev.jwtspringauditing.entity.enums.RoleName;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {


    Role findByRoleName(RoleName roleName);

}

package kg.charginov.payment.models;

import kg.charginov.payment.models.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Admin extends User {

    public Admin(Long id, String fullName) {
        super(id, fullName, Role.ADMIN);
    }

    public void blockClient(Client client){
        System.out.println("Клиент с именем '" + client.getFullName()+"'");
        client.getCreditCard().setIsBlocked(true);
    }

}

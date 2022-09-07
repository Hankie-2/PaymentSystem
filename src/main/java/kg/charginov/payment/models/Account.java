package kg.charginov.payment.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    @Size(min = 10,max = 10,message = "Длина банковского номера должен быть 10 символов")
    Long accountNumber;

    Integer balance;

    public Account(Long accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0;
    }
}

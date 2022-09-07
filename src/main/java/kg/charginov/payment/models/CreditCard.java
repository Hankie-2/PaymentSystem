package kg.charginov.payment.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreditCard {

    @Size(min = 10,max = 10,message = "Длина банковского номера должен быть 10 символов")
    Long creditNumber;

    Integer limit;

    LocalDate expiredDate;

    Boolean isBlocked;

    public CreditCard(Long creditNumber) {
        this.creditNumber = creditNumber;
        this.limit = 100000;
        this.expiredDate = LocalDate.now().plusYears(4);
        this.isBlocked = false;
    }
}

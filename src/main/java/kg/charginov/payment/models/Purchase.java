package kg.charginov.payment.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Purchase {

    Long id;

    LocalDateTime date;

    @NotNull
    String purchase;

    @NotNull
    Integer price;

    public Purchase(Long id, String purchase,Integer price) {
        this.id = id;
        this.date = LocalDateTime.now();
        this.purchase = purchase;
        this.price = price;
    }
}

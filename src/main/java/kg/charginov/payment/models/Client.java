package kg.charginov.payment.models;

import kg.charginov.payment.models.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client extends User {

    @NotNull
    Account account;

    @NotNull
    CreditCard creditCard;

    public Client(Long id, String fullName, Account account, CreditCard creditCard) {
        super(id, fullName, Role.CLIENT);
        this.account = account;
        this.creditCard = creditCard;
    }

    public void buy(Purchase purchase){
        if(purchase!=null && account.getBalance()>purchase.getPrice()) {
            account.setBalance(account.getBalance()-purchase.getPrice());
            System.out.println("Вы успешно провели покупку, вы купили '" + purchase.getPurchase() +"'");
        }else{
            System.out.println("Не получилось осуществить покупку!");
        }
    }

    public void send(Client client,Integer money){
        if(client!=null && account.getBalance()>money){
            account.setBalance(account.getBalance()-money);
            client.getAccount().setBalance(client.getAccount().getBalance()+money);
            System.out.println("С вашего баланса было снято "+ money+" SOM");
            System.out.println("Баланс пользователя '" + client.getFullName() + "' было увеличено на " + money + " SOM");
        }else{
            System.out.println("Не получилось произвести перевод!");
        }
    }

    public void annul(){
        account.setBalance(0);
        System.out.println("Счет в банке с номером '"+ account.getAccountNumber() + "' аннулирован!");
    }

    public void replenishAccountBalance(Integer money){
        account.setBalance(account.getBalance()+money);
        System.out.println("Счет в банке успешно пополнен на "+money+" SOM");
    }

}

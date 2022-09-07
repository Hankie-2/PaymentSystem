package kg.charginov.payment;

import kg.charginov.payment.models.*;

public class Main {
    public static void main(String[] args) {
        /*
        Система Платежи.
        Клиент имеет Счет в банке и Кредитную Карту (КК).
         */
        Account account1 = new Account(1L);
        CreditCard creditCard1 = new CreditCard(1L);
        Client client1 = new Client(1L,"Charginov Marsel",account1,creditCard1);

        /*
        Клиент может оплатить Заказ
         */
        Purchase purchase = new Purchase(1L,"Компьютер",20000);
        client1.replenishAccountBalance(200000); // Так как у нас на балансе нет денег, то мы с начала пополняем свой баланс
        client1.buy(purchase);

        /*
        Сделать платеж на другой Счет
         */
        Account account2 = new Account(1L);
        CreditCard creditCard2 = new CreditCard(2L);
        Client client2= new Client(2L,"Okenov Emirlan",account2,creditCard2);

        client1.send(client2,10000);

        /*
        Заблокировать КК
         */
        Admin admin = new Admin(3L,"Ashyrbekov Emil");
        admin.blockClient(client1);

        /*
        Аннулировать Счет
         */

        client1.annul();
    }
}

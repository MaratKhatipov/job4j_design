package ru.ood.srp;

/*
Модуль обработки заказов
Если заказ верно сформирован,
он сохраняет его в базу данных
и высылает письмо для подтверждения заказа.

Такой модуль может измениться по трем причинам.
1. может стать другой логика обработки заказа,
2. способ его сохранения (тип базы данных),
2. способ отправки письма подтверждения (скажем, вместо email нужно отправлять SMS).

Принцип SRP подразумевает,
что три аспекта этой проблемы на самом деле — три разные обязанности.
 */
public class OrderProcessor {

    public void process(Order order) {
        if (order.isValid()) {
            sendConfirmationEmail(order);
        }
    }

    private void save(Order order) {
        System.out.println("сохраняем заказ в базу данных");
    }

    private void sendConfirmationEmail(Order order) {
        System.out.println("Шлем письмо клиенту");
    }

    private static class Order {
        private String validOrder;
        public boolean isValid() {
            if (!validOrder.equals("правильный заказ")) {
                System.out.println("Заказ свормирован неправильно");
                return false;
            }
            System.out.println("проверка правильности формирования заказа");
            return true;
        }
    }
}

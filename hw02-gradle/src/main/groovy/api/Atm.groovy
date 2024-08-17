package api

import bill.StackBills

interface Atm {

    /**
     * Добавить купюры
     * @param fiveThousandBill 5000
     * @param twoThousandBill 2000
     * @param oneThousandBill 1000
     * @param fiveHundredBill 500
     * @param twoHundredBill 200
     * @param oneHundredBill 100
     * @param fiftyBill 50
     */
    void addBills(
            int fiveThousandBill,
            int twoThousandBill,
            int oneThousandBill,
            int fiveHundredBill,
            int twoHundredBill,
            int oneHundredBill,
            int fiftyBill
    )

    /**
     * Получить остаток денежных средств
     * @return остаток
     */
    int getTotal()

    /**
     * Выдача денежных средств
     * @param amount количество запрощенных денежных средств
     * @return набор кюпюр
     */
    StackBills issueAmount(int amount)
}
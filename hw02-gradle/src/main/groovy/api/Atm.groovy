package api

import bill.StackBills

interface Atm {

    /**
     * Добавить купюры
     * @param fiveThousandBill 5000 номанил
     * @param twoThousandBill 2000 номанил
     * @param oneThousandBill 1000 номанил
     * @param fiveHundredBill 500 номанил
     * @param twoHundredBill 200 номанил
     * @param oneHundredBill 100 номанил
     * @param fiftyBill 50 номанил
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
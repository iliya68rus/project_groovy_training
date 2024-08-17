package api

interface Atm {
    /**
     * Добавить купюры
     * @param fiveThousandBills 5000
     * @param twoThousandBill 2000
     * @param oneThousandBill 1000
     * @param fiveHundredBill 500
     * @param twoHundredBill 200
     * @param oneHundredBills 100
     * @param fiftyBill 50
     */
    void addBills(
            int fiveThousandBills,
            int twoThousandBill,
            int oneThousandBill,
            int fiveHundredBill,
            int twoHundredBill,
            int oneHundredBills,
            int fiftyBill
    )

    /**
     * Получить остаток денежных средств
     * @return остаток
     */
    int getTotal()
}
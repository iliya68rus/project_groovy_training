class Atm {
    private final Storage storage

    Atm(Storage storage) {
        this.storage = storage
    }

    void addBills(
            int fiveThousandBills,
            int twoThousandBill,
            int oneThousandBill,
            int fiveHundredBill,
            int twoHundredBill,
            int oneHundredBills,
            int fiftyBill
    ) {
        storage.fiveThousandBill+= fiveThousandBills
        storage.twoThousandBill+= twoThousandBill
        storage.oneThousandBill+= oneThousandBill
        storage.fiveHundredBill+= fiveHundredBill
        storage.twoHundredBill+= twoHundredBill
        storage.oneHundredBill+= oneHundredBills
        storage.fiftyBill+= fiftyBill
    }

    int getTotal() {
        storage.fiveThousandBill.getTotal() +
                storage.twoThousandBill.getTotal() +
                storage.oneThousandBill.getTotal() +
                storage.fiveHundredBill.getTotal() +
                storage.twoHundredBill.getTotal() +
                storage.oneHundredBill.getTotal() +
                storage.fiftyBill.getTotal()
    }
}

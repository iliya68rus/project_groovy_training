class Atm {
    private final Storage storage

    Atm(Storage storage) {
        this.storage = storage
    }

    void addBills(
            int fiveThousandBills,
            int twoThousandBill,
            int oneHundredBills
    ) {
        storage.fiveThousandBills+= fiveThousandBills
        storage.twoThousandBill+= twoThousandBill
        storage.oneHundredBills+= oneHundredBills
    }

    int getTotal() {
        storage.oneHundredBills.getTotal() +
                storage.twoThousandBill.getTotal() +
                storage.fiveThousandBills.getTotal()
    }
}

class Atm {
    private final Storage storage

    Atm(Storage storage) {
        this.storage = storage
    }

    void addBills(
            int fiveThousandBills,
            int oneHundredBills
    ) {
        storage.fiveThousandBills+= fiveThousandBills
        storage.oneHundredBills+= oneHundredBills
    }

    int getTotal() {
        storage.fiveThousandBills + storage.oneHundredBills
    }
}

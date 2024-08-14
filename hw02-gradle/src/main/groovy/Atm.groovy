class Atm {
    private final Storage storage

    Atm(Storage storage) {
        this.storage = storage
    }

    def acceptBanknotes() {
        storage.fiveThousandBills++
        "GOOD"
    }
}

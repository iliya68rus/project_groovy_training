import api.Atm

import javax.management.OperationsException

class AtmImpl implements Atm {
    private final Storage storage

    AtmImpl(Storage storage) {
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
        if (fiveThousandBills < 0 ||
                twoThousandBill < 0 ||
                oneThousandBill < 0 ||
                fiveHundredBill < 0 ||
                twoHundredBill < 0 ||
                oneHundredBills < 0 ||
                fiftyBill < 0) {
            throw new OperationsException("Недопустимая операция")
        }

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

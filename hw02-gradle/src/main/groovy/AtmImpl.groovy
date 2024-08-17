import api.Atm
import bill.StackBills

import javax.management.OperationsException

class AtmImpl implements Atm {
    private final Storage storage

    AtmImpl(Storage storage) {
        this.storage = storage
    }

    @Override
    void addBills(
            int fiveThousandBill,
            int twoThousandBill,
            int oneThousandBill,
            int fiveHundredBill,
            int twoHundredBill,
            int oneHundredBill,
            int fiftyBill
    ) {
        if (fiveThousandBill < 0 ||
                twoThousandBill < 0 ||
                oneThousandBill < 0 ||
                fiveHundredBill < 0 ||
                twoHundredBill < 0 ||
                oneHundredBill < 0 ||
                fiftyBill < 0) {
            throw new OperationsException("Недопустимая операция")
        }

        storage.fiveThousandBill+= fiveThousandBill
        storage.twoThousandBill+= twoThousandBill
        storage.oneThousandBill+= oneThousandBill
        storage.fiveHundredBill+= fiveHundredBill
        storage.twoHundredBill+= twoHundredBill
        storage.oneHundredBill+= oneHundredBill
        storage.fiftyBill+= fiftyBill
    }

    @Override
    int getTotal() {
        storage.fiveThousandBill.getTotal() +
                storage.twoThousandBill.getTotal() +
                storage.oneThousandBill.getTotal() +
                storage.fiveHundredBill.getTotal() +
                storage.twoHundredBill.getTotal() +
                storage.oneHundredBill.getTotal() +
                storage.fiftyBill.getTotal()
    }

    @Override
    StackBills issueAmount(int amount) {
        return null
    }
}

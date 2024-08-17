import api.Atm
import bill.PlusBill
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
        if (amount <= 0 || amount % 50 != 0) {
            throw new OperationsException("Недопустимая операция")
        }
        def stack = new StackBills()

        def leftAmount = issueBill(storage.fiveThousandBill, amount)
        stack.fiveThousandBill = (int) ((amount - leftAmount) / storage.fiveThousandBill.getMultiplier())
        amount = leftAmount

        leftAmount = issueBill(storage.twoThousandBill, amount)
        stack.twoThousandBill = (int) ((amount - leftAmount) / storage.twoThousandBill.getMultiplier())
        amount = leftAmount

        leftAmount = issueBill(storage.oneThousandBill, amount)
        stack.oneThousandBill = (int) ((amount - leftAmount) / storage.oneThousandBill.getMultiplier())
        amount = leftAmount

        leftAmount = issueBill(storage.fiveHundredBill, amount)
        stack.fiveHundredBill = (int) ((amount - leftAmount) / storage.fiveHundredBill.getMultiplier())
        amount = leftAmount

        leftAmount = issueBill(storage.twoHundredBill, amount)
        stack.twoHundredBill = (int) ((amount - leftAmount) / storage.twoHundredBill.getMultiplier())
        amount = leftAmount

        leftAmount = issueBill(storage.oneHundredBill, amount)
        stack.oneHundredBill = (int) ((amount - leftAmount) / storage.oneHundredBill.getMultiplier())
        amount = leftAmount

        leftAmount = issueBill(storage.fiftyBill, amount)
        stack.fiftyBill = (int) ((amount - leftAmount) / storage.fiftyBill.getMultiplier())
        amount = leftAmount

        if (amount != 0) {
            throw new OperationsException("Недостаточно купюр")
        }
        return stack
    }

    private def issueBill(PlusBill bill, int amount) {
        def multiplier = bill.getMultiplier()
        def possibleBill = (int) (amount / bill.getMultiplier())
        if (possibleBill <= bill.getAmount()) {
            def possibleAmount = multiplier * possibleBill
            amount = amount - possibleAmount
            def leftBill = bill.getAmount() - possibleBill
            bill.setAmount(leftBill)
        }
        amount
    }
}

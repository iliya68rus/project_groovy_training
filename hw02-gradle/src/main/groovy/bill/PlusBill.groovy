package bill

trait PlusBill {
    PlusBill plus(Number right) {
        setAmount(getAmount() + right)
        this
    }

    int plus(PlusBill bill) {
        (getAmount() * getMultiplier()) + (bill.getAmount() * bill.getMultiplier())
    }

    void setAmount(int amount) {}

    int getAmount() {
        return 0
    }

    int getMultiplier() {
        return 0
    }

    int getTotal() {
        getAmount() * getMultiplier()
    }
}
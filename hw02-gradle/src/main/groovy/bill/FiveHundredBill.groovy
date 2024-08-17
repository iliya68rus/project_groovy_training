package bill

class FiveHundredBill implements PlusBill {
    private final int multiplier = 500
    private int amount

    @Override
    void setAmount(int amount) {
        this.amount = amount
    }

    @Override
    int getAmount() {
        return amount
    }

    @Override
    int getMultiplier() {
        return multiplier
    }
}

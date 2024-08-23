import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Spy
import org.mockito.junit.jupiter.MockitoSettings

import javax.management.OperationsException


import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertThrows

@MockitoSettings
class AtmImplTest {
    @InjectMocks
    private AtmImpl atm
    @Spy
    private Storage storage

    @Test
    void addFiveThousandBillsSuccessfully() {
        atm.addBills(2, 0, 0, 0, 0, 0, 0)

        assertEquals(10_000, atm.getTotal())
    }

    @Test
    void addTwoThousandBillSuccessfully() {
        atm.addBills(0, 2, 0, 0, 0, 0, 0)

        assertEquals(4_000, atm.getTotal())
    }

    @Test
    void addOneThousandBillSuccessfully() {
        atm.addBills(0, 0, 2, 0, 0, 0, 0)

        assertEquals(2_000, atm.getTotal())
    }

    @Test
    void addFiveHundredBillSuccessfully() {
        atm.addBills(0, 0, 0, 2, 0, 0, 0)

        assertEquals(1_000, atm.getTotal())
    }

    @Test
    void addTwoHundredBillSuccessfully() {
        atm.addBills(0, 0, 0, 0, 2, 0, 0)

        assertEquals(400, atm.getTotal())
    }

    @Test
    void addOneHundredBillSuccessfully() {
        atm.addBills(0, 0, 0, 0, 0, 2, 0)

        assertEquals(200, atm.getTotal())
    }

    @Test
    void addFiftyBillSuccessfully() {
        atm.addBills(0, 0, 0, 0, 0, 0, 2)

        assertEquals(100, atm.getTotal())
    }

    @Test
    void addBillThrowException() {
        assertThrows(OperationsException.class,
                () -> atm.addBills(-1, 0, 0, 0, 0, 0, 0)
        )
    }

    @Test
    void getTotalSuccessfully() {
        atm.addBills(2, 1, 1, 3, 2, 5, 1)

        assertEquals(15_450, atm.getTotal())
    }

    @Test
    void issueAmount1150Successfully() {
        atm.addBills(10, 10, 10, 10, 10, 10, 10)

        def stack = atm.issueAmount(1150)

        Assertions.assertAll(
                () -> assertEquals(0, stack.fiveThousandBill),
                () -> assertEquals(0, stack.twoThousandBill),
                () -> assertEquals(1, stack.oneThousandBill),
                () -> assertEquals(0, stack.fiveHundredBill),
                () -> assertEquals(0, stack.twoHundredBill),
                () -> assertEquals(1, stack.oneHundredBill),
                () -> assertEquals(1, stack.fiftyBill)
        )
    }

    @Test
    void issueAmount5500Successfully() {
        atm.addBills(10, 10, 10, 10, 10, 10, 10)

        def stack = atm.issueAmount(5500)

        Assertions.assertAll(
                () -> assertEquals(1, stack.fiveThousandBill),
                () -> assertEquals(0, stack.twoThousandBill),
                () -> assertEquals(0, stack.oneThousandBill),
                () -> assertEquals(1, stack.fiveHundredBill),
                () -> assertEquals(0, stack.twoHundredBill),
                () -> assertEquals(0, stack.oneHundredBill),
                () -> assertEquals(0, stack.fiftyBill)
        )
    }

    @Test
    void issueAmount2750Successfully() {
        atm.addBills(10, 10, 10, 10, 10, 10, 10)

        def stack = atm.issueAmount(2750)

        Assertions.assertAll(
                () -> assertEquals(0, stack.fiveThousandBill),
                () -> assertEquals(1, stack.twoThousandBill),
                () -> assertEquals(0, stack.oneThousandBill),
                () -> assertEquals(1, stack.fiveHundredBill),
                () -> assertEquals(1, stack.twoHundredBill),
                () -> assertEquals(0, stack.oneHundredBill),
                () -> assertEquals(1, stack.fiftyBill)
        )
    }

    @Test
    void issueAmount950Successfully() {
        atm.addBills(10, 10, 10, 10, 10, 10, 10)

        def stack = atm.issueAmount(950)

        Assertions.assertAll(
                () -> assertEquals(0, stack.fiveThousandBill),
                () -> assertEquals(0, stack.twoThousandBill),
                () -> assertEquals(0, stack.oneThousandBill),
                () -> assertEquals(1, stack.fiveHundredBill),
                () -> assertEquals(2, stack.twoHundredBill),
                () -> assertEquals(0, stack.oneHundredBill),
                () -> assertEquals(1, stack.fiftyBill)
        )
    }

    @Test
    void issueAmount5550OnlyFiftySuccessfully() {
        atm.addBills(0, 0, 0, 0, 0, 0, 50_000)

        def stack = atm.issueAmount(5_550)

        Assertions.assertAll(
                () -> assertEquals(0, stack.fiveThousandBill),
                () -> assertEquals(0, stack.twoThousandBill),
                () -> assertEquals(0, stack.oneThousandBill),
                () -> assertEquals(0, stack.fiveHundredBill),
                () -> assertEquals(0, stack.twoHundredBill),
                () -> assertEquals(0, stack.oneHundredBill),
                () -> assertEquals(111, stack.fiftyBill)
        )
    }

    @Test
    void issueAmountNotEnoughSuccessfully() {
        atm.addBills(1, 1, 1, 1, 1, 1, 1)

        assertThrows(OperationsException.class,
                () -> atm.issueAmount(10_000)
        )
    }

    @Test
    void negativeIssueAmountThrowException() {
        atm.addBills(10, 10, 10, 10, 10, 10, 10)

        assertThrows(OperationsException.class,
                () -> atm.issueAmount(-1)
        )
    }

    @Test
    void incorrectIssueAmountThrowException() {
        atm.addBills(10, 10, 10, 10, 10, 10, 10)

        assertThrows(OperationsException.class,
                () -> atm.issueAmount(1111)
        )
    }

    @Test
    void severalIssueAmountSuccessfully() {
        atm.addBills(10, 10, 10, 10, 10, 10, 10)

        def stack1 = atm.issueAmount(250)
        def stack2 = atm.issueAmount(10_050)

        Assertions.assertAll(
                () -> assertEquals(0, stack1.fiveThousandBill),
                () -> assertEquals(0, stack1.twoThousandBill),
                () -> assertEquals(0, stack1.oneThousandBill),
                () -> assertEquals(0, stack1.fiveHundredBill),
                () -> assertEquals(1, stack1.twoHundredBill),
                () -> assertEquals(0, stack1.oneHundredBill),
                () -> assertEquals(1, stack1.fiftyBill),
                () -> assertEquals(2, stack2.fiveThousandBill),
                () -> assertEquals(0, stack2.twoThousandBill),
                () -> assertEquals(0, stack2.oneThousandBill),
                () -> assertEquals(0, stack2.fiveHundredBill),
                () -> assertEquals(0, stack2.twoHundredBill),
                () -> assertEquals(0, stack2.oneHundredBill),
                () -> assertEquals(1, stack2.fiftyBill)
        )
    }

    @Test
    void severalIssueAmountFirstSuccessfullyAndSecondThrowException() {
        atm.addBills(1, 1, 1, 1, 1, 1, 1)

        def stack1 = atm.issueAmount(600)

        Assertions.assertAll(
                () -> assertEquals(0, stack1.fiveThousandBill),
                () -> assertEquals(0, stack1.twoThousandBill),
                () -> assertEquals(0, stack1.oneThousandBill),
                () -> assertEquals(1, stack1.fiveHundredBill),
                () -> assertEquals(0, stack1.twoHundredBill),
                () -> assertEquals(1, stack1.oneHundredBill),
                () -> assertEquals(0, stack1.fiftyBill),
                () -> assertThrows(OperationsException.class,
                        () -> atm.issueAmount(10_050)
                )
        )
    }

    @Test
    void issueAmount10000OnlyFiveThousandAndFiftySuccessfully() {
        atm.addBills(1, 0, 0, 0, 0, 0, 100)

        def stack1 = atm.issueAmount(10_000)

        Assertions.assertAll(
                () -> assertEquals(1, stack1.fiveThousandBill),
                () -> assertEquals(0, stack1.twoThousandBill),
                () -> assertEquals(0, stack1.oneThousandBill),
                () -> assertEquals(0, stack1.fiveHundredBill),
                () -> assertEquals(0, stack1.twoHundredBill),
                () -> assertEquals(0, stack1.oneHundredBill),
                () -> assertEquals(100, stack1.fiftyBill)
        )
    }
}

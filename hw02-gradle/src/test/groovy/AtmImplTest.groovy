import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Spy
import org.mockito.junit.jupiter.MockitoSettings

import javax.management.OperationsException

import static org.junit.jupiter.api.Assertions.assertEquals

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
        Assertions.assertThrows(OperationsException.class,
                () -> atm.addBills(-1, 0, 0, 0, 0, 0, 0)
        )
    }

    @Test
    void getTotalSuccessfully() {
        atm.addBills(2, 1, 1, 3, 2, 5, 1)

        assertEquals(15_450, atm.getTotal())
    }
}

import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Spy
import org.mockito.junit.jupiter.MockitoSettings

import static org.junit.jupiter.api.Assertions.assertEquals

@MockitoSettings
class AtmTest {
    @InjectMocks
    private Atm atm
    @Spy
    private Storage storage

    @Test
    void addFiveThousandBillsSuccessfully() {
        atm.addBills(15, 0)

        assertEquals(15, storage.fiveThousandBills.getAmount())
    }

    @Test
    void getTotalSuccessfully() {
        atm.addBills(2, 7)

        assertEquals(10_700, atm.getTotal())
    }
}

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito

import static org.junit.jupiter.api.Assertions.assertEquals

class AtmTest {
    private Atm atm
    private Storage storage

    @BeforeEach
    void init() {
        storage = Mockito.mock(Storage.class)
        atm = new Atm(storage)
    }

    @Test
    void acceptBanknotesSuccessfully() {
        assertEquals("GOOD", atm.acceptBanknotes())
        assertEquals(1, storage.fiveThousandBills)
    }
}

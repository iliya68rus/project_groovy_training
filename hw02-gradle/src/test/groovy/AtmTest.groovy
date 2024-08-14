import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoSettings

import static org.junit.jupiter.api.Assertions.assertEquals

@MockitoSettings
class AtmTest {
    @InjectMocks
    private Atm atm
    @Mock
    private Storage storage

    @Test
    void acceptBanknotesSuccessfully() {
        assertEquals("GOOD", atm.acceptBanknotes())
        assertEquals(1, storage.fiveThousandBills)
    }
}

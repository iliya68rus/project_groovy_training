import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AtmTest {
    private Atm atm;

    @BeforeEach
    void init() {
        atm = new Atm();
    }

    @Test
    void acceptBanknotesSuccessfully() {
        Assertions.assertEquals("GOOD", atm.acceptBanknotes())
    }
}

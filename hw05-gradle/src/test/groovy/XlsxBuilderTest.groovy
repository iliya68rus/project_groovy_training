

import org.junit.jupiter.api.Test;

//@MockitoSettings
class XlsxBuilderTest {
//    @InjectMocks
//    private XlsxBuilder xlsxBuilder;

    @Test
    void test() {
        new XlsxBuilder("test.xlsx") {
            sheet(0) {

            }
        }


        def r = """
                    new XlsxBuilder("test.xlsx") {
                        sheet(0) {
                            row(0) {
                                cell {
                                value = 1
                                style = new Style()
                            }
                            cell {
                                idx = 3
                                value = "test"
                                style = new Style()
                                }
                            }
                        }
                    }        
                """;
    }
}


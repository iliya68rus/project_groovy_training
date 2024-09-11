import static XlsxBuilder.*

xlsxBuilder("test") {
    sheet(1) {
        row(2) {
            cell {
                value = 5
            }

            cell {
                value = 3
            }
        }
    }
}

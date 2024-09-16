import static XlsxBuilder.*

xlsxBuilder("test") {
    sheet(3) {
        row(2) {
            cell {
                value = 5
            }
            cell {
                idx = 3
                value = 3
            }
        }
    }
    sheet {
        row(6) {
            cell {
                value = "cell"
            }
            cell {
                value = true
            }
        }
    }
}

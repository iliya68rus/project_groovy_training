//class XlsxBuilder {
//    XlsxBuilder(String fileName, Closure closure) {
//        println "start " + fileName
//        closure()
//    }
//}


def xlsxBuilder(String fileName, closure) {
    println "fileName " + fileName
    closure()
}

def sheet(int index, Closure closure) {
    println "sheet index " + index
    closure()
}

def row(int index, Closure closure) {
    println "row index " + index
    closure()
}

def cell(Closure closure) {
    def value = -1
    closure.delegate = this
    closure()
    println "cell value " + value
}


xlsxBuilder("test") {
    println "builder"
    sheet(1) {
        row(2) {
            cell {
                value = 5
            }
        }
    }
}

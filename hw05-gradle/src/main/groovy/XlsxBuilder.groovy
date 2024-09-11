class XlsxBuilder {
    static String fileName
    static List<SheetSpecification> sheets = []

    static void xlsxBuilder(String fileName, @DelegatesTo(SheetSpecification) Closure closure) {
        this.fileName = fileName

        def specification = new SheetSpecification()
        sheets += specification
        closure.delegate = specification
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()
        println "Финиш"
    }
}


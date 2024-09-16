class XlsxSpecification {
    String fileName
    List<SheetSpecification> sheets = []


    SheetSpecification sheet(@DelegatesTo(SheetSpecification) Closure closure) {
        sheet(null, closure)
    }

    SheetSpecification sheet(def name, @DelegatesTo(SheetSpecification) Closure closure) {
        def specification = new SheetSpecification()
        specification.name = name
        sheets += specification
        closure.delegate = specification
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()
        specification
    }
}

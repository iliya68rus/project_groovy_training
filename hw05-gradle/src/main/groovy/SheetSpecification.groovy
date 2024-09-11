class SheetSpecification {
    int number
    List<RowSpecification> rows = []

    RowSpecification sheet(int number, @DelegatesTo(RowSpecification) Closure closure) {
        this.number = number
        def specification = new RowSpecification()
        rows += specification
        closure.delegate = specification
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()
        specification
    }
}

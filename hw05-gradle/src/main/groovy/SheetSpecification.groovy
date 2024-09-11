class SheetSpecification {
    String name
    List<RowSpecification> rows = []

    RowSpecification row(int number, @DelegatesTo(RowSpecification) Closure closure) {
        def specification = new RowSpecification()
        specification.number = number
        rows += specification
        closure.delegate = specification
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()
        specification
    }
}

class RowSpecification {
    int number
    List<CellSpecification> cells = []

    CellSpecification row(int number, @DelegatesTo(CellSpecification) Closure closure) {
        this.number = number
        def specification = new CellSpecification()
        cells += specification
        closure.delegate = specification
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()
        specification
    }
}

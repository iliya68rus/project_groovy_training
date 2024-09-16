class RowSpecification {
    int number
    List<CellSpecification> cells = []

    CellSpecification cell(@DelegatesTo(CellSpecification) Closure closure) {
        def specification = new CellSpecification()
        cells += specification
        closure.delegate = specification
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()
        specification
    }
}

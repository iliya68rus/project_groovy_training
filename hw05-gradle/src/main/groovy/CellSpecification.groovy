class CellSpecification {
    List<ValueSpecification> values = []

    ValueSpecification cell(@DelegatesTo(ValueSpecification) Closure closure) {
        def specification = new ValueSpecification()
        values += specification
        closure.delegate = specification
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()
        specification
    }
}

class FluentTestSpec {
    static TestSpec given(@DelegatesTo(TestSpec) Closure closure) {
        def specification = new TestSpec()
        closure.delegate = specification
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()
        specification
    }
}

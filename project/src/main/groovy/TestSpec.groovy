class TestSpec {
    def target
    def result

    def target(Class clazz) {
        target = clazz.getDeclaredConstructors()[0].newInstance()
    }

    def when(@DelegatesTo(WhenSpec) Closure closure) {
        def specification = new WhenSpec(target)
        closure.delegate = specification
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        result = closure()
        this
    }

    def then(@DelegatesTo(ThenSpec) Closure closure) {
        def specification = new ThenSpec(result)
        closure.delegate = specification
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()
        specification
    }
}
class WhenSpec {
    def target

    WhenSpec(def target) {
        this.target = target
    }

    def callMethod(Closure closure) {
        closure.delegate = target
        def res = closure()
        res
    }
}

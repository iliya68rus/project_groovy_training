package fluent

class WhenSpec {
    def target

    WhenSpec(def target) {
        this.target = target
    }

    def callMethod(Closure closure) {
        closure(target)
    }
}

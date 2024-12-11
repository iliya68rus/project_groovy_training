package fluent

import org.mockito.Mockito

import java.lang.reflect.Constructor

class TestSpec {
    def target
    def result

    def target(Class clazz) {
        Constructor<?> constructor = clazz.getDeclaredConstructors()[0]
        def objects = []
        for (final Class type in constructor.getParameterTypes()) {
            objects += Mockito.mock(type)
        }
        target = constructor.newInstance(objects.toArray())
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
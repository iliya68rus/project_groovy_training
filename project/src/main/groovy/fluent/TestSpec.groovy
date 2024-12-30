package fluent

import org.mockito.Mockito

import java.lang.reflect.Constructor

class TestSpec {
    def target
    def result
    def mocks = []

    def target(Class clazz) {
        Constructor<?> constructor = clazz.getDeclaredConstructors()[0]
        def objects = []
        boolean notFound = true
        for (final Class type in constructor.getParameterTypes()) {
            def iterator = mocks.iterator()
            while (iterator.hasNext()) {
                def mock = iterator.next()
                if (mock.getClass() == type) {
                    objects += mock
                    iterator.remove()
                    notFound = false
                    break
                }
            }

            if (notFound) {
                objects += Mockito.mock(type)
            }
        }
        target = constructor.newInstance(objects.toArray())
    }

    def mocks(Object... mocks) {
        this.mocks = new ArrayList(mocks.toList())
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
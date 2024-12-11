package service

class MyService {
    private final Audit audit

    MyService(Audit audit) {
        this.audit = audit
    }

    def doSomething(int value) {
        audit.log("doSomething $value")
        return value * 2
    }

    def isEven(int value) {
        audit.log("isEven $value")
        return value % 2 == 0
    }
}

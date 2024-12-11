package service

class MyService {
    private final Audit audit

    MyService(Audit audit) {
        this.audit = audit
    }

    def doSomething(int value) {
        audit.log("doSomething $value")
        value * 2
    }

    def isEven(int value) {
        audit.log("isEven $value")
        value % 2 == 0
    }
}

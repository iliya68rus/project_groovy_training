package service

class MyService1 {
    private final Audit audit

    MyService1(Audit audit) {
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

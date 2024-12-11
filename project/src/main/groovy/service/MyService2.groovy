package service

class MyService2 {
    private final Audit audit
    private final String name1
    private final String name2

    MyService2(Audit audit, String name1, String name2) {
        this.audit = audit
        this.name1 = name1
        this.name2 = name2
    }

    def getFullName(String value) {
        audit.log("getFullName $value")
        "$name1 $name2 $value"
    }
}

package service

class Audit {
    void log(String value) {
        println value
    }

    def getType() {
        return "log"
    }
}

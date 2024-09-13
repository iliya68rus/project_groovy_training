import groovy.json.JsonSlurper
import groovy.xml.MarkupBuilder

static void main(String[] args) {
    def list = ["name", "age", "secretIdentity"]

    Map<String, Object> parse = new JsonSlurper().parse("https://raw.githubusercontent.com/Groovy-Developer/groovy-homeworks/main/hw-5/test.json".toURL()) as Map<String, Object>

    def mbHtml = new MarkupBuilder(new File("file.html").newPrintWriter())
    mbHtml.html() {
        head() {
            meta("charset": "UTF-8")
        }
        body() {
            div("id": "employee") {
                parse.forEach((k, v) -> {
                    if (list.contains(k)) {
                        p("$k=$v")
                    }
                    if ("powers" == k) {
                        ul("id": "powers") {
                            List<Object> objects = v as List<Object>
                            objects.forEach(e -> {
                                li(e)
                            })
                        }
                    }
                })
            }
        }
    }

    def mbXml = new MarkupBuilder(new File("file.xml").newPrintWriter())
    mbXml.xml() {
        employee() {
            parse.forEach((k, v) -> {
                if (list.contains(k)) {
                    "$k"("$v")
                }
                if ("powers" == k) {
                    powers() {
                        List<Object> objects = v as List<Object>
                        objects.forEach(e -> {
                            power(e)
                        })
                    }
                }
            })
        }
    }
}
import groovy.transform.ToString

@ToString
class ConfigStore {
    String name
    String description

    Integer httpPort
    Boolean httpSecurity

    Integer httpsPort
    Boolean httpsSecurity

    Map<String, Boolean> mapping = [:]
}
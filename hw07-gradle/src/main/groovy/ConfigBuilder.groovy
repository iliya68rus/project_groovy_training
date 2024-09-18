class ConfigBuilder {
    static String name
    static String description
    static String[] configs
    static List<Closure> mappings

    private static boolean checkConfigs = false
    private static ConfigStore store = new ConfigStore()
    private static HttpSpec http = new HttpSpec()
    private static HttpSpec https = new HttpSpec()

    static ConfigStore build() {
        build(null)
    }

    static ConfigStore build(String configName) {
        def script = getScript("parent.conf") + "\n"
        if (configName != null) {
            script += getScript(configName)
        }
        runScript(script)
        checkConfigs()

        store.name = name
        store.description = description
        store.httpPort = http.port
        store.httpSecurity = http.secure
        store.httpsPort = https.port
        store.httpsSecurity = https.secure

        store
    }

    static void include(String... configs) {
        ConfigBuilder.configs = configs
    }

    static void http(@DelegatesTo(HttpSpec) Closure closure) {
        checkConfigs()
        closure.delegate = http
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()
    }

    static void https(@DelegatesTo(HttpSpec) Closure closure) {
        checkConfigs()
        closure.delegate = https
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()
    }

    private static void checkConfigs() {
        if (checkConfigs) return
        checkConfigs = true

        for (final def name in configs) {
            runScript(getScript(name))
        }
    }

    private static void runScript(String script) {
        def binding = new Binding()
        def shell = new GroovyShell(binding)
        shell.evaluate("import static ConfigBuilder.*\n\n"+ script)
    }

    private static String getScript(String name) {
        def parentPath = this.getClassLoader().getResource(name).getFile()
        new File(parentPath).text
    }
}

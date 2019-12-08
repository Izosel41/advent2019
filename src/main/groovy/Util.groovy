class Util {

    static List<String> extractLines(String nameFile) {
        ClassLoader.getSystemResource(nameFile).readLines()
    }

    static List<Integer> convertStringToIntArray(String s) {
        def registry = s.tokenize(",")*.toInteger()
        registry
    }
}
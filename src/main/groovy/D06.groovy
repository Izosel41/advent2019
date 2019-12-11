import java.util.stream.Collectors

class D06 {

    String[][] createOrbits(List<String> cmds) {
        def planets = new ArrayList<>()

        for (String c : cmds) {
            def p = c.tokenize("(")
            planets[p[0]] = p[1]
        }


    }
}

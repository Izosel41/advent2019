import java.util.stream.Collectors

class D06 {

    Planet createOrbit(String cmd) {
        def orb = cmd.tokenize(")")
        Planet a = new Planet(orb[0])
        Planet b = new Planet(orb[1])
        b.orbits(a)
        a
    }

    Planet createOrbits(List<String> cmds) {
        List<Planet> planets = new ArrayList<>()

        for (String c : cmds) {
            Planet p = createOrbit(c)
            planets.add(p)
        }

        List<String> names = Collections.singletonList("COM")
        Planet root = new Planet("")

        for (String name : names) {
            List<Planet> pls = planets.stream().filter({ it.parent.name == name }).collect(Collectors.toList())
            names.remove()
            for (Planet p : pls) {
                planets.remove(p)
                p.orbits(root)
                names.add(p.name)
            }
        }
    }
}

public class Planet {
    String name
    Planet parent

    Planet(String name) {
        this.name = name
    }

    void orbits(Planet p) {
        this.parent = p
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Planet planet = (Planet) o

        if (name != planet.name) return false

        return true
    }

    int hashCode() {
        return (name != null ? name.hashCode() : 0)
    }
}

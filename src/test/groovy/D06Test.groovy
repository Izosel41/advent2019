class D06Test extends GroovyTestCase {

    D06 day = new D06()

    void testOrbits() {
        def planets = day.createOrbits(Util.extractLines("61.txt"))


/*
        D directly orbits C and indirectly orbits B and COM, a total of 3 orbits.
        L directly orbits K and indirectly orbits J, E, D, C, B, and COM, a total of 7 orbits.
        COM orbits nothing.
*/

    }

    void testFirst() {
        List passwords = new ArrayList()
        def range = 246515..739105
        range.forEach({ it -> day.findPassword(it) ? passwords.add(it) : null })
        println passwords.size()
    }

    void testAdjacent2() {
        assert true == day.adjacent2(112233.toInteger().toString().chars)
        assert false == day.adjacent2(123444.toInteger().toString().chars)
        assert true == day.adjacent2(111122.toInteger().toString().chars)
        assert false == day.adjacent2(246667.toInteger().toString().chars)
    }

    void testSecond() {
        List passwords = new ArrayList()
        def range = 246515..739105
        range.forEach({ it -> day.findPassword2(it) ? passwords.add(it) : null })
        passwords.stream().forEach({ println it })
        println passwords.size()
    }
}
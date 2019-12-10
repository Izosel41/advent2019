class D06Test extends GroovyTestCase {

    D06 day = new D06()

    void testCreateOrbit() {
        Planet a = day.createOrbit("AAA)BBB")
        assert a != null
        assert a.next != null
        assert a.name == "AAA"
        assert a.next[0].name == "BBB"
        assert a.next[0].next == null
    }

    void testOrbits() {
        day.createOrbits(Util.extractLines("61.txt"))
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
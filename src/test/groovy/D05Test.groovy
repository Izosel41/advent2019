class D05Test extends GroovyTestCase {

    void testIntCode() {
        IntCode code = new IntCode()
        assert 99 == code.run(Util.convertStringToIntArray("1002,4,3,4,33"))[4]
        assert 99 == code.run(Util.convertStringToIntArray("1101,100,-1,4,0"))[4]

        code.setInput(1)
        code.run(Util.convertStringToIntArray("3,0,4,0,99"))
        assert 1 == code.getOutput()
    }

    void testFirst() {
        IntCode code = new IntCode()
        code.setInput(1)
        def input = Util.convertStringToIntArray(Util.extractLines("5.txt").get(0))
        code.run(input)
        println code.getOutput()
    }

    void testPositionMode() {
        IntCode code = new IntCode()
        code.setInput(8)
        code.run(Util.convertStringToIntArray("3,9,8,9,10,9,4,9,99,-1,8"))
        assertEquals("test 1", 1, code.getOutput())

        code.setInput(1)
        code.run(Util.convertStringToIntArray("3,9,8,9,10,9,4,9,99,-1,8"))
        assertEquals("test 2", 0, code.getOutput())

        code.setInput(1)
        code.run(Util.convertStringToIntArray("3,9,7,9,10,9,4,9,99,-1,8"))
        assertEquals("test 3", 1, code.getOutput())

        code.setInput(9)
        code.run(Util.convertStringToIntArray("3,9,7,9,10,9,4,9,99,-1,8"))
        assertEquals("test 4", 0, code.getOutput())

        code.setInput(0)
        code.run(Util.convertStringToIntArray("3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9"))
        assertEquals("test 5", 0, code.getOutput())

        code.setInput(9)
        code.run(Util.convertStringToIntArray("3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9"))
        assertEquals("test 6", 1, code.getOutput())
    }

    void testImmediateMode() {
        IntCode code = new IntCode()
        code.setInput(8)
        code.run(Util.convertStringToIntArray("3,3,1108,-1,8,3,4,3,99"))
        assert 1 == code.getOutput()
        code.setInput(9)
        code.run(Util.convertStringToIntArray("3,3,1108,-1,8,3,4,3,99"))
        assert 0 == code.getOutput()

        code.setInput(1)
        code.run(Util.convertStringToIntArray("3,3,1107,-1,8,3,4,3,99"))
        assert 1 == code.getOutput()
        code.setInput(9)
        code.run(Util.convertStringToIntArray("3,3,1107,-1,8,3,4,3,99"))
        assert 0 == code.getOutput()
    }

    void testLarger() {
        IntCode code = new IntCode()
        code.setInput(1)
        code.run(Util.convertStringToIntArray("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"))
        assert 999 == code.getOutput()

        code.setInput(8)
        code.run(Util.convertStringToIntArray("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"))
        assert 1000 == code.getOutput()

        code.setInput(9)
        code.run(Util.convertStringToIntArray("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"))
        assert 1001 == code.getOutput()


    }

    void testSecond() {
        IntCode code = new IntCode()
        code.setInput(5)
        def input = Util.convertStringToIntArray(Util.extractLines("5.txt").get(0))
        code.run(input)
        println code.getOutput()
    }
}
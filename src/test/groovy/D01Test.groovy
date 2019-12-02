class D01Test extends GroovyTestCase {

	D01 day = new D01()

	void testFirst(){
		def input = Util.extractLines("1.txt")
		println day.fuel(input)
	}

	void testFuel12(){
		assert 2 == day.fuel(["12"])
		assert 2 == day.fuel(["14"])
		assert 654 == day.fuel(["1969"])
		assert 33583 == day.fuel(["100756"])
	}

	void testSecond() {
		def input = Util.extractLines("1.txt")
		println("response is " + day.calibrateUntil(input))
	}
}
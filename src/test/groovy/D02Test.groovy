class D02Test extends GroovyTestCase {

	D02 day = new D02()

	void testFuel(){
		assert 3500 == day.intcode("1,9,10,3,2,3,11,0,99,30,40,50")
		assert 2 == day.intcode("1,0,0,0,99")
		assert 6 == day.intcode("2,3,0,3,99")
		assert 9801 == day.intcode("2,4,4,5,99,0")
		assert 30 == day.intcode("1,1,1,4,99,5,6,0,99")
	}

	void testFirst(){
		def input = Util.extractLines("2.txt")
		println day.intcode(input)
	}

	void testExtraFuel(){
		assert 2 == day.extraFuel(["14"])
		assert 966 == day.extraFuel(["1969"])
		assert 50346 == day.extraFuel(["100756"])
	}

	void testSecond() {
		def input = Util.extractLines("1.txt")
		println("response is " + day.extraFuel(input))
	}
}
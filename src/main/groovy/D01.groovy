class D01 {

    int fuel(List<String> masses) {
        masses*.toInteger().inject(0, calculateFuel(0))
    }

    def calculateFuel(int total, int mass) {
        int division = mass.intdiv(3)
        division < 2 ? 0 : division - 2
    }

    def extraFuel(List<String> masses) {
        masses.inject(0) { fuel, it ->
            def fuelForMass = calculateFuel(it.toInteger())

            def fuelForFuel = {fm, def accu = 0 ->
                fm<1?0: accu + calculateFuel(fuelForMass)}.memoize()
            fuel + fuelForFuel(fuelForMass)
        }
    }

    def factorial
    factorial = { int n, def accu = 0 ->
        if (n < 1) return accu
        factorial.trampoline(n - 1, n * accu)
    }
    factorial = factorial.trampoline()
}
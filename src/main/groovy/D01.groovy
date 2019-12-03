class D01 {

    int fuel(List<String> masses) {
		masses.inject(0){fuel, it -> fuel + calculateFuel(it.toInteger()) }
    }

    private int calculateFuel(int it) {
       def fuel = it.intdiv(3) - 2
        fuel<0?0:fuel
    }

    def extraFuel(List<String> masses) {
        int result = 0

            for (int mass in masses*.toInteger()) {
                def fuelForMass = calculateFuel(mass)
                println(fuelForMass)
                def fuelForFuel
                fuelForFuel = { int n -> n<1?n: fuelForFuel(calculateFuel(n))}.memoize()
                result = result + fuelForFuel(fuelForMass)
            }

        result
    }
}
class D01 {

    int fuel(List<String> masses) {
		masses.inject(0){fuel, it -> fuel + calculateFuel(it) }
    }

    private int calculateFuel(String it) {
        it.toInteger().intdiv(3) - 2
    }

    def extrafuel(List<String> masses) {
        Set memory = []
        int result = 0
        boolean found = false

        while (true) {
            for (int mass in masses*.toInteger()) {
                def fuelForMass = calculateFuel(mass)
                def fuelForFuel = { long n -> n<0?n:calculateFuel(fuelForMass)}.memoize()
                result = result + fuelForFuel + fuelForMass
            }
        }
    }
}
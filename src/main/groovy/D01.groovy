class D01 {

    int fuel(List<String> masses) {
		masses.inject(0){fuel, it -> it.toInteger().intdiv(3) -2 + fuel}
    }

    def extrafuel(List<String> fuels) {
        Set memory = []
        int result = 0
        boolean found = false

        while (true) {
            for (int fuel in fuels*.toInteger()) {
                result = result + fuel
                found = !memory.add(result)
                if (found)
                    return result
            }
        }
    }
}
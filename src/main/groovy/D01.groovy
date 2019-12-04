class D01 {

    int fuel(List<String> masses) {
        masses*.toInteger().inject(0, calculateFuel)
    }

    Closure calculateFuel = { total, mass ->
        int division = mass.intdiv(3)
        division < 2 ? total : total + division - 2
    }

    def extraFuel(List<String> masses) {
        masses*.toInteger().inject(0, calculateExtrafuel)
    }

    Closure calculateExtrafuel = {total, mass ->
        println "mass :" +mass
        def fuelForMass = calculateFuel(total, mass)
        println "fuelForMass :" +fuelForMass
        int extra = calculateFuel(total,fuelForMass)
        println "extra :" +extra
        if(extra<3) total else calculateFuel(total, extra)
    }

    //fib = { long n -> n<2?n:fib(n-1)+fib(n-2) }.memoize()

/*
    def factorial
    factorial = { int n, def accu = 0 ->
        if (n < 1) return accu
        factorial.trampoline(n - 1, n * accu)
    }
    factorial = factorial.trampoline()*/
}
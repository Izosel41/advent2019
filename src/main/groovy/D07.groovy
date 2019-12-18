class D07 {

    public Integer thruster(def phases, int inputSignal, List<Integer> program) {
        IntCode code = new IntCode()
     //   println phases
        for (int i = 0; i < phases.size(); i++) {
        //    println "phase" + phases[i]
        //    println "input " + inputSignal
            code.io.add(phases[i])
            code.io.add(inputSignal)
            code.run(program)
            inputSignal = code.io.removeFirst()
        }
     //   println inputSignal
        inputSignal
    }

    public Integer feedbackLoop(def phases, int inputSignal, List<Integer> program) {
        IntCode code = new IntCode()
        def loop = true
        def thruster = 0
        while(loop) {
            for (int i = 0; i < phases.size(); i++) {
                thruster = inputSignal
                //    println "phase" + phases[i]
                //    println "input " + inputSignal
                code.io.add(phases[i])
                code.io.add(inputSignal)
                code.run(program)
                inputSignal = code.io.removeFirst()

                if (inputSignal==99)
                    loop = false
                println inputSignal
            }
        }
        thruster
    }

}

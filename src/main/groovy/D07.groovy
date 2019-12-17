class D07 {

    public Integer thruster(def phases, int inputSignal, List<Integer> program) {
        IntCode code = new IntCode()
        println phases
        for (int i = 0; i < phases.size(); i++) {
            println "phase" + phases[i]
            println "input " + inputSignal
            code.io.add(phases[i])
            code.io.add(inputSignal)
            code.run(program)
            inputSignal = code.io.removeFirst()
        }
        inputSignal
    }
}

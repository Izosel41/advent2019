class IntCode {

    Queue<Integer> io = new LinkedList<Integer>()

    List<Integer> run(final List<Integer> programOriginal) {
        def program = programOriginal.clone()
        int pos = 0

        while (99 != program[pos]) {
            println program
            Instruction instruction = new Instruction(program[pos])
            println "[" +pos +"] "+ instruction

            switch (instruction.operation) {
                case 1:
                    pos = add(program, pos, instruction.modes)
                    break
                case 2:
                    pos = multiply(program, pos, instruction.modes)
                    break
                case 3:
                    pos = input(program, pos)
                    break
                case 4:
                    pos = output(program, pos, instruction.modes)
                    break
                case 5:
                    pos = jumpIfTrue(program, pos, instruction.modes)
                    break
                case 6:
                    pos = jumpIfFalse(program, pos, instruction.modes)
                    break
                case 7:
                    pos = lessThan(program, pos, instruction.modes)
                    break
                case 8:
                    pos = equals(program, pos, instruction.modes)
                    break
                case 99:
                    return program
                    break
            }
        }
        program
    }

    public int equals(program, int pos, int[] modes) {
        def a = getValue(program, pos + 1, modes[0])
        def b = getValue(program, pos + 2, modes[1])
        if (a == b)
            program[program[pos + 3]] = 1
        else
            program[program[pos + 3]] = 0
        pos = pos + 4
        pos
    }

    public int lessThan(program, int pos, int[] modes) {
        def a = getValue(program, pos + 1, modes[0])
        def b = getValue(program, pos + 2, modes[1])
        if (a < b)
            program[program[pos + 3]] = 1
        else
            program[program[pos + 3]] = 0
        pos = pos + 4
        pos
    }

    public int jumpIfFalse(program, int pos, int[] modes) {
        def a = getValue(program, pos + 1, modes[0])
        if (a == 0)
            pos = getValue(program, pos + 2, modes[1])
        else
            pos = pos + 3
        pos
    }

    public int jumpIfTrue(program, int pos, int[] modes) {
        def a = getValue(program, pos + 1, modes[0])
        if (a != 0)
            pos = getValue(program, pos + 2, modes[1])
        else
            pos = pos + 3
        pos
    }

    public int output(program, int pos, int[] modes) {
        io.add(getValue(program, pos + 1, modes[0]))
        pos = pos + 2
        pos
    }

    // 3
    public int input(program, int pos) {
        program[program[pos + 1]] = io.removeFirst()
        pos = pos + 2
        pos
    }

    // 2
    public int multiply(program, int pos, int[] modes) {
        program[program[pos + 3]] = getValue(program, pos + 1, modes[0]) * getValue(program, pos + 2, modes[1])
        pos = pos + 4
        pos
    }

    // 1
    public int add(program, int pos, int[] modes) {
        def a = getValue(program, pos + 1, modes[0])
        def b = getValue(program, pos + 2, modes[1])
        program[program[pos + 3]] = a + b
        pos = pos + 4
        pos
    }

    Integer getValue(def registry, Integer cur, Integer mode){
        switch (mode) {
            case 0:
                return postionMode(registry, cur)
            case 1:
                return immediateMode(registry, cur)
        }
    }

    Integer postionMode(def registry, int cur){
        registry[registry[cur]]
    }

    Integer immediateMode(def registry, int cur){
        registry[cur]
    }
}

public class Instruction{
    int operation
    int[] modes

    Instruction(Integer ins) {
        if(ins<10) {
            this.operation = ins
            this.modes = [0, 0]
        }else{
            def instruction = ins.toString()
            this.operation = Integer.parseInt(instruction.substring(instruction.length()-2, instruction.length()))
            char[] a = instruction.substring(0,instruction.length()-2).reverse().chars
            List<Integer> m = new ArrayList<>()
            for (char c : a) {
                m.add(Character.getNumericValue(c))
            }
            if (m.size() == 1)
                m.add(0)
            this.modes = m
        }
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "operation=" + operation +
                ", modes=" + Arrays.toString(modes) +
                '}';
    }
}

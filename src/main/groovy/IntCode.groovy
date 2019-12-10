class IntCode {
    int input = 99
    int output = 99

    List<Integer> run( List<Integer> program) {
        int pos = 0

        while (99 != program[pos]) {
            Instruction instruction = new Instruction(program[pos])

            switch (instruction.operation) {
                case 1:
                    def a = getValue(program, pos + 1, instruction.modes[0])
                    def b = getValue(program, pos + 2, instruction.modes[1])
                    program[program[pos + 3]] = a + b
                    pos = pos + 4
                    break
                case 2:
                    program[program[pos + 3]] = getValue(program, pos + 1, instruction.modes[0]) * getValue(program,pos + 2, instruction.modes[1])
                    pos = pos + 4
                    break
                case 3:
                    program[program[pos+1]] = this.input
                    pos = pos +2
                    break
                case 4:
                    this.output = program[program[pos+1]]
                    pos = pos +2
                    break
                case 5:
                    def a = getValue(program, pos + 1, instruction.modes[0])
                    if(a != 0)
                        pos = getValue(program, pos + 2, instruction.modes[1])
                    else
                        pos = pos + 3
                    break
                case 6:
                    def a = getValue(program, pos + 1, instruction.modes[0])
                    if(a == 0)
                        pos = getValue(program, pos + 2, instruction.modes[1])
                    else
                        pos = pos + 3
                    break
                case 7:
                    def a = getValue(program, pos + 1, instruction.modes[0])
                    def b = getValue(program, pos + 2, instruction.modes[1])
                    if(a<b)
                        program[program[pos + 3]] = 1
                    else
                        program[program[pos + 3]] = 0
                    pos = pos + 4
                    break
                case 8:
                    def a = getValue(program, pos + 1, instruction.modes[0])
                    def b = getValue(program, pos + 2, instruction.modes[1])
                    if(a==b)
                        program[program[pos + 3]] = 1
                    else
                        program[program[pos + 3]] = 0
                    pos = pos + 4
                    break
                case 99:
                    return program
                    break
            }
        }
        program
    }

    int getValue(def registry, Integer cur, Integer mode){
        switch (mode) {
            case 0:
                return postionMode(registry, cur)
            case 1:
                return immediateMode(registry, cur)
        }
    }

    int postionMode(def registry, int cur){
        registry[registry[cur]].intValue()
    }

    int immediateMode(def registry, int cur){
        registry[cur].intValue()
    }
}

public class Instruction{
    int operation
    int[] modes

    Instruction(Integer ins) {
        switch (ins){
            case 1:
            case 2:
            case 5:
            case 6:
            case 7:
            case 8:
                this.operation = ins
                this.modes = [0,0]
                break
            case 3:
            case 4:
                this.operation = ins
                break
            default:
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
                break
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

class D02 {
    def int intcode(String s) {
        def registry = s.tokenize(",")*.toInteger()

        int cur = 0
        while (99 != registry[cur]) {

            switch (registry[cur]) {
                case 1:
                    registry[]
                    break
                case 2:
                    break
                case 99:
                    break
                default:
                    return -99
            }
        }
    }
    }
}

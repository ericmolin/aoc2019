package solutions

import java.io.File

class Day2 : Day(2) {
    override fun partOneAnswer(): String {
        var input = getList().initialize(12, 2)
        return calculateOpcodes(input, 0).toString()
    }

    override fun partTwoAnswer(): String {
        val desiredResult = 19690720
        for (noun in 0..99)
            for (verb in 0..99)
                if (calculateOpcodes(getList().initialize(noun, verb), 0) == desiredResult)
                    return (100 * noun + verb).toString()
        return "0"
    }

    private fun getList() = inputAsString.trim().split(",").map { it.toInt() }.toTypedArray()

    private fun Array<Int>.initialize(noun: Int, verb: Int): Array<Int> {
        this[1] = noun
        this[2] = verb
        return this
    }

    private fun calculateOpcodes(list: Array<Int>, offset: Int): Int {
        var opcode = list[offset]
        var val1Position = list[offset + 1]
        var val2Position = list[offset + 2]
        var positionToReplace = list[offset + 3]

        when (opcode) {
            99 -> {
                return list[0]
            }
            1 -> {
                list[positionToReplace] = list[val1Position] + list[val2Position]
            }
            2 -> {
                list[positionToReplace] = list[val1Position] * list[val2Position]
            }
            else -> throw Error("Unsupported opcode detected")
        }
        return calculateOpcodes(list, offset + 4)
    }
}






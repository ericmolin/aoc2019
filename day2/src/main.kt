import java.io.File

private const val FILENAME = "day2/src/input.txt"

fun readFileToIntList() = File(FILENAME).readText().trim().split(",").map { it.toInt() }.toTypedArray()

fun Array<Int>.initialize(noun: Int, verb: Int): Array<Int> {
    this[1] = noun
    this[2] = verb
    return this
}

fun calculateOpcodes(list: Array<Int>, offset: Int): Int {
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

fun part2Helper(): Int {
    val desiredResult = 19690720
    for (noun in 0..99)
        for (verb in 0..99)
            if (calculateOpcodes(readFileToIntList().initialize(noun, verb), 0) == desiredResult)
                return 100 * noun + verb
    return 0;
}

fun part1Helper(): Int {
    var input = readFileToIntList().initialize(12, 2)
    return calculateOpcodes(input, 0)
}

fun main() {
    println("Part 1:" + part1Helper())
    println("Part 2:" + part2Helper())
}



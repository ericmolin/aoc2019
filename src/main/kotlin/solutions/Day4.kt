package solutions

import solutions.Day

class Day4 : Day(4) {
    override fun partOneAnswer(): String {
        val passwordRange = IntRange(getInput()[0].toInt(), getInput()[1].toInt())

        return passwordRange.asSequence().map { it.toString() }
            .filter { it.length == 6 }
            .filter { value -> value.windowed(2).any { it[0] == it[1] } }
            .filter { value -> value.windowed(2).none { it[0] > it[1] } }
            .count().toString()
    }

    override fun partTwoAnswer(): String {
        val passwordRange = IntRange(getInput()[0].toInt(), getInput()[1].toInt())
        TODO("not completed") //To change body of created functions use File | Settings | File Templates.
        return passwordRange.asSequence().map { it.toString() }
            .filter { it.length == 6 }
            .filter { value -> value.windowed(2).any { it[0] == it[1] } }
            .filter { value -> value.windowed(2).none { it[0] > it[1] } }
            .count().toString()


    }

    private fun getInput() = inputAsString.trim().split("-")
}
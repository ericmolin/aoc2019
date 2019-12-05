package solutions

import utils.FileReader

abstract class Day(day: Int) {
    abstract fun partOneAnswer(): String
    abstract fun partTwoAnswer(): String

    protected val inputAsList: List<String> = FileReader.fileAsList(day)
    protected val inputAsString: String = FileReader.fileAsString(day)

    companion object {
        val dayList = listOf(Day1(), Day2(), Day3(), Day4())
    }
}
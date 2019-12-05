package utils

import java.io.File

object FileReader {

    fun fileAsString(day: Int) = getFile(day).readText()

    fun fileAsList(day: Int) = getFile(day).readLines()

    private fun getFile(day: Int): File = File(javaClass.getResource("/day$day.txt").toURI())

}
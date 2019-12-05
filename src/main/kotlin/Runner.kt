
import solutions.Day
import solutions.Day1

object Runner {


    @JvmStatic
    fun main(args: Array<String>) {
        when {
            args.isNotEmpty() -> runDay(args[0])
            else -> throw Error("Unsupported input")
        }
    }

    private fun runDay(dayToRun : String) {
        var day = Day.dayList[dayToRun.toInt()-1]
        printDay(day)
    }

    private fun printDay(day : Day) {
        println(day.partOneAnswer())
        println(day.partTwoAnswer())
    }
}


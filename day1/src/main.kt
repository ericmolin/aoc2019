import java.io.File

private const val FILENAME = "day1/src/input.txt"

fun readFileToIntList() = File(FILENAME).useLines { it.toList().map { it.toInt() } }

fun calculateFuelConsumption(mass: Int): Int {
    return (mass / 3) - 2
}

fun calculateTotalFuelConsumptionPart1(list: List<Int>): Int {
    return list.map { calculateFuelConsumption(it) }.sum()
}

fun calculateFuelConsumptionHelperPart2(mass: Int): Int {
    var total = 0;
    var fuel = calculateFuelConsumption(mass)
    while (fuel > 0) {
        total += fuel
        fuel = calculateFuelConsumption(fuel)
    }
    return total
}

fun calculateTotalFuelConsumptionPart2(list: List<Int>): Int {
    return list.map { calculateFuelConsumptionHelperPart2(it) }.sum()
}

fun main() {
    var list = readFileToIntList()
    println(calculateTotalFuelConsumptionPart1(list))
    println(calculateTotalFuelConsumptionPart2(list))
}

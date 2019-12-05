package solutions

class Day1 : Day(1) {
    override fun partOneAnswer(): String {
        return inputAsList.map { calculateFuelConsumption(it.toInt()) }.sum().toString()
    }

    override fun partTwoAnswer(): String {
        return inputAsList.map { calculateFuelConsumptionPart2(it.toInt()) }.sum().toString()
    }

    private fun calculateFuelConsumption(mass: Int): Int {
        return (mass / 3) - 2
    }

    private fun calculateFuelConsumptionPart2(mass: Int): Int {
        var total = 0;
        var fuel = calculateFuelConsumption(mass)
        while (fuel > 0) {
            total += fuel
            fuel = calculateFuelConsumption(fuel)
        }
        return total
    }
}










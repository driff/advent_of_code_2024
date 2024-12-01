package advent_of_code.puzzles

import advent_of_code.utils.readFile

fun main() {
    historianHysteria()
}

fun historianHysteria() {
    val input = readFile("src/main/resources/inputs/day_01_input.txt")
    val (locationX, locationY) = input.split("\n")
        .fold(Pair(mutableListOf<String>(), mutableListOf<String>())) { acc, line ->
            line.split("   ").let {
                acc.first.addLast(it[0])
                acc.second.addLast(it[1])
            }
            acc
        }
    println(locationX.last())
    println(locationY.last())
}
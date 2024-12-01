package advent_of_code.puzzles

import advent_of_code.utils.readFile

fun main() {
    historianHysteriaA()
}

fun historianHysteriaA() {
    val input = readFile("src/main/resources/inputs/day_01_input.txt")
    val (locationX, locationY) = input.split("\n")
        .fold(Pair(mutableListOf<Int>(), mutableListOf<Int>())) { acc, line ->
            line.split("   ").let {
                acc.first.addLast(it[0].toInt())
                acc.second.addLast(it[1].toInt())
            }
            acc
        }
    locationX.sort()
    locationY.sort()
    locationX.foldIndexed(0) { index, acc, curr ->
        val distance = curr - locationY[index]
        if (distance < 0) {
            acc + (distance * -1)
        } else {
            acc + distance
        }
    }.let {
        println(it)
    }
}

fun historianHysteriaB() {
    val input = readFile("src/main/resources/inputs/day_01_input.txt")
    val (locationX, locationY) = input.split("\n")
        .fold(Pair(mutableListOf<Int>(), mutableListOf<Int>())) { acc, line ->
            line.split("   ").let {
                acc.first.addLast(it[0].toInt())
                acc.second.addLast(it[1].toInt())
            }
            acc
        }
    locationX.sort()
    locationY.sort()
    locationX.foldIndexed(0) { index, acc, curr ->
        val distance = curr - locationY[index]
        if (distance < 0) {
            acc + (distance * -1)
        } else {
            acc + distance
        }
    }.let {
        println(it)
    }
}
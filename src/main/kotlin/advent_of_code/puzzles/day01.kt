package advent_of_code.puzzles

import advent_of_code.utils.readFile

fun main() {
    historianHysteriaA()
    historianHysteriaB()
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
        println("part a -> $it")
    }
}

fun historianHysteriaB() {
    val input = readFile("src/main/resources/inputs/day_01_input.txt")
    val rightList = mutableListOf<Int>()
    val map = input.split("\n")
        .fold(mutableMapOf<Int, Int>()) { acc, line ->
            line.split("   ").let {
                acc[it[0].toInt()] = 0
                rightList.addLast(it[1].toInt())
            }
            acc
        }
    rightList.forEach {
        map[it]?.let { curr ->
            map[it] = curr+1
        }
    }
    var count = 0
    map.forEach { (key, value) ->
        count += key * value
    }
    println("part b -> $count")
}
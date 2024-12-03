package advent_of_code.puzzles

import advent_of_code.utils.readFile

const val INPUT_PATH = "src/main/resources/inputs/day_02_input.txt"

fun main() {
    redNosedReportA() // 686
    redNosedReportB()
}

val temp = """7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9"""

fun redNosedReportA() {
    val safetyRange = 1..3
    val input = readFile(INPUT_PATH)
    input.split("\n").fold(0) { acc, curr ->
        if(isSafeZone(curr.split(" "), safetyRange))
            acc+1
        else acc
    }.let {
        println("Safe zones count: $it")
    }
}

private fun isSafeZone(curr: List<String>, safetyRange: IntRange, tolerance: Int = 0): Boolean {
    var isSafe = false
    var faults = 0
    curr.indices.forEach { i ->
        if (faults > tolerance) return false
        when (i) {
            0 -> {
                if (curr[0] == curr[1]) {
                    faults++
                    return@forEach
                }
                else {
                    if (difference(curr[0].toInt(), curr[1].toInt()) !in safetyRange) {
                        faults++
                        return false
                    }
                }
            }
            curr.lastIndex -> isSafe = true
            else -> {
                if (isValidSequence(curr[i-1].toInt(), curr[i].toInt(), curr[i+1].toInt())) {
                    if (difference(curr[i].toInt(), curr[i+1].toInt()) !in safetyRange) {
                        faults++
                        return@forEach
                    }
                } else {
                    faults++
                    return@forEach
                }
            }
        }
    }
    return isSafe
}

private fun difference(a: Int, b: Int): Int = if (a > b) a - b else b - a

private fun isValidSequence(a: Int, b: Int, c: Int): Boolean =
    (a < b && b < c) || (a > b && b > c)

fun redNosedReportB() {
    val safetyRange = 1..3
    val input = readFile(INPUT_PATH)
    input.split("\n").fold(0) { acc, curr ->
        if(isSafeZone(curr.split(" ").toMutableList(), safetyRange, 1))
            acc+1
        else acc
    }.let {
        println("Safe zones count: $it")
    }
}
package advent_of_code.puzzles

import advent_of_code.utils.readFile

private const val INPUT_PATH = "src/main/resources/inputs/day_03_input.txt"

fun main() {
    mullItOverA() // 686
    mullItOverB()
}

private val regex = """mul\(\d{1,3},\d{1,3}\)""".toRegex()
private val regex2 = """(do\(\)|don't\(\)).*?mul\(\d{1,3},\d{1,3}\)|mul\(\d{1,3},\d{1,3}\)""".toRegex()

private fun mullItOverA() {
    val input = readFile(INPUT_PATH)
    regex.findAll(input).fold(0) { acc, curr ->
        val (a, b) = curr.value.replace("mul(", "").replace(")", "")
            .split(',').let { it[0].toInt() to it[1].toInt() }
        acc + (a*b)
    }.let {
        println("uncorrupted mul instructions: $it")
    }
}

val numRegex = """mul\((\d{1,3}),(\d{1,3})\)""".toRegex()

fun mullItOverB() {
    val input = readFile(INPUT_PATH)
    var doCount = 0
    var dontCount = 0
    var mulCount = 0
    var enabled = true
    regex2.findAll(input).fold(0) { acc, curr ->
        val mul = curr.value
        if (mul.contains("do()")) {
            doCount++
            enabled = true
        }
        if (mul.contains("don't()")) {
            dontCount++
            enabled = false
        }
        mulCount++
        if (!enabled) return@fold acc
        val (a, b) = numRegex.findAll(mul)
            .flatMap { match ->
                listOf(match.groupValues[1].toInt(), match.groupValues[2].toInt())
            }.toList()
        println("mul -> $mul || result -> ${(a*b)}")
        acc + (a*b)
    }.let {
        println("uncorrupted mul instructions 2: $it")
        println("doCount: $doCount")
        println("dont count : $dontCount")
        println("mul count: $mulCount")
    }
}
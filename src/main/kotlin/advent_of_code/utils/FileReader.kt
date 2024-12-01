package advent_of_code.utils

import kotlin.io.path.Path

fun readFile(path: String): String {
    val content = Path(path)
        .toFile()
        .inputStream()
        .bufferedReader()
        .readText()
    return content
}

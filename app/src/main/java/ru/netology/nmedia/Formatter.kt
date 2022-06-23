package ru.netology.nmedia

fun doCounterformat(value: Int): String {

    if (value < 1000) {
        return value.toString()
    } else if (value < 1_000_000) {
        return formatToString(((value / 100).toDouble() / 10)) + "К"
    } else {
        return formatToString(((value / 100_000).toDouble() / 10)) + "М"
    }
}

fun formatToString(value: Double): String {
    val containsZero = value.toString().contains(".0", true)

    return if (containsZero) {
        value.toInt().toString()
    } else {
        value.toString()
    }

}


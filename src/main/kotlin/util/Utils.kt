package util

fun log(where: String = "", what: Any? = null) {
    println("$where: on ${Thread.currentThread()}; argument = $what")
}
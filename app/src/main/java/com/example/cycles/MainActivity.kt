import kotlin.math.abs

fun main() {
    var sum = 0.0
    var term = 1.0
    var n = 1
    val epsilon = 0.000001

    while (abs(term) >= epsilon) {
        sum += term
        n++
        term = 1.0 / (n * n)
    }
}
@file:Suppress("UNUSED_PARAMETER")

package lesson2.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String =
        when {
            age % 100 in 11..20 || age % 10 == 0 || age % 10 in 5..9 -> "$age лет"
            age % 10 in 2..4 -> "$age года"
            else -> "$age год"
        }


/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    val firstWay: Double = t1 * v1
    val secondWay: Double = t2 * v2
    val thirdWay: Double = t3 * v3
    val halfWay: Double = ((firstWay + secondWay + thirdWay) / 2)
    return when {
        halfWay > (firstWay + secondWay) -> ((halfWay - (firstWay + secondWay)) / v3) + t1 + t2
        halfWay > firstWay -> ((halfWay - firstWay) / v2) + t1
        else -> halfWay / v1
    }
}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    val attackRookX1: Boolean = (kingX == rookX1)
    val attackRookY1: Boolean = (kingY == rookY1)
    val attackRookX2: Boolean = (kingX == rookX2)
    val attackRookY2: Boolean = (kingY == rookY2)
    return when {
        (attackRookX1 || attackRookY1) && (attackRookX2 || attackRookY2) -> 3
        attackRookX2 || attackRookY2 -> 2
        attackRookX1 || attackRookY1 -> 1
        else -> 0
    }
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    val attackRookX: Boolean = (kingX == rookX)
    val attackRookY: Boolean = (kingY == rookY)
    val attackBishop: Boolean = (Math.abs(kingX - bishopX) == Math.abs(kingY - bishopY))
    return when {
        (attackRookX || attackRookY) && attackBishop -> 3
        attackRookX || attackRookY -> 1
        attackBishop -> 2
        else -> 0
    }
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    val m = Math.max(a, Math.max(c, b))
    var n = b
    var k = a
    when (m) {
        a -> {n = c; k = b}
        c -> {n = a; k = b}
        b -> {n = c; k = a}
    }
    return when {
        ((sqr(a) < (sqr(b) + sqr(c))) && (sqr(c) < (sqr(a) + sqr(b))) && ((sqr(b) < (sqr(a) + sqr(c))))) -> 0
        sqr(m) == sqr(n) + sqr(k) -> 1
        m > n + k -> -1
        else -> 2
    }
}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int =
        when {
            a > c -> when {
                a > d -> -1
                b < d -> b - a
                else -> d - a
            }
            else -> when {
                b < c -> -1
                b > d -> d - c
                else -> b - c
            }
        }







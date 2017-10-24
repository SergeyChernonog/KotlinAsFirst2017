@file:Suppress("UNUSED_PARAMETER")

package lesson4.task1

import lesson1.task1.discriminant

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = Math.sqrt(v.map { it * it }.sum())


/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    return if (list.isNotEmpty()) list.sum() / list.size
    else 0.0
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val centerMean = mean(list)
    for (i in 0 until list.size)
        list[i] -= centerMean
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var sum = 0.0
    for (i in 0 until a.size)
        sum += a[i] * b[i]
    return sum
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var sum = 0.0
    var base = 1.0
    for (elem in p) {
        sum += elem * base
        base *= x
    }
    return sum
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    for (i in 1 until list.size)
        list[i] += list[i - 1]
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var number = n
    var divisor = 2
    val divided = mutableListOf<Int>()
    while (number > 1) {
        if (number % divisor == 0) {
            divided += divisor
            number /= divisor
        } else divisor++
    }
    return divided
}


/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    val baseNumber = mutableListOf<Int>()
    var number = n
    if (number == 0) return listOf(0)
    while (number > 0) {
        baseNumber += number % base
        number /= base
    }

    return baseNumber.reversed()
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    var result = ""
    var number = n
    if (number == 0) result += '0'
    while (number > 0) {
        val digit = number % base
        result += if (digit > 9) ('a' + digit - 10)
        else digit.toString()
        number /= base
    }
    return result.reversed()
}


/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    val decDigits = mutableListOf<Int>()
    var basePow = 1
    for (i in digits.size - 1 downTo 0) {
        decDigits.add(digits[i] * basePow)
        basePow *= base
    }
    return decDigits.sum()
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    var result = 0
    var partInDecimal: Int
    var basePow = 1

    for (i in str.length - 1 downTo 0) {
        val digit = str[i]
        partInDecimal = when (digit) {
            in '0'..'9' -> digit - '0'
            else -> digit - 'a' + 10
        }
        result += partInDecimal * basePow
        basePow *= base
    }

    return result
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */


fun roman(n: Int): String = TODO()


/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var result = ""
    val hundredsOfThousands = n / 100000
    val dozensOfThousands = (n / 10000) % 10
    val thousands = (n / 1000) % 10
    val hundreds = (n / 100) % 10
    val dozens = (n / 10) % 10
    val units = n % 10
    result += russianConvert(hundredsOfThousands, dozensOfThousands, thousands)
    if (n / 1000 > 0) {
        result += if ((dozensOfThousands != 1) && (thousands < 5) && (thousands > 0))
            when (thousands) {
                1 -> "тысяча "
                else -> "тысячи "
            }
        else "тысяч "
    }

    result += if ((units > 2) || (units == 0) || (dozens == 1)) russianConvert(hundreds, dozens, units)
    else {
        if (units == 2) russianConvert(hundreds, dozens, 0) + "два"
        else russianConvert(hundreds, dozens, 0) + "один"
    }
    result = result.trim()
    return result


}

fun russianConvert(n: Int, m: Int, k: Int): String {
    var result = ""
    result += when (n) {
        9 -> "девятьсот "
        8 -> "восемьсот "
        7 -> "семьсот "
        6 -> "шестьсот "
        5 -> "пятьсот "
        4 -> "четыреста "
        3 -> "триста "
        2 -> "двести "
        1 -> "сто "
        else -> ""
    }
    result += when (m) {
        9 -> "девяносто "
        8 -> "восемьдесят "
        7 -> "семьдесят "
        6 -> "шестьдесят "
        5 -> "пятьдесят "
        4 -> "сорок "
        3 -> "тридцать "
        2 -> "двадцать "
        1 -> when (k) {
            9 -> "девятнадцать "
            8 -> "восемнадцать "
            7 -> "семнадцать "
            6 -> "шестнадцать "
            5 -> "пятнадцать "
            4 -> "четырнадцать "
            3 -> "тринадцать "
            2 -> "двенадцать "
            1 -> "одиннадцать "
            else -> "десять "
        }
        else -> ""
    }
    if (m != 1) {
        result += when (k) {
            9 -> "девять "
            8 -> "восемь "
            7 -> "семь "
            6 -> "шесть "
            5 -> "пять "
            4 -> "четыре "
            3 -> "три "
            2 -> "две "
            1 -> "одна "
            else -> ""
        }
    }
    return result
}
fun numbersToRussianNumerals (n: Int, m: Int, k: Int): String {
    val russianHundreds = listOf("", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот",
            "восемьсот", "девятьсот")
    val russianDozens = listOf("", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят",
            "восемьдесят", "девяносто")
    val russianDec = listOf("десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать"
            , "восемнадцать", "девятнадцать")
    val russianUnits = listOf("", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одна", "две" )
    val hundreds = russianHundreds[n]
    
}
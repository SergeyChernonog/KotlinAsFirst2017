@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1



/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {

return(
    when {
        n/10==0 -> 1
        else-> 1+ digitNumber(n/10)
    })
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int = when (n){
    1  -> 1
    2  -> 1
    else -> fib(n-2)+fib(n-1)
}



/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var i: Int = m
    if (n > m) i = n
    while ((i % m != 0) ||(i % n != 0)) i += 1
    return i


}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    for (i in 2..n) {
        if (n % i == 0) return i

    }
    return 0
}
/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var i: Int = n/2
    while (n % i != 0) {
        i -= 1

    }
    return i
}
/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var k: Int=Math.abs(m)
    var r: Int= Math.abs(n)
    while (k != r) {
        if ( k > r) k -= r
        else r -= k
    }
    return r == 1
 }





/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    val k: Int = Math.sqrt(n.toDouble()).toInt()
    val r: Int = Math.sqrt(m.toDouble()).toInt()
    for (i in m..n) {
        for (l in r..k)
            if (i==l*l) return true

    }
    return false
}




/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    var l: Double = x
     while (l > 2 * Math.PI)
         l-= 2 * Math.PI
    var sinX: Double = 0.0
    var n: Int = 1
    var k: Double = 0.0
    var part: Double = l
    while (part>eps){
        sinX += part * Math.pow(-1.0, k)
        n += 2
        k += 1.0
        part= Math.pow(l, n.toDouble()) / factorial(n)

    }
    return sinX

}
/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    var l: Double = x
    while (l > 2 * Math.PI)
        l -= 2 * Math.PI
    var cosX: Double = 0.0
    var n: Int = 0
    var k: Double = 0.0
    var part: Double = 1.0
    while (part > eps) {
        cosX += part * Math.pow(-1.0, k)
        n += 2
        k += 1.0
        part = Math.pow(l, n.toDouble()) / factorial(n)

    }
    return cosX
}
/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var k: Int = n
    var f: Int = 0
    while (k > 0) {
        f = f * 10 + k % 10
        k /= 10
    }
    return f
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean =
    revert(n) == n


/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean =
        when {
            n / 10 == 0 -> false
            (n / 10) % 10==n % 10 -> hasDifferentDigits(n / 10)
            else -> true
        }
/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
   var k: Int = n
   var i: Int = 0
    var  last:Int = 0
   while (k>0) {
       i += 1
       last= i * i
       k -= digitNumber(last)

   }

    k*=-1
    val divisor: Int = Math.pow(10.0, (k.toDouble())).toInt()
    return if (k == 0) last % 10
        else (last/divisor)%10
}
/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var k: Int= n
    var i: Int= 0
    var  last:Int = 0
    while (k>0) {
        i += 1
        last= fib(i)
        k -= digitNumber(last)

    }
    k*=-1
    val divisor: Int = Math.pow(10.0, (k.toDouble())).toInt()
    return if (k == 0) last % 10
        else (last/divisor)%10
}

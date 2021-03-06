@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

import java.lang.Math.*

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
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
        if (n == m) 1 else if (n < 10) 0
        else digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var amount = 0
    var newn = n
    if (n <= 9) return 1
    while ((newn / 10) > 0)  {
        newn /= 10
        amount ++
    }
    return (amount + 1)
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    //-fib(n) = -fib(n+2) + fib(n+1)
    //fib(n) = fib(n+2) - fib(n+1)
    if (n == 1) return 1
    if (n == 2) return 1
    if (n == 3) return 2
    var result = 0
    if (n > 1) {
        result = fib(n - 2) + fib(n - 1)
    }
    return result
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var bar = (m * n)
    var foo = (min(m, n))
    var k = 0
    for (i in foo..bar step foo) {
        if ((i % m) + (i % n) == 0) {
            k = i
            break
        }
    }
    return k
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var result = 2
    for (i in 2..n) {
        if ((n % i) == 0) {
            result = i
            break
        }
    }
    return result
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var result = 2
    for (i in (n - 1) downTo 1) {
        if ((n % i) == 0) {
            result = i
            break
        }
    }
    return result
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    for (i in 2..(max(m, n))) {
        if ((m % i) + (n % i) == 0) {
            return false
        }
    }
    return true
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean = TODO()

/**
 * Простая
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Простая
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var result = 0.0
    var count = 0
    var N1 = n
    var N2 = n
    while (N1 > 0) {
        N1 /= 10
        count ++
    }
    while (N2 > 0) {
        result += (N2 % 10 * pow(10.0, count.toDouble()))
        N2 /= 10
        count --
    }
    return result.toInt() / 10
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    var result = 0.0
    var count = 0
    var N1 = n
    var N2 = n
    while (N1 > 0) {
        N1 /= 10
        count ++
    }
    while (N2 > 0) {
        result += (N2 % 10 * pow(10.0, count.toDouble()))
        N2 /= 10
        count --
    }
    return (result.toInt() / 10) == n
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var count = 0
    var N1 = n
    var N2 = n
    var lastDigit = (n % 10)
    while (N1 > 0) {
        N1 /= 10
        count ++
    }
    while (N2 > 0) {
        if (lastDigit == (N2 % 10)) {
            N2 /= 10
        } else return true
    }
    return false
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144169...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun rmLastStringElement(n: String): String {
    return n.substring(0, (n.length - 1))
}

fun printLastStringElement(n: String): String {
    return n.substring((n.length - 1), n.length)
}

fun revertString(n:String): String {
    var count = n.length
    var N = n
    var result = ""
    while (count > 0) {
        result += printLastStringElement(N)
        N = rmLastStringElement(N)
        count --
    }
    return result
}

fun squareSequenceDigit(n: Int): Int {
    /*
    var counter = 0
    var result = ""
    var checkIfFirstForThisi = 0
    for (i in 1..n) {
        checkIfFirstForThisi = 0
        var sqri = (i * i).toString()
        do {
            if (checkIfFirstForThisi == 0) {
                result = printLastStringElement(revertString(sqri))
                sqri = rmLastStringElement(revertString(sqri))
            } else {
                result = printLastStringElement(sqri)
                sqri = rmLastStringElement(sqri)
            }
            counter ++
            checkIfFirstForThisi ++
            if (counter == n) return result.toInt()
        } while (sqri != "")
        if (counter == n) return result.toInt()
    }
    return result.toInt()
    */
    //^^This works but I realized I made it backwards, it could be shorter.^^
    var sqri = ""
    var result = ""
    var counter = 0
    for (i in 1..n) {
        var sqri = (i * i).toString()
        while (sqri != "") {
            result = printFirstStringElement(sqri)
            sqri = rmFirstStringElement(sqri)
            counter ++
            if (counter == n) return result.toInt()
        }
    }
    return 418
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun rmFirstStringElement(n: String): String {
    return n.substring(1, n.length)
}

fun printFirstStringElement(n: String): String {
    return n.substring(0, 1)
}

fun fibSequenceDigit(n: Int): Int {
    var log = ""
    var result = ""
    var counter = 0
    for (i in 1..n) {
        log += fib(i).toString()
    }
    while (counter < n) {
        result = printFirstStringElement(log)
        log = rmFirstStringElement(log)
        counter ++
    }
    return result.toInt()
}

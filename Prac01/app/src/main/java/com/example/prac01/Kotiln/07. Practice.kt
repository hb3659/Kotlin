package com.example.prac01.Kotiln

fun main(array: Array<String>) {

    // 산술 연산
    var a = 10 + 1
    var b = 10 - 1
    var c = 1 * 9
    var d = 20 / 3
    var e = 20 % 3

    println(a)
    println(b)
    println(c)
    println(d)
    println(e)

    //대입 연산
    val f = 5
    //val 5 = f

    //복합 대입 연산
    a += 10
    b -= 10
    c *= 3
    d /= 4
    e %= 2

    println()
    println(a)
    println(b)
    println(c)
    println(d)
    println(e)

    //증감 연산
    a++
    b--
    println()
    println(a)
    println(b)

    //비교 연산
    var g = a > b
    var h = a == b
    var i =  h != g
    println()
    println(g)
    println(h)
    println(i)

    //논리 연산
    val j = h && i
    val k = h || i
    val l = !j
    println()
    println(j)
    println(k)
    println(l)
}
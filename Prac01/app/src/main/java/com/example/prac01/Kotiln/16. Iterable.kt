package com.example.prac01.Kotiln

// 16.Iterable ===> 반복할 수 있는

fun main(array: Array<String>) {

    val a = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // 반복하는 방법 (1)
    for (item in a) {
        if (item == 5) {
            println("item is Five")
        } else {
            println("item is not Five")
        }
    }
    println()

    // 반복하는 방법 (2)
    // 인덱스를 알고 싶을 때
    for ((index, item) in a.withIndex()) {
        println("index: " + index + " value: " + item)
        // 문자열 + Int = 문자열
        // 문자열 + 아무거나 = 문자열
    }
    println()

    // 반복하는 방법 (3)
    // Lambda 문법
    // 변수 이름은 무조건 it
    a.forEach {
        println(it)
    }
    println()

    // 반복하는 방법 (4)
    // 변수 이름 변경 방법
    a.forEach { item ->
        println(item)
    }
    println()

    // 반복하는 방법 (5)
    a.forEachIndexed { index, item ->
        println("index: " + index + " value: " + item)
    }
    println()

    // 반복하는 방법 (6)
    println(a.size)
    println()
    for (i in 0 until a.size) {
        // until은 마지막을 포함하지 않는다.
        // 0부터 8까지
        println(a.get(i))
    }
    println()

    // 반복하는 방법 (7)
    // 2칸씩 건너 뛰면서 출력
    for (i in 0 until a.size step (2)) {
        println(a.get(i))
    }
    println()

    // 반복하는 방법 (8)
    // 0까지 역으로 출력
    for (i in a.size - 1 downTo (0)) {
        // 8부터 0까지 반복
        println(a.get(i))
    }
    println()

    // 반복하는 방법 (9)
    // 0까지 역으로 2칸씩 건너뛰며 출력
    for (i in a.size - 1 downTo (0) step (2)) {
        println(a.get(i))
    }
    println()

    // 반복하는 방법 (10)
    // ..은 마지막을 포함해서 출력
    for (i in 0..a.size) {
        println(i)
    }
    println()

    // 반복하는 방법 (11)
    var b: Int = 0
    var c: Int = 4

    while (b < c) {
        b++
        println("b")
    }
    println()

    // 반복하는 방법 (12)
    // while 의 조건을 만족하지 않아도
    // do 안의 코드를 무조건 한번은 실행
    var d:Int = 0
    var e:Int = 4

    do {
        println("hello")
        d++
    } while (d < e)

}
package com.example.prac01.Kotiln

fun main(array: Array<String>) {
    val array = arrayOf<Int>(1, 2, 3)

    val number = array.get(0)
    println(number)
    // val number1 = array.get(100) // 인덱스에 주의하자

    array.set(0, 100)
    val number2 = array.get(0)
    println(number2)

    // array.set(100, 100)

    // Array의 Bounds
    // 처음 만들 때 결정된다(수정이 힘듦)

    // Array를 만드는 방법(3)
    val a1 = intArrayOf(1,2,3)
    val a2 = charArrayOf('b', 'c') // char -> '' string -> ""
    val a3 = doubleArrayOf(1.2,100.23)
    val a4 = booleanArrayOf(true, false, false)

    // Array를 만드는 방법(4) -> lambda 를 활용한 방법
    var a5 = Array(10, {0})
    // ==> 배열에 0만 들어감
    var a6 = Array(5, {1;2;3;4;5})
}
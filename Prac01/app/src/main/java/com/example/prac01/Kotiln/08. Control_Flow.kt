package com.example.prac01.Kotiln

// 08. 제어 흐름
/*
    if / else

 */
fun main(array: Array<String>) {

    val a: Int = 5
    val b: Int = 10

    // if 사용법(1)
    if (a > b) {
        println("a가 b보다 크다")
    } else {
        println("a가 b보다 작다")
    }

    // if 사용법(2)
    if (a > b) {
        println("a가 b보다 크다")
    }

    // if 사용법(3)
    if (a > b) {
        println("a가 b보다 크다")
    } else if (a < b) {
        println("a가 b보다 작다")
    } else if (a == b) {
        println("a와 b가 같다")
    } else {

    }

    // if 사용법(4)
    val max = if (a > b) {
        a
    } else {
        b
    }
    println()
    println(max)
}
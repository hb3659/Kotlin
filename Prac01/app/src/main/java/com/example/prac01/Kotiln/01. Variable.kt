package com.example.prac01.Kotiln

// 01. 변수

/*
    변수 선언 방법
        var / val 변수명 = 값

        Variable / Value
        Variable = 값 변경 가능
        Value = 값 변경 불가능
*/

var num = 10
var hello = "hello"
var point = 3.4

val fix = 20

fun main(args: Array<String>) {
    println(num)
    println(hello)
    println(point)
    println(fix)

    num = 100
    hello = "Good Bye"
    point = 10.4

    println(num)
    println(hello)
    println(point)
    println(fix)

}
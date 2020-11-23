package com.example.prac01.Kotiln

var a = 1 + 2 + 3 + 4 + 5 // 연산의 결과값을 변수에 넣어 줄 수 있다.
var b = "1"
var c = b.toInt()
var d = b.toFloat()

var e = "John"
var f = "My name is $e Nice to meet you"

// Null
/*
    존재하지 않는다
    자료형 뒤에 ?를 붙이면 null을 받을 수 있는 변수가 된다.
    null은 문자열이 아니다!!
 */

//var abc:Int = null
var abc: Int? = null
var abc1: Double? = null

var g = a + 3

fun main(args: Array<String>) {
    println(a)
    println(b)
    println(c)
    println(d)
    println(e)
    println(f)
    println(abc1)
    println(g)
}
package com.example.prac01.Kotiln

// 02. 자료형
/*
    정수형 -> Long > Int > Short > Byte
    실수형 -> Double > Float
    문자 -> Char
    문자열 -> String
    논리형(True/False) -> Boolean

    자료형이 정해진 변수에는 정해진 자료형의 값만
    들어갈 수 있다.

    웬만하면 자료형을 적어서 변수를 생성하자

    변수 선언 방법(2)
    var/val 변수 : 자료형 = 값

    Variable or Value?
     - 변하지 않는 값이라면 Value
     - 정말 모르겠다면 Value ==> 선언 이후 사용 시점에서 값의 변경이 있는지
     확인하기 어렵기 때문에
*/

var number = 10

var number1: Int = 20
var hello1: String = "hello"
var point1: Double = 3.4

// 자료형 생략가능

/* 자료형을 생략하면 코틀린에서 스스로 판단하여
 변수의 자료형을 정한다. */

fun main(args: Array<String>) {
    number = 20
    //number = 10.5
}
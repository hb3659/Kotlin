package com.example.prac01.Kotiln

//11. 제어 흐름 실습

fun main(array: Array<String>) {
    val value: Int? = null

    when (value) {
        null -> println("value is null")
        else -> println("value is not null")
    }

    val value2: Boolean? = null

    //when 구문은 조건으로 갖는 값의 모든 경우에
    //대응 해주는 것이 좋다
    when (value2) {
        true -> println("")
        false -> println("")
        null -> println("")
    }

    //값을 리턴하는 when 구문의 경우 반드시 값을
    //리턴해야 한다
    val value3 = when (value2) {
        true -> 1
        false -> 3
        null -> 4
    }

    // when의 다양한 조건식(1)
    val value4: Int = 10
    when (value4){
        is Int -> println("value4 is int")
        else -> println("value4 is not int")
    }

    // when의 다양한 조건식(2)
    val value5:Int = 70
    when(value5){
        in 60..70 -> println("value is in 60..70")
        in 70..80 -> println("value is in 70..80")
        in 80..90 -> println("value is in 80..90")
    }
}
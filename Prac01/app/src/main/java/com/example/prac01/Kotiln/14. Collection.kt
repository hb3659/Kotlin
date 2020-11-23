package com.example.prac01.Kotiln

// 14. Collection
/*
    list, set, map ===> 값을 변경할 수 없다 (Immutable Collection)

    mutableList, mutableSet, mutableMap
    ===> 값을 변경할 수 있다(Mutable Collection)

 */

fun main(array: Array<String>){

    // List ==> 동일한 값을 허용한다.
    val numberList = listOf<Int>(1,2,3,3)
    println(numberList)
    println(numberList.get(0))
    println(numberList[0])

    // Set ==> 동일한 값(중복)을 허용하지 않는다.
    // 순서가 없다!!
    val numberSet = setOf<Int>(1,2,3,3,3)
    println()
    numberSet.forEach {
        println(it)
    }

    // Map ==> Key, value 방식으로 관리한다.
    val numberMap = mapOf<String, Int>("one" to 1, "two" to 2)
    println()
    println(numberMap.get("one"))

    val mNumberList = mutableListOf<Int>(1,2,3)
    mNumberList.add(3,4)
    println()
    println(mNumberList)

    val mNumberSet = mutableSetOf<Int>(1,2,3,4,4,4,4)
    mNumberSet.add(10)
    println(mNumberSet)

    val mNumberMap = mutableMapOf<String, Int>("one" to 1)
    mNumberMap.put("two", 2)
    println(numberMap)
}
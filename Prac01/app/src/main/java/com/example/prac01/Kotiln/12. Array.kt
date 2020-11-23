package com.example.prac01.Kotiln

// 12. 배열

/*
    배열이 필요한 이유
    --그룹(모음집)이 필요할 때
 */

fun main(array: Array<String>) {

    // 배열 생성 방법(1)
    val group1 = arrayOf<Int>(1, 2, 3, 4, 5)
    println(group1 is Array)

    // 배열 생성 방법(2)
    // 자료형을 정해주지 않으면 자료형 상관없이 다 입력 가능
    val group2 = arrayOf(1, 2, 3.5, 4, "Hello")

    /*
        index?
            순서(번째)
            [1,2,3,4,5]
            0부터 시작
            index 0 -> 1, index 1 -> 2
     */

    // 배열의 값을 꺼내는 방법(1)
    val test1 = group1.get(0)
    val test2 = group1.get(4)
    println(test1)
    println(test2)

    // 배열의 값을 꺼내는 방법(2)
    val test3 = group1[0]
    println(test3)

    // 배열의 값을 바꾸는 방법(1)
    group1.set(0,100)
    println(group1[0])

    // 배열의 값을 바꾸는 방법
    group1[0] = 200
    println(group1[0])
}
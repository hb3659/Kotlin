package com.example.prac01.Kotiln


// 변수의 접근 범위
// 1. 전역 변수
// 2. 지역 변수

var number10: Int = 10

fun main(array: Array<String>) {
    println(number10)

    val test: Test = Test("길동")
    test.testFun()
    test.Name
    println(number10)
}

class Test(var Name: String) {
    // 클래스 안에서만 접근할 수 있는 변수
    fun testFun() {
        // 함수 안에서만 접근할 수 있는 변수
        var birth: String = "2000/01/01"
        Name = "홍길동"
        number10 = 100
        // gender 변수에 접근 불가
        fun testFun3() {
            var gender: String = "male"
        }
    }

    fun testFun2() {
        Name
        // birth 변수는 사용 불가
    }
}
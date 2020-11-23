package com.example.prac01.Kotiln

// 인터페이스
// - 인터페이스도 구현이 있는 함수를 만들 수 있다
// - 인터페이스에 구현이 있는 함수는 그 인터페이스를 구현하는
// 클래스에서 그 함수를 구현할 필요가 없다
// 인터페이스에 구현이 없는 함수는 그 인터페이스를
// 구현하는 클래스에서 반드시 구현해야 한다

fun main(args:Array<String>){
    val student:Student__ = Student__()
    student.sleep()
}


interface Person__ {
    fun eat(){
        println("먹는다")
    }
    abstract fun sleep()

    abstract fun study()     // --> eat 과 sleep 처럼 구현할 수 없다
    // (각 클래스에서 내용이 매우 다르기 때문)
    // abstract ==> 이 클래스는 이 인터페이스를
    // 구현하는 클래스에서 반드시 해야한다
    // --> 반드시 구현해야 한다(클래스에서!!)
}

class Student__ : Person__ {
    override fun study() {

    }

    override fun sleep() {

    }
}

class Teacher__ : Person__ {
    override fun study() {

    }

    override fun sleep() {

    }
}
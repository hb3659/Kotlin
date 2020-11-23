package com.example.prac01.Kotiln

import androidx.collection.SparseArrayCompat

// 27. Interface
// 인터페이스 == 약속!! ==> 니가 이것을 구현한다면 너도 이 타입이다!!
// 인터페이스를 구현하는 클래스는 반드시
// 인터페이스의 기능을 구현해야 한다
// (기능 설명을 해야한다)
// --> 생성자가 없다 -> 인스턴스화 시킬 수 없다 -> 설명서가 아니다!!
// --> 지침서 -> 이것을 구현하고 싶다면 반드시 아래 기능을 구현해라!!

// 상속이 만들어낸 특징
// 자식 클래스는 부모 클래스의 타입(자료형)이다
// 반대로는 성립이 안된다(부모 클래스는 자식 클래스의 타입은 아니다!!!)

// 상속 = 조상을 찾아가는 느낌
// 인터페이스 = 종의 특징

fun main(args:Array<String>){
    val student_:Student_ = Student_()
    student_.eat()
    student_.sleep()


}

interface Person_ {
    fun eat()
    fun sleep()
}

class Student_ : Person_ {
    override fun eat() {

    }

    override fun sleep() {

    }
}

class SoccerPlayer : Person_ {
    override fun eat() {

    }

    override fun sleep() {

    }
}


open class Person() {
    open fun eat() {

    }

    fun sleep() {

    }
}

class Student() : Person() {
    override fun eat() {
        super.eat()
    }
}

class Teacher() : Person() {

}
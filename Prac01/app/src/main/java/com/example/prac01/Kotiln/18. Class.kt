package com.example.prac01.Kotiln

//18. Class
/*
    OOP ==> Object Oriented Programming (객체지향 프로그래밍)

    "객체"란 무엇인가?
    ==> 이름이 있는 모든 것

    절차지향 프로그래밍의 문제해결 방법
    ==> 코드를 위에서부터 아래로 실행하면 문제가 해결된다

    객체지향 프로그래밍의 문제해결 방법
    ==> 객체를 생성해, 객체에게 일을 시켜 문제를 해결한다.
    축구게임 -> 선수, 심판, 경기장, 관중

    문제를 해결하기 위해 필요한 역할을 할 수 있는 객체를 만들어
    그 객체들에게 일을 시켜 문제를 해결한다.

    객체를 만드는 방법
    - 설명서 필수

 */

// 클래스(설명서) 만드는 방법 (1)
class Car(var engine: String, var body: String) {

}

// 클래스 만드는 방법 (2)
class SuperCar {   // 클래스 이름 생성
    var engine: String      // 설명서의 필요부품
    var body: String
    var door: String

    constructor(engine: String, body: String, door: String) {  // 클래스를 생성하는 방법(주문 방법)
        this.engine = engine
        this.body = body
        this.door = door
        // this == 설명서의 부품!!
    }

}

// 클래스 만드는 방법 (3) -> 1번 방법의 확장
// 차를 만드는 데 필요한 것은 엔진과 바디이지만
// 만약 문이 추가로 들어왔을 때 constructor의 내용으로 제작한다

// 엔진과 바디만 들오왔다면 this(engine, body)에 넘겨준다
// (Car1 의 engine 과 body 를 이용하기 위해!!)
class Car1(engine: String, body: String) {  // (engine~String)은 생성자!!!
    var door: String = ""

    // 클래스를 생성하는 방법을 적어놓은 것 == 생성자
    //
    constructor(engine: String, body: String, door: String) : this(engine, body) {
        this.door = door
    }   // constructor == 생성자!!!
    // 따라서 위의 (engine~String) 앞에 constructor 를 적거나 빼도 무방하다
}

// 클래스 만드는 방법 (4) -> 2번의 확장
class Car2 {
    var engine: String = ""      // 기본값을 넣어주도록 하자
    var body: String = ""
    var door: String = ""

    constructor(engine: String, body: String) {      // 위에서 선언한 변수에 주문 내용을 넣는다
        this.engine = engine
        this.body = body
    }

    constructor(engine: String, body: String, door: String) {       // 2안
        this.engine = engine
        this.body = body
        this.door = door
    }
}


// Practice
class Book {
    var title: String
    var menu: String
    var genre: String

    constructor(title: String, menu: String, genre: String) {
        this.title = title
        this.menu = menu
        this.genre = genre

        println(title)
        println(menu)
        println(genre)
    }
}

class Book1(var title: String, var genre: String) {

}


class RunnableCar(engine: String, body: String) {       //()안을 생략해도 무관!!!

    fun ride() {
        println("탑승 하였습니다")
    }

    fun drive() {
        println("달립니다!")
    }

    fun navi(destination: String) {
        println("$destination 으로 목적지가 설정되었습니다")
    }

}

class RunnableCar2 {
    var engine: String = ""
    var body: String = ""

    constructor(engine: String, body: String) {
        this.engine = engine    // 멤버 변수
        this.body = body
    }

    init {
        // 인스턴스화될 때 이 부분이 무조건 가장 먼저 호출된다
        // 초기 설정을 할 때 유용하다
        println("Runnable2가 만들어 졌습니다")
    }

    fun ride() {
        println("탑승 하였습니다")
    }

    fun drive() {
        println("달립니다!")
    }

    fun navi(destination: String) {
        println("$destination 으로 목적지가 설정되었습니다")
    }
}





//오버로딩
class TestClass() {
    // 함수의 이름이 동일할 때 처리하는 방법
    // 함수가 받는 인자(파라미터)가 다르다면 동일한 이름의 함수를 만들 수 있다
    // ===> 이름이 같지만 받는 파라미터가 다른 함수
    fun test(a:Int) {
        println("up")
    }

    fun test(a:Int, b:Int) {
        println("down")
    }
}


fun main(array: Array<String>) {
    // 설명서를 통해 실체를 만드는 방법 ==> 인스턴스
    // 인스턴스를 만드는 과정 ==> 인스턴스화
    // 인스턴스화 -> 인스턴스(객체)
    Car("v8 engine", "big")

    val bigCar = Car("v8 engine", "big")

    //우리가 만든 클래스는 자료형이 될 수 있다
    val bigCar1: Car = Car("v8 engine", "big")

    var superCar: SuperCar = SuperCar("good engine", "big", "white")
    // 호출 시 constructor 에서 호출된다

    // Practice
    //var Novel: Book = Book("Playing Game", "first", "comics")

    var Book: Book1 = Book1("Watering", "Suspense")
    Book.genre
    Book.title

    // 인스턴스가 가지고 있는 기능을 사용하는 방법
    val runnableCar: RunnableCar = RunnableCar("simple engine", "short body")
    runnableCar.ride()
    runnableCar.drive()
    runnableCar.navi("부산")

    // 인스턴스의 멤버 변수에 접근하는 방법 ===> 클래스의 요소에 접근하는 방법
    var runnableCar2: RunnableCar2 = RunnableCar2("nice engine", "long body")
    println(runnableCar2.body)
    println(runnableCar2.engine)
    println()

    val testClass = TestClass()
    testClass.test(1)
    testClass.test(1,2)

}


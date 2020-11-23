package com.example.prac01.Kotiln

// 23. 접근 제어자
// private ==> 외부에서 접근불가


fun main(args: Array<String>) {
    val testAccess: TestAccess = TestAccess("AAA")
//    testAccess.test()
//    println(testAccess.name)
//    testAccess.name = "BBB"
//    println(testAccess.name)

    val reward:Reward = Reward()
    reward.rewardAmount = 2000

    var runningCar :Running = Running()
    runningCar.runFast()
//    runningCar.run()
}

class Reward() {
    var rewardAmount: Int = 1000
}

class TestAccess {
    private var name: String = "길동"

    constructor(name: String) {
        this.name = name
    }

    fun changeName(newName:String){
        this.name = newName
    }

    private fun test() {
        println("테스트")
    }
}

class Running(){
    fun runFast(){
        run()
    }
    private fun run(){

    }
}

// 어떤 기능을 작동시키기 위해 다른 기능의 함수가 필요할 수 있다
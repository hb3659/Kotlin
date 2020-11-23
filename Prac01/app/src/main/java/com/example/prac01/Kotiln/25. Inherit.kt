package com.example.prac01.Kotiln


// 두번까진 봐준다
// 두번 이상이 넘어가면 리펙토링(정리정돈) 해라


// 25. 상속
// 부모로부터 설명서를 물려받는다!


fun main(array: Array<String>) {
    val supercar :SuperCar100 = SuperCar100()
    println(supercar.drive())
    supercar.stop()

    val truck:Truck100 = Truck100()
    //truck.drive()
    //truck.stop()
}


// 부모 : Car100
// 자식 : SuperCar100, Truck100
open class Car100() {
    open fun drive():String {
        return "달린다"
//        println("달린다")
    }

    fun stop() {

    }
}

class SuperCar100() : Car100() {
    override fun drive():String {
        val run = super.drive()
        return "빨리 $run"
    }
}

class Truck100() :Car100() {

}
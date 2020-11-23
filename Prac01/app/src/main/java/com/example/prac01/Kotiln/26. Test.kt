package com.example.prac01.Kotiln


fun main(array: Array<String>) {
    val monster: SuperMonster = SuperMonster(100, 10)
    val knight: SuperKnight = SuperKnight(130, 8)
    monster.Attack(knight)
    monster.Bite(knight)
}

// 상속이 만들어낸 특징
// 자식 클래스는 부모 클래스의 타입(자료형)이다
// 반대로는 성립이 안된다(부모 클래스는 자식 클래스의 타입은 아니다!!!)
// 슈퍼카 == 자동차(O) , 자동차 == 슈퍼카(X)

open class Charactor(var hp: Int, var power: Int) {
    fun Attack(charactor: Charactor, power: Int = this.power) {
        charactor.Defense(power)
    }

    open fun Defense(damage: Int) {
        hp -= damage
        if (hp > 0) println("${javaClass.simpleName}의 남은 체력은 $hp 입니다")
        else println("사망 했습니다")
    }
}

// 자식 클래스가 인스턴스화 되기 위해서는 부모 클래스가 선행되어 인스턴스화 되어야한다
// ==> 자동차를 만들어야 스포츠카를 만들 수 있다!!!
// 자식 클래스 생성시 부모와 파라미터의 값이 동일해야 하며, var, val 키워드를 적지 않는다
// 하지만 부모 클래스 생성시 적지 않았던 파라미터 값을 추가한다면 키워드르 적어준다(적지 않아도 무방)
class SuperMonster(hp: Int, power: Int) : Charactor(hp, power) {
    fun Bite(charactor: Charactor) {
        super.Attack(charactor, power + 2)
    }
}

class SuperKnight(hp: Int, power: Int) : Charactor(hp, power) {
    val DefensePower = 2
    override fun Defense(damage: Int) {
        super.Defense(damage-DefensePower)
    }
}
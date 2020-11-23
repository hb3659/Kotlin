package com.example.prac01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.createObject
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Realm.init(this)
        val config:RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            // 테이블의 필드 추가 시 기존 데이터는 모두 삭제한다는 옵션
            .build()

        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()
        //-------Realm 준비-----------

        save_Btn.setOnClickListener {
            realm.executeTransaction{
                // a 테이블에서 데이터를 가져온다
                // b 테이블에서 데이터를 가져온다
                // c 테이블에서 데이터를 가져온다
                // 조합한다
                // d 테이블에 저장한다
                with(it.createObject(School::class.java)){
                    this.name = "대학교"
                    this.location = "서울"
                }
            }
        }

        load_Btn.setOnClickListener {
            realm.executeTransaction{
                val data = it.where(School::class.java).findFirst()
                Log.d("dataa : ", "data : "+data)
            }
        }

        delete_Btn.setOnClickListener {
            realm.executeTransaction{
                it.where(School::class.java).findAll().deleteAllFromRealm()
            }
        }
    }
}

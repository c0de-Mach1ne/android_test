package com.sirius.test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sirius.test_app.uiFragment.GameDescriptionFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, GameDescriptionFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
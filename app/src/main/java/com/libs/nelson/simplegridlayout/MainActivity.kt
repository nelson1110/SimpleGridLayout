package com.libs.nelson.simplegridlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val list: ArrayList<String> = ArrayList()
        for (i in 1..16) {
            list.add("adsfadsf")
        }

        val adapter = SimpleGridLayoutAdapter(list)
        grid.setAdapter(adapter)
    }
}

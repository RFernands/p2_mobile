package com.example.rebecca.p2_mobile.cenarios

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.rebecca.p2_mobile.R
import com.example.rebecca.p2_mobile.entidades.Drink
import kotlinx.android.synthetic.main.activity_lista_drinks.*

class ListaDrinks : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_drinks)
    }

    fun exibeLista(list: List<Drink>) {

        val adapter = ListaDrinksAdapter(this, list)
        rvDrinks.adapter = adapter
        rvDrinks.layoutManager = LinearLayoutManager(this)
    }
}

package com.example.rebecca.p2_mobile.cenarios


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.rebecca.p2_mobile.R
import com.example.rebecca.p2_mobile.entidades.Drink
import kotlinx.android.synthetic.main.activity_lista_drinks.*

class ListaDrinks : AppCompatActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_drinks)

        val presenter : MainContract.Presenter = MainPresenter(this)
        presenter.onLoadList()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
    override fun showList(drinks: List<Drink>) {

        val adapter = ListaDrinksAdapter(this, drinks)
        rvDrinks.adapter = adapter
        rvDrinks.layoutManager = LinearLayoutManager(this)
    }
}

package com.example.rebecca.p2_mobile.cenarios


import android.content.Intent
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

        val recebeIntent = getIntent()
        val drink = recebeIntent.getIntExtra("drink", -1)



        val presenter : MainContract.Presenter = MainPresenter(this)
        presenter.onLoadList()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
   /* override fun showList(drinks: List<Drink>) {

        val adapter = ListaDrinksAdapter(this, drinks)
        rvDrinks.adapter = adapter
        rvDrinks.layoutManager = LinearLayoutManager(this)
    }*/
   override fun showList(drinks: List<Drink>) {

       val adapter = ListaDrinksAdapter(this, drinks)
       adapter.setOnItemClickListener { position ->

           val dados = Bundle()

           dados.putSerializable("object", drinks.get(position))

           val mostraNaTela = Intent(this, DetailDrink::class.java)
           mostraNaTela.putExtras(dados)
           startActivity(mostraNaTela)
       }

       rvDrinks.adapter = adapter
       rvDrinks.layoutManager = LinearLayoutManager(this)

       //rvDrinks.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
   }

}
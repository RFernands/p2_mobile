package com.example.rebecca.p2_mobile.cenarios

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.rebecca.p2_mobile.R
import com.example.rebecca.p2_mobile.entidades.Drink
import com.example.rebecca.p2_mobile.utilitarios.GlideApp
import kotlinx.android.synthetic.main.activity_detail_drink.*

class DetailDrink : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_drink)

        val param = intent.extras

        val drink : Drink

        if (param != null) {

            drink = param.getSerializable("object") as Drink
            DrinkName.setText(drink.strDrink)

            GlideApp.with(this)
                .load(drink.strDrinkThumb)
                .placeholder(R.drawable.ic_local_bar_black_24dp)
                .centerCrop()
                .into(imgDrinkPhoto)


            val ingredientes = mutableListOf(drink.strIngredient1, drink.strIngredient2,
                drink.strIngredient3,drink.strIngredient4,drink.strIngredient5,drink.strIngredient6,
                drink.strIngredient7,drink.strIngredient8,drink.strIngredient9,drink.strIngredient10,
                drink.strIngredient11,drink.strIngredient12,drink.strIngredient13,drink.strIngredient14,
                drink.strIngredient15)

            val medidas = mutableListOf(drink.strMeasure1, drink.strMeasure2,
                drink.strMeasure3,drink.strMeasure4,drink.strMeasure5,drink.strMeasure6,
                drink.strMeasure7,drink.strMeasure8,drink.strMeasure9,drink.strMeasure10,
                drink.strMeasure11,drink.strMeasure12,drink.strMeasure13,drink.strMeasure14,
                drink.strMeasure15)

            val ingredientsIterator = ingredientes.iterator()
            val stringIngredient = java.lang.StringBuilder()

            val quantityIterator = medidas.listIterator()
            val stringQuantity = StringBuilder()

            for(item in ingredientsIterator){
                if(!item.isNullOrBlank()){
                    stringIngredient.append(item).append('\n').append('\n')
                }
            }

            for(item in quantityIterator){
                if(!item.isNullOrBlank()){
                    stringQuantity.append(item).append('\n').append('\n')
                }
            }


            ingredient.setText(stringIngredient)
            quantity.text = stringQuantity
            Instrucoes.text = drink.strInstructions

            }
    }
}
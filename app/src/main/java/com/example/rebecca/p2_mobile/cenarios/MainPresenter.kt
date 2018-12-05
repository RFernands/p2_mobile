package com.example.rebecca.p2_mobile.cenarios

import com.example.rebecca.p2_mobile.entidades.DrinkList
import com.example.rebecca.p2_mobile.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view : MainContract.View) : MainContract.Presenter {

    override fun onLoadList(){

        val newsService = RetrofitInicializer().createNewsService()

        val call = newsService.getAlcoholicCocktail()

        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.showMessage("Falha na conexão.")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                if(response.body() != null){
                    view.showList(response.body()!!.drinks)
                }else {
                    view.showMessage("Sem coquetéis disponíveis.")
                }
            }
        })
    }
}
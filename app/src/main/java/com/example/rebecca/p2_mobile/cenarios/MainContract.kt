package com.example.rebecca.p2_mobile.cenarios

import com.example.rebecca.p2_mobile.entidades.Drink

class MainContract {

    interface  View{
        fun showMessage(msg: String)
        fun showList(drinks: List<Drink>)
    }

    interface Presenter{
        fun onLoadList()

    }
}
package com.example.rebecca.p2_mobile.cenarios

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rebecca.p2_mobile.entidades.Drink
import com.example.rebecca.p2_mobile.utilitarios.GlideApp
import com.example.rebecca.p2_mobile.R
import kotlinx.android.synthetic.main.item_drink.view.*

class ListaDrinksAdapter(val context: Context, val drinks: List<Drink>) : RecyclerView.Adapter<ListaDrinksAdapter.ViewHolder>() {

    var itemClickListener: ((index: Int) -> Unit)? = null
    fun setOnItemClickListener(clique: ((index: Int) -> Unit)) {
        this.itemClickListener = clique
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_drink, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, drinks[position], itemClickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, drink: Drink, itemClicklistener: ((index: Int) -> Unit)?) {
            itemView.tvName.text = drink.strDrink

            GlideApp.with(context)
                .load(drink.strDrinkThumb)
                .placeholder(R.drawable.ic_local_bar_black_24dp)
                .centerCrop()
                .into(itemView.imgDrink)

            if (itemClicklistener != null) {
                itemView.setOnClickListener {
                    itemClicklistener.invoke(adapterPosition)
                }
            }

        }
    }
}
package com.example.projectjuara.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.example.projectjuara.MainActivity
import com.example.projectjuara.R
import com.example.projectjuara.fragment.DetailOrder
import com.example.projectjuara.model.SearchItem
import kotlinx.android.synthetic.main.item_order.view.*

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    var data: List<SearchItem> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: SearchItem) = with(itemView) {

            itemView.txtAccount.setText(item.imdbID)
            itemView.txtName.setText(item.title)
            itemView.txtType.setText(item.type)
            Glide.with(itemView.context).load(item.poster).into(itemView.imageView)

            this.setOnClickListener(View.OnClickListener {

                it ->
                val ft: FragmentTransaction = (context as MainActivity).supportFragmentManager.beginTransaction()
                ft.replace(R.id.frameFragmen, DetailOrder.newInstance(item.imdbID.toString(),""),"")
                    .addToBackStack("list")
                ft.commit()

            })

        }
    }
}
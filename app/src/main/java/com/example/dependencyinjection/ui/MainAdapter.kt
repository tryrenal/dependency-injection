package com.example.dependencyinjection.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dependencyinjection.R
import com.example.dependencyinjection.domain.model.Sport
import kotlinx.android.synthetic.main.layout_item_sport.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var items = ArrayList<Sport>()
    fun setData(data: List<Sport>?){
        if (data == null) return
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_sport, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(data: Sport){
            with(itemView){
                Glide.with(context)
                    .load(data.sportThumb)
                    .into(img_sport)
                tv_sport.text = data.name
            }
        }
    }
}
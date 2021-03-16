package com.example.netflix.Adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.netflix.Model.Movie
import com.example.netflix.R
import com.squareup.picasso.Picasso

class Adapter(private val context: Context,private val movieList: MutableList<Movie>):RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var sus_image:ImageView
        var name_txt:TextView
        init {
            sus_image=itemView.findViewById(R.id.sus_image)
            name_txt=itemView.findViewById(R.id.name_txt)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       var itemView=LayoutInflater.from(context).inflate(R.layout.item_view,parent,false)
       return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(movieList[position].imageurl).into(holder.sus_image)
        holder.name_txt.text = movieList[position].name

    }

    override fun getItemCount(): Int {
        return  movieList.size
    }

}
package com.example.movieapp.Adater

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.movieapp.DetailsActivity
import com.example.movieapp.R
import com.example.movieapp.model.Movie
import kotlinx.android.synthetic.main.activity_details.view.*
import kotlinx.android.synthetic.main.frist_list_item.view.*
import kotlinx.android.synthetic.main.list_item_movie.view.*

class MoviesAdapter(val contect: Context, var movie: List<Movie?>?) :
    RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {

        val view = LayoutInflater.from(contect).inflate(R.layout.frist_list_item, p0, false)
       return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return movie?.size!!
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        with(holder.itemView) {
//            titledetailsText.text = movie?.get(position)?.title
//            subtitle.text = movie?.get(position)?.releaseDate
//            description.text = movie?.get(position)?.overview
//            rating.text = movie?.get(position)?.voteAverage.toString()

            Glide.with(contect).load("https://image.tmdb.org/t/p/w185/" + movie?.get(position)?.posterPath)
                .into(imageStarIV)


            setOnClickListener {
              var  intent =Intent(context,DetailsActivity::class.java)
                intent.putExtra("MOVIE",movie?.get(position))
                context.startActivity(intent)
            }
        }
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



    }
}
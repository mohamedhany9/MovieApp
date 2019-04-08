package com.example.movieapp


import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide

import com.example.movieapp.model.Movie
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var movieDetails = intent.getSerializableExtra("MOVIE") as Movie
        titledetailsText.text= movieDetails.title
        RatingTV.text = movieDetails.voteAverage.toString()
        descriptionDetailsTV.text = movieDetails.overview


        Glide.with(this).load("https://image.tmdb.org/t/p/w185/" + movieDetails?.posterPath)
            .into(imageDescriptionIV)


        youtubeTV.setOnClickListener {
        var intent =  Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=bzSTpdcs-EI"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setPackage("com.google.android.youtube");
        startActivity(intent)
        }
    }



}

package com.example.movieapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieapp.Adater.MoviesAdapter
import com.example.movieapp.Client.ApiClient
import com.example.movieapp.Client.ApiInterface
import com.example.movieapp.model.Movie
import com.example.movieapp.model.MoviesResponse
import kotlinx.android.synthetic.main.activity_main.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TopRateMovieFragment : Fragment() {

    lateinit var recyclerAdapter:MoviesAdapter


    val API_KEY:String="b7f2e8cc07b51ebdf46e2a10f396f999"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        var view:View =  inflater.inflate(R.layout.fragment_top_rate_movie, container, false)

        view.recyclerview.layoutManager = GridLayoutManager(context,3)

        val apiService: ApiInterface = ApiClient.getclient().create(ApiInterface::class.java)

        var call: Call<MoviesResponse> = apiService.getTopRatedMovies(API_KEY)

        call.enqueue(object : Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<MoviesResponse>?, response: Response<MoviesResponse>?) {
                var movies:List<Movie?>?

                movies = response?.body()?.results
                recyclerAdapter = MoviesAdapter(context!!,movies)
                view.recyclerview.adapter = recyclerAdapter
            }
        })
        return view
    }
    }


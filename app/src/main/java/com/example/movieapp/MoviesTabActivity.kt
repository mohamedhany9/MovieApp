package com.example.movieapp

import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager

import kotlinx.android.synthetic.main.activity_movies_tab.*

class MoviesTabActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_tab)

        setSupportActionBar(toolbar)
        tab_layout.setTabGravity(TabLayout.GRAVITY_FILL)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        container.adapter = mSectionsPagerAdapter
        tab_layout.setupWithViewPager(container)
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> {
                    return PopularMovieFragment()
                }
                1 -> {
                    return TopRateMovieFragment()
                }

                else -> return LatestMovieFragment()
            }
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }

        override fun getPageTitle(position: Int): CharSequence {
            return when (position) {
                0 -> "Popular"
                1 -> "Top Rated"
                else -> {
                    return "Latest"
                }
            }
        }
    }

    companion object {

    }
}


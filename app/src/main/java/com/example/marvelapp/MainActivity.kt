package com.example.marvelapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapp.adapter.RecyclerViewAdapter
import com.example.marvelapp.adapter.RecyclerViewAdapter2
import com.example.marvelapp.data.DataSource
import com.example.marvelapp.databinding.ActivityMainBinding
import com.example.marvelapp.model.Superheroe

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var miRecyler: RecyclerView
    val miAdapter: RecyclerViewAdapter = RecyclerViewAdapter()
    val miAdapter2: RecyclerViewAdapter2 = RecyclerViewAdapter2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarRecycler()
        cargarRecycler2()
    }
    fun cargarRecycler(){
      miRecyler = binding.rvSuperHeroes
      miRecyler.setHasFixedSize(true)
      miRecyler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
      miAdapter.RecyclerViewAdapter(
          DataSource().getSuperHeroes(), this)
      miRecyler.adapter = miAdapter
    }

    fun cargarRecycler2(){
        miRecyler = binding.rvSuperHeroes2
        miRecyler.setHasFixedSize(true)
        miRecyler.layoutManager = LinearLayoutManager(this)
        miAdapter2.RecyclerViewAdapter2(
            DataSource().getSuperHeroes(), this)
        miRecyler.adapter = miAdapter2
    }


}
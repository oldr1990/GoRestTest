package com.github.goresttest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.goresttest.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       Thread.sleep(2500)
        setTheme(R.style.Theme_GoRestTest)
        setContentView(R.layout.activity_main)
        val viewModel: MainViewModel by viewModels()
        val pagingAdapter = PagingAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
       val toolBarView = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        recyclerView.adapter = pagingAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.getPosts()
        lifecycleScope.launch(Dispatchers.IO){
            viewModel.pagingFlow?.collectLatest {
                pagingAdapter.submitData(it)
            }
        }
     recyclerView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
          if (oldScrollY != 0){
              toolBarView.visibility = View.GONE
          }
            else toolBarView.visibility = View.VISIBLE
        }
    }
}
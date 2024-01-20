package com.math.geovoyager.pages.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.math.geovoyager.R
import com.math.geovoyager.databinding.ActivityHomeBinding
import com.math.geovoyager.pages.home.adapters.RvMenuListAdapter
import com.math.geovoyager.pages.home.viewmodels.HomeViewModel
import com.math.geovoyager.utils.StatusBar.changeStatusBarColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        changeStatusBarColor(this, R.color.coral_pink, false)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        viewModel.menu.observe(this, Observer { items ->
            binding.rvMenuList.adapter = RvMenuListAdapter(this, items)
            binding.rvMenuList.layoutManager = GridLayoutManager(this, 2)
        })

        viewModel.loadMenu()
    }
}
package com.example.dependencyinjection.ui

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dependencyinjection.R
import com.example.dependencyinjection.viewModel.ViewModelFactory
import com.example.dependencyinjection.vo.Resource
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    private lateinit var mainAdapter: MainAdapter
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        mainAdapter = MainAdapter()
        progressDialog = ProgressDialog(this)

        viewModel.sports.observe(this) { sport ->
            when (sport) {
                is Resource.Loading -> {
                    progressDialog.setMessage(resources.getString(R.string.loading))
                    progressDialog.show()
                }
                is Resource.Error -> {
                    progressDialog.dismiss()
                    Toast.makeText(this, sport.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    progressDialog.dismiss()
                    mainAdapter.setData(sport.data)
                }
            }
        }

        showData()
    }

    private fun showData(){
        with(rv_sport){
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
        }
    }
}
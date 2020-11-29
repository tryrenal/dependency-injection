package com.example.dependencyinjection.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dependencyinjection.R
import com.example.dependencyinjection.vo.Resource
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by viewModel()
    private lateinit var mainAdapter: MainAdapter
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainAdapter = MainAdapter()
        progressDialog = ProgressDialog(this)

        mainViewModel.sports.observe(this) { sport ->
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
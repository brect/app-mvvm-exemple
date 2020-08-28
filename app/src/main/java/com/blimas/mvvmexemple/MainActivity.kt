package com.blimas.mvvmexemple

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        mainViewModel.textWelcome.observe(this, Observer{
            textWelcome.text = it
        })

        mainViewModel.login.observe(this, Observer{
            if (it){
                Toast.makeText(applicationContext, "Sucesso!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Falha!", Toast.LENGTH_SHORT).show()
            }
        })

        buttonLogin.setOnClickListener{
            val text = editName.text.toString()
            mainViewModel.login(text)
        }
    }
}
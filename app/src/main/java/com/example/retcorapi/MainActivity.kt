package com.example.retcorapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView=findViewById(R.id.textview)
        GlobalScope.launch {

        }
        lifecycleScope.launch(Dispatchers.Main){
            withContext(Dispatchers.Main){
                val result=TodosInstance.getInsance().getData()
                if(result.isSuccessful){
                    textView.setText(result.body().toString())
                    Log.d("TAG", "onCreate: ${result.body().toString()}")
            }
            }
        }

    }
}
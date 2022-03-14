package com.example.myviewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myviewmodeldemo.databinding.ActivityMainBinding
import com.example.myviewmodeldemo.models.StudentModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val student = ViewModelProvider(this).get(StudentModel::class.java)


        student.id.observe(this, Observer { newValue ->
            binding.tvId.text = newValue
        })

        student.name.observe(this, Observer { newValue ->
            binding.tvName.text = newValue
        })


        binding.btnSet.setOnClickListener(){
            student.id.value = "W1234"
            student.name.value = "John Alex"
        }

        binding.btnGet.setOnClickListener(){
            //binding.tvId.text = student.id
            //binding.tvName.text = student.name
        }
    }
}
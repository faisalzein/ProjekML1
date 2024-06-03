package com.dicoding.asclepius.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.asclepius.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data dari Intent
        val prediction = intent.getStringExtra("PREDICTION")
        val confidence = intent.getFloatExtra("CONFIDENCE", 0.0f)
        val imageUriString = intent.getStringExtra("IMAGE_URI")
        val imageUri = Uri.parse(imageUriString)

        // Menampilkan hasil
        binding.resultText.text = "Prediction: $prediction\nConfidence: ${confidence * 100}%"
        binding.resultImage.setImageURI(imageUri)
    }
}

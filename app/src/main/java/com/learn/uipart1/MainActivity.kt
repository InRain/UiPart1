package com.learn.uipart1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var copyButton: Button
    private lateinit var editText: EditText
    private lateinit var textView: TextView

    companion object{
        private const val DATA = "DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        copyButton = findViewById(R.id.button_copy)
        editText = findViewById(R.id.edit_text)
        textView = findViewById(R.id.copied_text)

        copyButton.setOnClickListener {
            textView.apply {
                text = editText.text
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(DATA, textView.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        textView.text = savedInstanceState.get(DATA) as CharSequence?
        super.onRestoreInstanceState(savedInstanceState)
    }
}
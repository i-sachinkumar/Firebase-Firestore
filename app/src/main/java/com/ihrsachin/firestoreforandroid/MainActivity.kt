package com.ihrsachin.firestoreforandroid

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {

    private val KEY_TITLE = "title"
    private val KEY_DESCRIPTION = "description"

    lateinit var containerView : LinearLayout
    lateinit var runTestBtn : Button
    lateinit var readBtn : Button


    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        containerView = findViewById(R.id.container)
        runTestBtn = findViewById(R.id.test_btn)
        readBtn = findViewById(R.id.read_btn)

        val title = "first title"
        val description = "first description"

        val note: MutableMap<String, Any> = HashMap()
        note[KEY_TITLE] = title
        note[KEY_DESCRIPTION] = description

       insertData()
    }

    private fun insertData() {
        val note: MutableMap<String, Any> = HashMap()
        note[KEY_TITLE] = "title"
        note[KEY_DESCRIPTION] = "sample description"

        db.collection("Notebook").document("My First Note").set(note)
            .addOnSuccessListener {
                showStatus("data added successfully")
            }
            .addOnFailureListener { e ->
                showStatus("Error in insert query $e")
            }

    }


    private fun showStatus(text: String) {
        Log.i("Status", text)
        val textView = TextView(this)
        textView.setPadding(10,10,10,10)
        textView.text = text
        containerView.addView(textView)
    }

}
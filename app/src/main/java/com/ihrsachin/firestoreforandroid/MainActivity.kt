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

        db.collection("Notebook").document("My First Note").set(note)
            .addOnSuccessListener {
                showStatus("Insert Query successful")
                insertData()
            }
            .addOnFailureListener { e ->
                showStatus("Error in insert query $e")
            }
    }

    private fun insertData() {
        val sampleData : ArrayList<String> = arrayListOf(
            "sample1",
            "sample2",
            "sample3",
            "sample4",
            "sample5",
            "sample6",
            "sample7",
            "sample8",
            "sample9",
            "sample10"
        )

        showStatus("Insert Query started for 1000 sample data")
        val start = System.nanoTime()
        val count = 1000
        for (i in 1..count){
            sampleData.shuffle()
            val note: MutableMap<String, Any> = HashMap()
            note[KEY_TITLE] = "title $i"
            note[KEY_DESCRIPTION] = sampleData[0]

            db.collection("Notebook $i").document("My First Note").set(note)
                .addOnSuccessListener {

                }
                .addOnFailureListener { e ->
                    showStatus("Error in insert query $e")
                }

        }
        showStatus("Insert Query successful")
        showStatus("time taken to add 1000 data: ${System.nanoTime() - start} nanoseconds")

    }

    private fun showStatus(text: String) {
        Log.i("Status", text)
        val textView = TextView(this)
        textView.setPadding(10,10,10,10)
        textView.text = text
        containerView.addView(textView)
    }

}
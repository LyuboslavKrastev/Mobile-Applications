package com.example.messagesharingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener{
            // Code
            Log.i("MainActivity", "Button was clicked")
            // Displays a message on the screen
            Toast.makeText(this, "Button was clicked!", Toast.LENGTH_SHORT).show()
        }

        btnSendMessageToNextActivity.setOnClickListener{
            // Get the message from the input field
            val message: String = editUserMessage.text.toString();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            // Move to second activity
            val intent = Intent(this, SecondActivity::class.java) // uses Kotlin reflection

            // Pass the message to the second activity
            intent.putExtra("user_message", message);

            startActivity(intent);
        }

        btnShareToOtherApps.setOnClickListener{
            val message = editUserMessage.text.toString()
            val intent = Intent()

            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to: "))
        }
    }
}

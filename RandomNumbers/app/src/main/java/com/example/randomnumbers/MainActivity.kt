package com.example.randomnumbers

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Nothing to see here", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        random_button.setOnClickListener(){
            generateRandom()
        }

    }

    private fun getToastMessage(field: String) = "Please enter a valid number in the $field field"

    private fun generateRandom () {
        // Check input fields

        // Get the input values
        val fromNumber: Int? = from_input.text.toString().toIntOrNull();
        if (fromNumber == null){
            Toast.makeText(this, getToastMessage("From"), Toast.LENGTH_SHORT).show()
            return
        }
        val untilNumber: Int? = until_input.text.toString().toIntOrNull();
        if (untilNumber == null){
            Toast.makeText(this, getToastMessage("Until"), Toast.LENGTH_SHORT).show()
            return
        }

        // Check the integers
        var min = fromNumber.toInt();
        var max = untilNumber.toInt();
        if(min >= max){
            val message: String = "Minimum cannot be greater than or equal to maximum."
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            return
        }

        // Get a random number
        val randomNumber: Int = nextInt(min, max);

        // Display the new value in the text view.
        number_field.text = randomNumber.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

package my.edu.tarc.demo41savedata

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonEdit.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        //Reading Shared Preferences
        val sharedPreferences = getSharedPreferences(getString(R.string.pref_file_name), Context.MODE_PRIVATE)
        val name = sharedPreferences.getString(getString(R.string.name), getString(R.string.default_name))

        textViewName.text = String.format("%s : %s", getString(R.string.name), name)
    }
}

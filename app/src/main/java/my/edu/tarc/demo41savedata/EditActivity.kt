package my.edu.tarc.demo41savedata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_main.*

class EditActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private var name: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        sharedPreferences = getSharedPreferences(getString(R.string.pref_file_name), Context.MODE_PRIVATE)
        name = sharedPreferences.getString(getString(R.string.name), getString(R.string.default_name))?:return

        editTextName.setText(String.format("%s", name))

        buttonDone.setOnClickListener {
            name = editTextName.text.toString()

            with(sharedPreferences.edit()){
                putString(getString(R.string.name), name)
                apply()
            }
            finish()
        }
    }


}

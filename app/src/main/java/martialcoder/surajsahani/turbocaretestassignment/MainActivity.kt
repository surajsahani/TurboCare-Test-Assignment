package martialcoder.surajsahani.turbocaretestassignment
import android.content.Intent
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar2)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Create new vehicle profile"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.navigationIcon!!.setTint(Color.BLACK)

        val floatbutton = findViewById<FloatingActionButton>(R.id.floatingActionButton5)
        floatbutton.setOnClickListener {
            val intent = Intent(this, SelectMake::class.java)
            startActivity(intent)
        }

    }
}
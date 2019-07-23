package com.github.translocathor.portalsoundboard

import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.translocathor.R
import com.github.translocathor.portalsoundboard.loader.SoundProviderTest
import android.media.MediaPlayer
import com.github.translocathor.portalsoundboard.model.Sound

class MainActivity : AppCompatActivity() {

    private var sounds: List<Sound> = ArrayList()
    private val TAG = MainActivity::class.java.simpleName
    private lateinit var textMessage: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    private lateinit var viewManager: RecyclerView.LayoutManager
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                textMessage.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        viewManager = LinearLayoutManager(this)
        val soundProviderTest: SoundProviderTest = SoundProviderTest()

        val itemClickListener = object : MyAdapter.ItemClickListener {
            override fun onClick(view: View, position: Int) {
                Log.d(TAG, "Clicked")
                val sound = sounds[position]
                val mediaPlayer = MediaPlayer.create(this@MainActivity, sound.resourceId)
                mediaPlayer.start() // no need to call prepare(); create() does that for you
            }
        }

        sounds = soundProviderTest.loadCategories().get(0).sounds

        viewAdapter = MyAdapter(
            sounds, itemClickListener
        )

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }
}

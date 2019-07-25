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
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.ferfalk.simplesearchview.SimpleSearchView
import com.github.translocathor.portalsoundboard.model.Sound
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        /**
         * Logging tag of this class.
         */
        private val TAG = MainActivity::class.java.simpleName
    }

    /**
     * List of all sounds that are currently shown in the recycler view.
     */
    private var sounds: List<Sound> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var simpleSearchView: SimpleSearchView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    private lateinit var viewManager: RecyclerView.LayoutManager
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

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

        simpleSearchView = findViewById(R.id.searchView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        val item: MenuItem = menu!!.findItem(R.id.action_search)
        searchView.setMenuItem(item)
        return true
    }
}

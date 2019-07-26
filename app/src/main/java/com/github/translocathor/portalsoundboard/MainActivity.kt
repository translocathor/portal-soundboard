package com.github.translocathor.portalsoundboard

import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.translocathor.R
import com.github.translocathor.portalsoundboard.loader.SoundProviderTest
import android.media.MediaPlayer
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import androidx.appcompat.widget.SearchView
import com.github.translocathor.portalsoundboard.model.Sound

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
    private lateinit var recyclerView: RecyclerView
    //private lateinit var simpleSearchView: SimpleSearchView
    private lateinit var viewAdapter: MyAdapter

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
        val soundProviderTest = SoundProviderTest()

        val itemClickListener = object : MyAdapter.SoundViewHolderClickListener {
            override fun onClick(view: View, sound: Sound) {
                Log.d(TAG, "Clicked")
                val mediaPlayer = MediaPlayer.create(this@MainActivity, sound.resourceId)
                mediaPlayer.start() // no need to call prepare(); create() does that for you
            }
        }

        val sounds = soundProviderTest.loadCategories().get(0).sounds

        viewAdapter = MyAdapter(
            sounds.toMutableList(), itemClickListener
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

        //simpleSearchView = findViewById(R.id.searchView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        val item: MenuItem = menu!!.findItem(R.id.action_search)
        val searchView = item.actionView as SearchView
        searchView.imeOptions = EditorInfo.IME_ACTION_DONE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d(TAG, "onQueryTextChange $newText")
                viewAdapter.filter.filter(newText)
                return false
            }

        })
        return true
    }

    override fun onBackPressed() {
//        if (searchView.onBackPressed()) {
//            return
//        }
        super.onBackPressed()
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (searchView.onActivityResult(requestCode, resultCode, data)) {
//            Log.d(TAG, "Result: $data")
//            return
//        }
//
//        super.onActivityResult(requestCode, resultCode, data)
//    }


}

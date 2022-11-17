package dev.faddy.vyt1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import dev.faddy.vyt1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        /*   binding.drawerNav.setNavigationItemSelectedListener {
               return@setNavigationItemSelectedListener true
           }
   */
    }

    fun openDrawer() {
        binding.drawerLayout.openDrawer(GravityCompat.START)
    }

    public fun closeDrawer() {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun showToast() {
        Toast.makeText(this, "Clicked on reportsLayout", Toast.LENGTH_SHORT).show()
    }


    /*   override fun onOptionsItemSelected(item: MenuItem): Boolean {
           when (item.itemId) {
               R.id.home -> {
                   binding.drawerLayout.openDrawer(GravityCompat.START)
                   return false
               }
           }
           return false
       }*/
}
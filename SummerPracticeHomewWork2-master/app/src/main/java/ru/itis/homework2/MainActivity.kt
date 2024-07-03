package ru.itis.homework2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ru.itis.homework2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var controller: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        controller =
            (supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment)
                .navController

        controller?.let { navController ->
            binding?.bottomNavigationView?.setupWithNavController(navController)
        }
        val bNV = binding?.bottomNavigationView
        val hB = binding?.bottomNavigationView?.menu?.findItem(R.id.home)
        val mesB = binding?.bottomNavigationView?.menu?.findItem(R.id.messages)
        val musB = binding?.bottomNavigationView?.menu?.findItem(R.id.music)
        val nB = binding?.bottomNavigationView?.menu?.findItem(R.id.notifications)
        val pB = binding?.bottomNavigationView?.menu?.findItem(R.id.profile)
        bNV?.setOnItemSelectedListener { item ->
            when (item) {
                hB -> {
                    controller?.navigate(R.id.homeFragment)
                    true
                }

                mesB -> {
                    controller?.navigate(R.id.messagesFragment)
                    true
                }

                musB -> {
                    controller?.navigate(R.id.musicFragment)
                    true
                }

                nB -> {
                    controller?.navigate(R.id.notificationsFragment)
                    true
                }

                pB -> {
                    controller?.navigate(R.id.profileFragment)
                    true
                }

                else -> false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
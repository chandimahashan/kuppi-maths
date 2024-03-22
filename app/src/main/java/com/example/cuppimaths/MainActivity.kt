package com.example.cuppimaths

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.cuppimaths.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener  {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding:ActivityMainBinding
    private lateinit var homeIntroCard:CardView

    var btnBack: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





//        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
//        val adapter =CustomAdapter()
//
//        recyclerView.layoutManager= LinearLayoutManager(this)
//        recyclerView.adapter = adapter


        setSupportActionBar(binding.toolbar)

        val toggle = ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationDrawer.setNavigationItemSelectedListener(this)

        binding.bottomNavigation.background =null
        binding.bottomNavigation.itemActiveIndicatorColor=null
        binding.bottomNavigation.setOnItemSelectedListener{
                item ->
            when(item.itemId){
                R.id.bottom_home ->openFragment(HomeFragment())
                R.id.nav_share -> openFragment(HomeFragment())
                R.id.bottom_contact -> openFragment(ContactUsFragment())

            }
            true
        }
        fragmentManager = supportFragmentManager
        openFragment(HomeFragment())



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> openFragment(HomeFragment())
            R.id.nav_Contact -> openFragment(ContactUsFragment())
            R.id.nav_privacy -> openFragment(PrivacyPolicyFragment())
            R.id.nav_Terms-> openFragment(TermsConditionFragment())
            R.id.nav_share -> Toast.makeText(this,"Share", Toast.LENGTH_SHORT).show()
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed(){
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            //super.onPrepareSupportNavigateUpTaskStack()
        }
    }
    private fun openFragment(fragment: Fragment){
        val fragmentTransaction:FragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }


}
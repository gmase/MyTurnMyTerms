package com.firstry.gmase.myterms

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * [FragmentPagerAdapter] derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    /**
     * The [ViewPager] that will host the section contents.
     */
    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val toolbar = findViewById(R.id.toolbar) as Toolbar
        //setSupportActionBar(toolbar)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container) as ViewPager
        mViewPager!!.adapter = mSectionsPagerAdapter

        val tabLayout = findViewById(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)

//        val fab = findViewById(R.id.fab) as FloatingActionButton
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_profile) {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
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
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return ProductExplorerFragment.newInstance(position + 1)
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> {
                    return "OFERTAS"
                    /*
                    val sb = SpannableStringBuilder(" ")
                    val drawable = getDrawable(R.drawable.simyo)
                    drawable.setBounds(0,0,24,24)
                    val imageSpan = ImageSpan(drawable)
                    sb.setSpan(imageSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    return sb*/
                }
                1 -> return "MI CESTA"
                2 -> return "SOCIAL"
            }
            return null
        }

//        override fun getPageTitle(position: Int): CharSequence? {
//            var sb = SpannableStringBuilder(" ")
//            when (position) {
//                0-> {
//                    //use the MrVector library to inflate vector drawable inside tab
//                    val icon = resources.getDrawable(R.drawable.ic_wifi_black_24dp, applicationContext.theme)
//                    val drawable = getDrawable(R.drawable.movistar)
//                    //set the size of drawable to 36 pixels
//                    drawable.setBounds(0, 0, 100, 100)
//                    val imageSpan = ImageSpan(drawable)
//                    //drawable.setBounds(0, 0, 36, 36)
//                    //to make our tabs icon only, set the Text as blank string with white space
//                    sb.setSpan(imageSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//                }
//                1-> {
//                    val icon = resources.getDrawable(R.drawable.ic_wifi_black_24dp, applicationContext.theme)
//                    val drawable = getDrawable(R.drawable.movistar)
//                    //set the size of drawable to 36 pixels
//                    drawable.setBounds(0, 0, 24, 24)
//                    val imageSpan = ImageSpan(drawable)
//                    //drawable.setBounds(0, 0, 36, 36)
//                    //to make our tabs icon only, set the Text as blank string with white space
//                    sb.setSpan(imageSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//                }
//                2->{
//                    val icon = resources.getDrawable(R.drawable.ic_wifi_black_24dp, applicationContext.theme)
//                    val drawable = getDrawable(R.drawable.movistar)
//                    //set the size of drawable to 36 pixels
//                    drawable.setBounds(0, 0, 24, 24)
//                    val imageSpan = ImageSpan(drawable)
//                    //drawable.setBounds(0, 0, 36, 36)
//                    //to make our tabs icon only, set the Text as blank string with white space
//                    sb.setSpan(imageSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//                }
//            }
//            return sb
//        }
    }
}

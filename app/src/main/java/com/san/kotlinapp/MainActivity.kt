package com.san.kotlinapp

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.san.kotlinapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var  mBinding : ActivityMainBinding
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                //message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                //message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
               // message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager.inTransaction { add(R.id.contentFrame,WeatherForecastFragment()) }
        //replaceFragmentInActivity(WeatherForecastFragment(), R.id.contentFrame, false,null)

    }


    fun replaceFragmentInActivity(
        fragment: Fragment,
        frameId: Int, addToBacksStack: Boolean, bundle: Bundle?
    ) {

        //Timber.d("replaceFragmentInActivity count:%s, addToBacksStack:%s",fragmentManager.getBackStackEntryCount(), addToBacksStack);
        if (!addToBacksStack) {
            supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
        val transaction = supportFragmentManager.beginTransaction()
        fragment.arguments = bundle
        transaction.replace(frameId, fragment)
        if (addToBacksStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }
}

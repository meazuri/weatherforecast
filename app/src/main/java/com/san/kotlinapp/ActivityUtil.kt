package com.san.kotlinapp

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {

    val fragmentTransaction= beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
}
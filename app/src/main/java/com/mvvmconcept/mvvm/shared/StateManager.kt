package com.mvvmconcept.mvvm.shared

import android.os.Bundle


interface StateManager {
    fun onSaveState(bundle: Bundle?)
    fun onRestoreState(bundle: Bundle?)
}
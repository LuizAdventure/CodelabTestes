package com.luizalberto.codelabtestes.utils

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.luizalberto.codelabtestes.R

private val navAnimation = NavOptions.Builder()
    .setEnterAnim(R.anim.slide_in_right)
    .setExitAnim(R.anim.slide_out_left)
    .setPopEnterAnim(R.anim.slide_in_left)
    .setPopExitAnim(R.anim.slide_out_right)
    .build()

fun NavController.navigateWithAnimations(destinationsID: Int) {
    this.navigate(destinationsID, null, navAnimation)
}

fun NavController.navigateWithAnimationsBundle(destinationsID: Int, bundle: Bundle) {
    this.navigate(destinationsID, bundle, navAnimation)
}

private val navAnimationReverse = NavOptions.Builder()
    .setEnterAnim(R.anim.slide_in_left)
    .setExitAnim(R.anim.slide_out_right)
    .setPopEnterAnim(R.anim.slide_in_right)
    .setPopExitAnim(R.anim.slide_out_left)
    .build()

fun NavController.navigateWithAnimationsReverse(destinationsID: Int) {
    this.navigate(destinationsID, null, navAnimationReverse)
}
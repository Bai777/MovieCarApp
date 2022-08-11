package com.example.moviecarapp

import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import com.example.moviecarapp.databinding.FragmentMainBinding
import kotlin.system.exitProcess

class Presenter(private val binding: FragmentMainBinding) {

    fun pressUp() {
        rotation(Way.UP)
        binding.car.animate()
            .translationYBy(-MOVE_DISTANCE)
            .setDuration(MOVE_DURATION)
            .setInterpolator(LinearInterpolator())
            .start()
    }

    fun pressLeft() {
        rotation(Way.LEFT)
        binding.car.animate()
            .translationXBy(-MOVE_DISTANCE)
            .setDuration(MOVE_DURATION)
            .setInterpolator(LinearInterpolator())
            .start()
    }

    fun pressDown() {
        rotation(Way.DOWN)
        binding.car.animate()
            .translationYBy(MOVE_DISTANCE)
            .setDuration(MOVE_DURATION)
            .setInterpolator(LinearInterpolator())
            .start()
    }

    fun pressRight() {
        rotation(Way.RIGHT)
        binding.car.animate()
            .translationXBy(MOVE_DISTANCE)
            .setDuration(MOVE_DURATION)
            .setInterpolator(LinearInterpolator())
            .start()
    }

    private fun rotation(way: Way) {
        binding.car.animate()
            .rotation(
                when (way) {
                    Way.UP -> 180f
                    Way.LEFT -> 90f
                    Way.DOWN -> 0f
                    Way.RIGHT -> 270f
                }
            )
            .setDuration(500)
            .setInterpolator(OvershootInterpolator())
            .start()
    }

    fun exit() {
        exitProcess(0)
    }

    companion object {
        const val MOVE_DURATION = 1000L
        const val MOVE_DISTANCE = 300f
    }
}
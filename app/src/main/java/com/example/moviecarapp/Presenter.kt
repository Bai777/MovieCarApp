package com.example.moviecarapp

import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import com.example.moviecarapp.databinding.FragmentMainBinding

class Presenter(private val binding: FragmentMainBinding) {

    fun pressUp() {
        binding.up.setOnClickListener {
            rotation(Way.UP)
            binding.car.animate()
                .translationYBy(-MOVE_DISTANCE)
                .setDuration(MOVE_DURATION)
                .setInterpolator(LinearInterpolator())
                .start()
        }
    }

    fun pressLeft() {
        binding.left.setOnClickListener {
            rotation(Way.LEFT)
            binding.car.animate()
                .translationXBy(-MOVE_DISTANCE)
                .setDuration(MOVE_DURATION)
                .setInterpolator(LinearInterpolator())
                .start()
        }
    }

    fun pressDown() {
        binding.down.setOnClickListener {
            rotation(Way.DOWN)
            binding.car.animate()
                .translationXBy(MOVE_DISTANCE)
                .setDuration(MOVE_DURATION)
                .setInterpolator(LinearInterpolator())
                .start()
        }
    }

    fun pressRight() {
        binding.right.setOnClickListener {
            rotation(Way.RIGHT)
            binding.car.animate()
                .translationXBy(MOVE_DISTANCE)
                .setDuration(MOVE_DURATION)
                .setInterpolator(LinearInterpolator())
                .start()
        }
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

    companion object {
        const val MOVE_DURATION = 1000L
        const val MOVE_DISTANCE = 200f
    }
}
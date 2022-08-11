package com.example.moviecarapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moviecarapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val presenter: Presenter by lazy { Presenter(binding) }

    private val listener: View.OnClickListener = View.OnClickListener {
        when (it.id) {
            binding.up.id -> presenter.pressUp()
            binding.left.id -> presenter.pressLeft()
            binding.down.id -> presenter.pressDown()
            binding.right.id -> presenter.pressRight()
            binding.exit.id -> presenter.exit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() {
        binding.up.setOnClickListener(listener)
        binding.left.setOnClickListener(listener)
        binding.down.setOnClickListener(listener)
        binding.right.setOnClickListener(listener)
        binding.exit.setOnClickListener(listener)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
package com.example.todolistmvvmroom.ui.fragments
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todolistmvvmroom.R
import com.example.todolistmvvmroom.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
   private lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false);

        Handler().postDelayed(Runnable {
            findNavController().navigate(R.id.homeFragment)

        }, 3000)
        return binding.root
    }


}
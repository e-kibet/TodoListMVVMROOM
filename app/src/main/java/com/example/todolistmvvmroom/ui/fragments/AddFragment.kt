package com.example.todolistmvvmroom.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.todolistmvvmroom.R
import com.example.todolistmvvmroom.databinding.FragmentAddBinding
import com.example.todolistmvvmroom.utils.hideKeyboard
import com.example.todolistmvvmroom.utils.shortToast
import com.example.todolistmvvmroom.viewmodel.TodoViewModel
import com.example.todolistmvvmroom.viewmodel.TodoViewModelFactory

class AddFragment : Fragment() {


    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater)
        val viewModelFactory = TodoViewModelFactory.getInstance(requireContext())
        val todoViewModel = ViewModelProvider(this, viewModelFactory)[TodoViewModel::class.java]
        binding.submitButton.setOnClickListener{
            val title = binding.title.text.toString().trim()
            val description = binding.description.text.toString().trim()
            if(title.isNotBlank() && description.isNotBlank()){
                todoViewModel.addTodo(title,description )
                activity?.hideKeyboard()
                findNavController().popBackStack()
            }else{
                context?.shortToast(getString(R.string.fill_all_fields))
            }
        }
        return binding.root;
    }
}
package com.example.a19112025_dev_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.a19112025_dev_1.R
import com.example.a19112025_dev_1.databinding.FragmentMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding

    private val auth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding){
        super.onViewCreated(view, savedInstanceState)

        loginBtn.setOnClickListener {
            val email = loginEmailET.text.toString()
            val password = loginPasswordET.text.toString()

            if (email.isNullOrEmpty() || password.isNullOrEmpty()){
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { result ->
                if (result.isSuccessful){
                    Toast.makeText(context, "user has successfully logged in", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "${result.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
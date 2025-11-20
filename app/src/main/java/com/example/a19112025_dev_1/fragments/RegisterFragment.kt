package com.example.a19112025_dev_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.a19112025_dev_1.R
import com.example.a19112025_dev_1.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding
    private val auth = FirebaseAuth.getInstance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {

        super.onViewCreated(view, savedInstanceState)
        registerLoginButton.setOnClickListener {
            replaceFragment(LoginFragment())
        }
        registerButton.setOnClickListener {
            val email = registerEmailET.text.toString()
            val password = registerPasswordET.text.toString()
            if (email.isEmpty() || email.contains(' ') || !email.contains('@') || password.isEmpty() || password.length < 4) {
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if(it.isSuccessful){
                    replaceFragment(LoginFragment())
                }else{
                    Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun replaceFragment(f:Fragment){
        parentFragmentManager.beginTransaction().replace(R.id.main,f).commit()
    }

}
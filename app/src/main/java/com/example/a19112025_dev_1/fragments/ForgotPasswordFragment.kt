package com.example.a19112025_dev_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.a19112025_dev_1.R
import com.example.a19112025_dev_1.databinding.FragmentForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordFragment : Fragment() {

    private lateinit var binding : FragmentForgotPasswordBinding

    private val auth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForgotPasswordBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding){
        super.onViewCreated(view, savedInstanceState)

        forgotPasswordSendLinkBtn.setOnClickListener {
            val email = forgotPasswordEmailET.text.toString()

            if (email.isNullOrEmpty()){
                return@setOnClickListener
            } else if(!email.contains('@') || email.contains(' ')){
                Toast.makeText(context, "email format is incorrect!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.sendPasswordResetEmail(email).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(context, "link has been sent to your email", Toast.LENGTH_SHORT).show()
                    parentFragmentManager.beginTransaction().replace(R.id.main,LoginFragment()).commit()
                } else {
                    Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ForgotPasswordFragment()
    }
}
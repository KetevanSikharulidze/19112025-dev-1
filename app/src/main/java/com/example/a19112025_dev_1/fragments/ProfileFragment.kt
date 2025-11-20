package com.example.a19112025_dev_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.a19112025_dev_1.R
import com.example.a19112025_dev_1.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding

    private val auth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            profileUserUIDTV.text = auth.currentUser!!.uid

            Glide.with(root).load("https://shorturl.at/s0VXp").into(profileUserPhotoIV)

            logoutBtn.setOnClickListener {
                auth.signOut()
                parentFragmentManager.beginTransaction().replace(R.id.main,LoginFragment()).commit()
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ProfileFragment()
    }
}
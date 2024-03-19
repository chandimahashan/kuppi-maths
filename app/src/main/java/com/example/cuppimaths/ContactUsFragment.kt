package com.example.cuppimaths

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class ContactUsFragment : Fragment() {
    private lateinit var faceBookLogo: ImageView
    private lateinit var linkedin: ImageView
    private lateinit var youTube: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contact_us, container, false)

        faceBookLogo = view.findViewById(R.id.contact_us_faceBookLogo)
        linkedin = view.findViewById(R.id.contact_us_linkdinLogo)
        youTube = view.findViewById(R.id.contact_us_youtubeLogo)

        faceBookLogo.setOnClickListener {
            gotoUrl("https://www.facebook.com/")
        }
        linkedin.setOnClickListener {
            gotoUrl("https://www.linkedin.com/in/chandima-hashan/")
        }
        youTube.setOnClickListener {
            gotoUrl("https://www.youtube.com/")
        }

        return view
    }

    private fun gotoUrl(url: String) {
        val uri = Uri.parse(url)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }
}

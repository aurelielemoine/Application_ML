package com.example.myapplicationml.ui.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplicationml.R
import com.example.myapplicationml.databinding.FragmentContactBinding


class ContactFragment : Fragment(){

    private var _binding: FragmentContactBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        val root: View = binding.root

        super.onCreate(savedInstanceState)

        binding.buttonAppel.id = R.id.button_appel
        binding.buttonAppel.setOnClickListener {
            dialPhoneNumber("0601917867")
        }

        binding.buttonContact.id = R.id.button_contact
        binding.buttonContact.setOnClickListener {
            insertContact("Eric Lemoine", "eric@menuiserie-lemoine.bzh", "Menuiserie Lemoine", "0601917867")
        }

        binding.buttonMail.id = R.id.button_mail
        binding.buttonMail.setOnClickListener {
            composeEmail(Array<String>(1) { "eric@menuiserie-lemoine.bzh" }, "Contact via l'appli mobile")
        }

        binding.buttonWeb.id = R.id.button_web
        binding.buttonWeb.setOnClickListener {
            openWebPage("https://www.menuiserie-lemoine.bzh")
        }

        binding.buttonMap.id = R.id.button_map
        binding.buttonMap.setOnClickListener {
            showMap(Uri.parse("geo:48.2711464,-2.0066018"))
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //ouvrir l'app d'appel
    fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        }
    }

    //ouvrir page web
    fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        }
    }

    //inserer un contact // ajouter une photo
    fun insertContact(name: String, email: String, company: String, phone: String) {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            type = ContactsContract.Contacts.CONTENT_TYPE
            putExtra(ContactsContract.Intents.Insert.NAME, name)
            putExtra(ContactsContract.Intents.Insert.EMAIL, email)
            putExtra(ContactsContract.Intents.Insert.COMPANY, company)
            putExtra(ContactsContract.Intents.Insert.PHONE, phone)
        }
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        }
    }

    //envoyer un mail
    fun composeEmail(addresses: Array<String>, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        }
    }

    //Show a location on a map
    fun showMap(geoLocation: Uri) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = geoLocation
        }
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        }
    }

}
package com.example.myapplicationml.ui.avis

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.myapplicationml.databinding.FragmentAvis2Binding

class AvisFragment2 : Fragment() {

    private var _binding: FragmentAvis2Binding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAvis2Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val webView = binding.webViewAvis
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true
        webView.settings.allowContentAccess = true
        webView.loadUrl("file:///android_asset/google_reviews.html")

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}
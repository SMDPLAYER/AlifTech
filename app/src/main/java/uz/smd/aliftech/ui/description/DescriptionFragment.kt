package uz.smd.aliftech.ui.description

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.ValueCallback
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_description.*
import uz.smd.aliftech.R


/**
 * Created by Siddikov Mukhriddin on 2/13/21
 */
@AndroidEntryPoint
class DescriptionFragment : Fragment(R.layout.fragment_description) {
    val handleLoad = MutableLiveData<Boolean>()
    val data = MutableLiveData<String>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data.value = requireArguments().getString("url1")
        handleLiveData()
    }

    @SuppressLint("FragmentLiveDataObserve")
    fun handleLiveData() {
        handleLoad.observe(this, Observer { swipe_container.isRefreshing = !it })
        data.observe(this, Observer {
            loadWebView("https://guidebook.com/$it")
            swipe_container.setOnRefreshListener { loadWebView("https://guidebook.com/$it") }
        })
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun loadWebView(url: String) {
        handleLoad.value = false
        vebView.apply {
            settings.apply {
                javaScriptEnabled = true
                loadWithOverviewMode = true
                useWideViewPort = true
                builtInZoomControls = true
                pluginState = WebSettings.PluginState.ON
            }
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    handleLoad.value = true
                }
            }
            loadUrl(url)
        }

    }


}
package com.rhotv.rhotv.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.rhotv.rhotv.ChromeClient;
import com.rhotv.rhotv.CustomWebViewClient;
import com.rhotv.rhotv.R;

public class HomeFragment extends Fragment {

    WebView webView;
    WebSettings webSettings;
    ChromeClient chromeClient;
    CustomWebViewClient webViewClient;
    ProgressBar progressBar;

    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        webView = root.findViewById(R.id.homeWebView);
        progressBar = root.findViewById(R.id.homeProgressBar);


        webSettings = webView.getSettings();

        chromeClient = new ChromeClient(getContext(), getActivity());
        webViewClient = new CustomWebViewClient(progressBar);

        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://rho.tv/");
        webView.setWebViewClient(webViewClient);
        webView.setWebChromeClient(chromeClient);


        return root;
    }


}
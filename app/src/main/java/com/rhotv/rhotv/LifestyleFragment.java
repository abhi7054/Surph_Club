package com.rhotv.rhotv;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;


public class LifestyleFragment extends Fragment {

    WebView featuredWebView;
    ProgressBar progressBar;
    String featuredURL = "https://rho.tv/category/music/";
    WebSettings webSettings;
    ChromeClient chromeClient;
    CustomWebViewClient customWebViewClient;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_featured, container, false);

        featuredWebView = root.findViewById(R.id.featuredWebView);
        progressBar = root.findViewById(R.id.featuredProgressBar);


        webSettings = featuredWebView.getSettings();
        chromeClient = new ChromeClient(getContext(), getActivity());
        customWebViewClient = new CustomWebViewClient(progressBar);

        webSettings.setJavaScriptEnabled(true);

        featuredWebView.loadUrl(featuredURL);
        featuredWebView.setWebViewClient(customWebViewClient);
        featuredWebView.setWebChromeClient(chromeClient);

        return root;
    }
}
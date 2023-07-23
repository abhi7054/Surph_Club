package com.rhotv.rhotv;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;


public class ShopFragment extends Fragment {


    WebView leaderWebView;
    ChromeClient chromeClient;
    CustomWebViewClient customWebViewClient;
    ProgressBar progressBar;
    WebSettings webSettings;
    String url = "https://rho.tv/shop/";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_create, container, false);

        leaderWebView = root.findViewById(R.id.homeWebView);
        progressBar = root.findViewById(R.id.homeProgressBar);

        webSettings = leaderWebView.getSettings();

        chromeClient = new ChromeClient(getContext(), getActivity());
        customWebViewClient = new CustomWebViewClient(progressBar);

        webSettings.setJavaScriptEnabled(true);
        leaderWebView.loadUrl(url);
        leaderWebView.setWebViewClient(customWebViewClient);
        leaderWebView.setWebChromeClient(chromeClient);


        return root;
    }
}
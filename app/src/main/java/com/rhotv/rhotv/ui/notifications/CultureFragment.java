package com.rhotv.rhotv.ui.notifications;

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

public class CultureFragment extends Fragment {

    WebView webView;
    ProgressBar progressBar;
    WebSettings webSettings;
    ChromeClient chromeClient;
    CustomWebViewClient customWebViewClient;

    String url = "https://rho.tv/category/shows/";

    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        webView = root.findViewById(R.id.leaderBoardWebView);
        progressBar = root.findViewById(R.id.leaderBoardProgressBar);

        webSettings = webView.getSettings();
        chromeClient = new ChromeClient(getContext(), getActivity());
        customWebViewClient = new CustomWebViewClient(progressBar);

        webSettings.setJavaScriptEnabled(true);

        webView.setWebChromeClient(chromeClient);
        webView.setWebViewClient(customWebViewClient);

        webView.loadUrl(url);

        return root;
    }
}
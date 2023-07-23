package com.rhotv.rhotv.ui.dashboard;

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

public class MusicFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    WebView profileWebView;
    ChromeClient chromeClient;
    CustomWebViewClient customWebViewClient;
    ProgressBar progressBar;
    WebSettings webSettings;
    String url = "https://rho.tv/category/music/";

    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        profileWebView = root.findViewById(R.id.profileWebView);
        progressBar = root.findViewById(R.id.profileProgressBar);

        chromeClient = new ChromeClient(getContext(), getActivity());
        customWebViewClient = new CustomWebViewClient(progressBar);
        webSettings = profileWebView.getSettings();

        profileWebView.setWebChromeClient(chromeClient);
        profileWebView.setWebViewClient(customWebViewClient);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        profileWebView.loadUrl(url);

        return root;
    }
}
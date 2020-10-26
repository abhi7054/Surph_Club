package com.devabhi.myapplication.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.devabhi.myapplication.ChromeClient;
import com.devabhi.myapplication.R;

public class HomeFragment extends Fragment {

    WebView webView;
    WebSettings webSettings;
    ChromeClient chromeClient;

    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        webView = root.findViewById(R.id.homeWebView);
        webSettings = webView.getSettings();

        chromeClient = new ChromeClient(getContext(), getActivity());

        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://www.surph.club/");
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(chromeClient);


        return root;
    }


}
package com.rhotv.rhotv;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class CustomWebViewClient extends WebViewClient {

    ProgressBar progressBar;

    public CustomWebViewClient(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String request) {

        progressBar.setVisibility(View.VISIBLE);
        view.loadUrl(request);

        return true;
    }



    @Override
    public void onPageFinished(WebView view, String url) {

        progressBar.setVisibility(View.GONE);

    }
}

package com.rhotv.rhotv;

import android.net.http.SslError;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
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
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        Log.e("Error received", error.toString());
        super.onReceivedError(view, request, error);
    }

    @Override
    public void onPageFinished(WebView view, String url) {

        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        // ignore ssl error
        if (handler != null){
            handler.proceed();
        } else {
            super.onReceivedSslError(view, null, error);
        }
    }
}

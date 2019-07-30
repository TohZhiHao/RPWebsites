package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebView wvMyPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
        Intent intentReceived = getIntent();
        String urlLink = intentReceived.getStringExtra("url");
        wvMyPage = findViewById(R.id.webViewWeb);
        wvMyPage.setWebViewClient(new WebViewClient());

        WebSettings webSettings = wvMyPage.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(false);
        webSettings.setDisplayZoomControls(true);

        wvMyPage.loadUrl(urlLink);

    }
}

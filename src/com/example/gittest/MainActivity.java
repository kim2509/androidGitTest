package com.example.gittest;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	boolean loadingFinished = true;
	boolean redirect = false;
	WebView webView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		webView = (WebView) findViewById(R.id.webview);
		webView.loadUrl("http://www.gmarket.co.kr");
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient() {

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String urlNewString) {
//				if (!loadingFinished) {
//					redirect = true;
//				}
//
				CookieManager cookieManager = CookieManager.getInstance();
                final String cookie = cookieManager.getCookie( urlNewString );
                Log.i("", "userInfo:" + cookie);
//                
//				loadingFinished = false;
//				webView.loadUrl(urlNewString);
//				return true;
				
				return false;
			}

			@Override
			public void onPageFinished(WebView view, String url) {
//				if(!redirect){
//					loadingFinished = true;
//				}
//
//				CookieManager cookieManager = CookieManager.getInstance();
//                final String cookie = cookieManager.getCookie( url );
//                Log.i("", "userInfo:" + cookie);
//
//				if(loadingFinished && !redirect){
//					//HIDE LOADING IT HAS FINISHED
//				} else{
//					redirect = false; 
//				}

			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

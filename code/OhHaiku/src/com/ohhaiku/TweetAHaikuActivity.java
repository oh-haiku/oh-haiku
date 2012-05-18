 package com.ohhaiku;

import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/*
 * Activity that allows the user to tweet a Haiku.
 */


public class TweetAHaikuActivity extends Activity {
	
    private static final String CONSUMER_SECRET = "xf47rFz6Q5WP1kB5HFOpXKh7oKw2h57e2KbzXe5vYaE";
	private static final String CONSUMER_KEY = "x2XkoKwcJrC9W92pP2jgw";
	private static final String CALLBACK_URL = "callback://tweeter";

	@Override
    public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.logintwitter);
	    
	    /* Check for saved login details */
	    this.checkForSavedLogin();
	    
	    /* Set customer and provider on the application service */
	    this.getCustomerProvider();
	    System.out.println("==========> Pelle");
		
	    Button buttonLogin = (Button)findViewById(R.id.ButtonLogin);
	    buttonLogin.setOnClickListener(new OnClickListener() {
	    	public void onClick(View v) {
	    		System.out.println("==========> First");
	    		askOAuth();
	    	}
	    });
	    
	 }

	private void getCustomerProvider() {
		// TODO Auto-generated method stub
		
	}

	private void checkForSavedLogin() {
		AccessToken a = getAccessToken();
		if(a == null) return;
		
		Twitter twitter =  new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		twitter.setOAuthAccessToken(a);
		
		
		// this.getApplication().setTwitter(twitter);
		this.startFirstActivity();
		finish();
	}
	
	private void startFirstActivity() {
		// TODO Auto-generated method stub
		
	}

	private void askOAuth() {
		try {
		  CommonsHttpOAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		  DefaultOAuthProvider provider = new DefaultOAuthProvider("http://twitter.com/oauth/request_token", "http://twitter.com/oauth/access_token", "http://twitter.com/oauth/authorize");
		  String authUrl = provider.retrieveRequestToken(consumer, CALLBACK_URL);
		  Toast.makeText(this, "Please authorize this app!", Toast.LENGTH_LONG).show();
		  setConsumerProvider();
		  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(authUrl)));
		} catch (Exception e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}


	private void setConsumerProvider() {
		// TODO Auto-generated method stub
		
	}

	private AccessToken getAccessToken() {
		// TODO Auto-generated method stub
		return null;
	}
}

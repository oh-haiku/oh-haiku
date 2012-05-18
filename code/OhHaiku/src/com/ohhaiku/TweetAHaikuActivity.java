 package com.ohhaiku;

import oauth.signpost.AbstractOAuthProvider;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/*
 * Activity that allows the user to tweet a Haiku.
 */


public class TweetAHaikuActivity extends Activity {
	
    public static final String CONSUMER_SECRET = "SwKSGxPgiekbaHjfZAkftno7qSRvvxaUlRDHE";
	public static final String CONSUMER_KEY = "cFr8hgs1HtB5PwoGS2GKA";
	private static final String CALLBACK_URL = "callback://tweeter";
	
	private CommonsHttpOAuthConsumer consumer = null;
	private AbstractOAuthProvider provider = null;
	private Twitter twitter = null;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    
	    /* Check for saved login details */
	    // this.checkForSavedLogin();
	    
	    /* Set customer and provider on the application service */
	    // this.getCustomerProvider();
		
	   
	    
	 }

	private void getCustomerProvider() {
		// TODO Auto-generated method stub
		
	}
	
	private void resetAuth() {
		this.storeAccessToken(null);
	}

	private void checkForSavedLogin() {
		AccessToken a = getAccessToken();
		if(a == null) return;
		
		this.twitter =  new TwitterFactory().getInstance();
		this.twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		this.twitter.setOAuthAccessToken(a);
		
		
		// this.getApplication().setTwitter(twitter);
		// this.startFirstActivity();
		finish();
	}
	
	private void getConsumerProvider() {
		OAuthProvider p = ((HaikuApplication)getApplication()).getProvider();
		if (p!=null){
			provider = (AbstractOAuthProvider) p;
		}
		CommonsHttpOAuthConsumer c = ((HaikuApplication)getApplication()).getConsumer();
		if (c!=null){
			consumer = c;
		}
	}
	
	@Override
	protected void onResume() {
	 super.onResume();
	 
	 Twitter twitter = ((HaikuApplication)getApplication()).getTwitter();
	    if(twitter != null){
	    	setContentView(R.layout.logouttwitter);
	    	Button buttonLogin = (Button)findViewById(R.id.LogoutButton);
	 	    buttonLogin.setOnClickListener(new OnClickListener() {
	 	    	public void onClick(View v) {
	 	    		resetAuth();
	 	    		startActivity(getIntent());
	 	    		finish();
	 	    	}
	 	    });
	    } else {
		    setContentView(R.layout.logintwitter);
		    Button buttonLogin = (Button)findViewById(R.id.LoginButton);
		    buttonLogin.setOnClickListener(new OnClickListener() {
		    	public void onClick(View v) {
		    		askOAuth();
		    	}
		    });

	    }
	    
	 if (this.getIntent()!=null && this.getIntent().getData()!=null){
		 
	  Uri uri = this.getIntent().getData();
	  if (uri != null && uri.toString().startsWith(CALLBACK_URL)) {
	   String verifier = uri.getQueryParameter(oauth.signpost.OAuth.OAUTH_VERIFIER);
	   try {
		
		this.getConsumerProvider();
		// this will populate token and token_secret in consumer
		this.provider.retrieveAccessToken(consumer, verifier);

	    // Get Access Token and persist it
	    AccessToken a = new AccessToken(consumer.getToken(), consumer.getTokenSecret());
	    storeAccessToken(a);

	    // initialize Twitter4J
	    twitter = new TwitterFactory().getInstance();
	    twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
	    twitter.setOAuthAccessToken(a);
	    
	    ((HaikuApplication)getApplication()).setTwitter(twitter);
	    
	    // ((TwitterApplication)getApplication()).setTwitter(twitter);
	    //Log.e("Login", "Twitter Initialised");
	    
	    // startFirstActivity();

	   } catch (Exception e) {
	    //Log.e(APP, e.getMessage());
	    e.printStackTrace();
	    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
	   }
	  }
	 }
	}


	private void askOAuth() {
		try {
		  this.consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		  this.provider = this.getNewProvider();
		  String authUrl = provider.retrieveRequestToken(consumer, CALLBACK_URL);
		  Toast.makeText(this, "Please authorize this app!", Toast.LENGTH_LONG).show();
		  setConsumerProvider();
		  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(authUrl)));
		  
		  System.err.println("This is the new shit : "+ this.provider);
		} catch (Exception e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}


	private AbstractOAuthProvider getNewProvider() {
		return new DefaultOAuthProvider("http://twitter.com/oauth/request_token", "http://twitter.com/oauth/access_token", "http://twitter.com/oauth/authorize");
	}
	
	private void setConsumerProvider() {
		if (provider!=null){
			((HaikuApplication)getApplication()).setProvider(provider);
		}
		if (consumer!=null){
			((HaikuApplication)getApplication()).setConsumer(consumer);
		}
	}


	private AccessToken getAccessToken() {
		SharedPreferences settings = getSharedPreferences("HaikuApplication", MODE_PRIVATE);
		String token = settings.getString("accessTokenToken", "");
		String tokenSecret = settings.getString("accessTokenSecret", "");
		if (token!=null && tokenSecret!=null && !"".equals(tokenSecret) && !"".equals(token)){
			return new AccessToken(token, tokenSecret);
		}
		return null;
	}


	private void storeAccessToken(AccessToken a) {
		SharedPreferences settings = getSharedPreferences("HaikuApplication", MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		if(a == null){
			editor.putString("accessTokenToken", null);
			editor.putString("accessTokenSecret", null);
		} else {
			editor.putString("accessTokenToken", a.getToken());
			editor.putString("accessTokenSecret", a.getTokenSecret());
		}

		editor.commit();
	}
}

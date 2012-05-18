/**
 * 
 */
package com.ohhaiku;


import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import android.app.Application;
import android.content.SharedPreferences;

public class HaikuApplication extends Application {
	
	
	private Twitter twitter;
	/**
	 * @return the twitter
	 */
	public Twitter getTwitter() {
		return twitter;
	}

	/**
	 * @param twitter the twitter to set
	 */
	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}

	private OAuthProvider provider;
	private CommonsHttpOAuthConsumer consumer;
	

	/**
	 * @param provider the provider to set
	 */
	public void setProvider(OAuthProvider provider) {
		this.provider = provider;
	}

	/**
	 * @return the provider
	 */
	public OAuthProvider getProvider() {
		return provider;
	}

	/**
	 * @param consumer the consumer to set
	 */
	public void setConsumer(CommonsHttpOAuthConsumer consumer) {
		this.consumer = consumer;
	}

	/**
	 * @return the consumer
	 */
	public CommonsHttpOAuthConsumer getConsumer() {
		return consumer;
	}
	
	public Twitter getTwitterConnection() {
		SharedPreferences settings = getSharedPreferences("HaikuApplication", MODE_PRIVATE);
		String token = settings.getString("accessTokenToken", "");
		String tokenSecret = settings.getString("accessTokenSecret", "");
		if (token!=null && tokenSecret!=null && !"".equals(tokenSecret) && !"".equals(token)){
			AccessToken accessToken = new AccessToken(token, tokenSecret);
		    Twitter twitter = new TwitterFactory().getInstance();
		    twitter.setOAuthConsumer(TweetAHaikuActivity.CONSUMER_KEY, TweetAHaikuActivity.CONSUMER_SECRET);
		    twitter.setOAuthAccessToken(accessToken);
		    return twitter;
		}
		return null;
	}


}

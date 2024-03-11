package at.ac.uibk.pm.gui.tweetinspector;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class holds information about tweets,
 */
public class Tweet {

    private StringProperty tweetText;
    private StringProperty user;
    private StringProperty source;
    private StringProperty tweetID;

    /**
     * Constructor with empty fields
     */
    public Tweet() {
        this.tweetText = new SimpleStringProperty();
        this.user = new SimpleStringProperty();
        this.source = new SimpleStringProperty();
        this.tweetID = new SimpleStringProperty();

    }

    /**
     * Constructor
     *
     * @param tweet   text of the tweet.
     * @param user    userID.
     * @param source  how the tweet was sent.
     * @param tweetID ID of the tweet.
     */
    public Tweet(String tweet, String user, String source, String tweetID) {
        this.tweetText = new SimpleStringProperty(tweet);
        this.user = new SimpleStringProperty(user);
        this.source = new SimpleStringProperty(source);
        this.tweetID = new SimpleStringProperty(tweetID);
    }

    /**
     * {@return the source of the tweet}
     */
    public String getSource() {
        return this.source.get();
    }

    /**
     * {@return the tweet id}
     */
    public String getTweetID() {
        return this.tweetID.get();
    }

    /**
     * {@return the tweeted message}
     */
    public String getTweetText() {
        return this.tweetText.get();
    }

    /**
     * {@return the tweeting user}
     */
    public String getUser() {
        return this.user.get();
    }

    /**
     * Sets the source of the tweet.
     *
     * @param source the source of the tweet
     */
    public void setSource(String source) {
        this.source.set(source);
    }

    /**
     * Sets the message of the tweet.
     *
     * @param tweet the message of the tweet
     */
    public void setTweet(String tweet) {
        this.tweetText.set(tweet);
    }

    /**
     * Sets the tweet id.
     *
     * @param tweetID the tweet id
     */
    public void setTweetID(Long tweetID) {
        this.tweetID.set(String.valueOf(tweetID));
    }

    /**
     * Sets the tweet id.
     *
     * @param tweetID the tweet id
     */
    public void setTweetID(String tweetID) {
        this.tweetID.set(tweetID);
    }

    /**
     * Sets the tweeting user.
     *
     * @param user the tweeting user
     */
    public void setUser(String user) {
        this.user.set(user);
    }

    @Override
    public String toString() {
        return "userID: " + this.user + ", tweet: " + this.tweetText + " ("
                + this.tweetID + "), service: " + this.source + "\n";
    }

}

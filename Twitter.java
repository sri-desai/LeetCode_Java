import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Twitter 
{
	private List<int[]> 						   global_posts;
	private HashMap<Integer, Queue<Integer>>       user_posts;
	private HashMap<Integer, HashSet<Integer>>     user_followed;
	
    /** Initialize your data structure here. */
    public Twitter() 
    {
        user_posts    = new HashMap<>();
        user_followed = new HashMap<>();
        global_posts  = new ArrayList<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId)
    {
        if(user_posts.containsKey(userId))
        {
        	user_posts.get(userId).add(tweetId);
        }
        else
        {
        	Queue<Integer> user_tweets = new LinkedList<Integer>();
        	user_tweets.add(tweetId);
        	user_posts.put(userId, user_tweets);
        }
        
        int[] posts = new int[2];
        posts[0] = userId;
        posts[1] = tweetId;
        
        global_posts.add(0, posts);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId)
    {
    	List<Integer>    ret_posts_list    = new ArrayList<>();
    	HashSet<Integer> cur_user_followed = null; 
    	
		if(user_followed.containsKey(userId)) cur_user_followed = user_followed.get(userId);
				
				
        for(int[] recent_posts : global_posts)
        {
        	if( recent_posts[0] == userId || 
        		(cur_user_followed != null && cur_user_followed.contains(recent_posts[0]))
        	  )
        		ret_posts_list.add(recent_posts[1]);
        }
        
        return ret_posts_list;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId)
    {
        if(user_followed.containsKey(followerId))
        {
        	user_followed.get(followerId).add(followeeId);
        }
        else
        {
        	HashSet<Integer> cur_following = new HashSet<Integer>();
        	cur_following.add(followeeId);
        	user_followed.put(followerId, cur_following);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId)
    {
        if(user_followed.containsKey(followerId))
        	user_followed.get(followerId).remove(followeeId);
    }



/******************************************************************************************************/
    
   public static void main(String[] args)
   {
	   Twitter twitter = new Twitter();
	   
	   twitter.postTweet(1, 5);
	   
	   twitter.postTweet(1, 3);
	   
	   twitter.postTweet(1, 101);
	   
	   twitter.postTweet(1, 13);
	   
	   twitter.postTweet(1, 10);
	   
	   twitter.postTweet(1, 2);
	   
	   twitter.postTweet(1, 94);
	   
	   twitter.postTweet(1, 505);
	   
	   twitter.postTweet(1, 333);
	   
	   twitter.postTweet(1, 22);
	   
	   twitter.postTweet(1, 11);
	   
	   twitter.postTweet(1, 1);
	   
	   System.out.println(twitter.getNewsFeed(1));
	   
   }

}

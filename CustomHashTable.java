import java.util.ArrayList;
import java.util.List;

class HashNode<K, V>
{
	private K key;
	private V value;
	private HashNode<K, V> next;
	
	public HashNode(K key, V value) 
	{
		this.key = key;
		this.value = value;
		this.next = null;
	}
	
	/* add function should be always called from the head of the list */
	public void add (HashNode<K, V> newNode)
	{
		HashNode<K, V> head = this;
		
		while(head.next != null && !head.key.equals(key))
		{
			head = head.next;
		}
		
		if(head.key.equals(key))
		{
			head.value = value;
		}
		else
		{
			head.next = newNode;
		}
	}

	public V get(K key)
	{
		HashNode<K, V> head = this;
		
		while(head != null && !head.key.equals(key))
		{
			head = head.next;
		}
		
		return head != null ? head.value : null;
	}

}

public class CustomHashTable<K, V>
{
	private int                  capacity;
	private int                  size;
	private List<HashNode<K, V>> bucket;
	
	public CustomHashTable() 
	{
		capacity = 100;
		size = 0;
		initBucket();
	}

	private final void initBucket() 
	{
		bucket = new ArrayList<>();
		
		for(int i = 0; i < capacity; ++i)
		{
			bucket.add(null);
		}		
	}

	private void reSizeBucket()
	{
		// TODO Auto-generated method stub
		
	}

	private int getIndex(K key) 
	{
		return key.hashCode() % capacity;
	}
	
	public void put (K key, V value)
	{
		if(key == null) return;
		
		int indexToBucket = getIndex(key);
		
		HashNode<K, V> newNode =  new HashNode<K, V>(key, value);
		
		if(bucket.get(indexToBucket) == null)
		{
			bucket.set(indexToBucket, newNode);
		}
		else
		{
			bucket.get(indexToBucket).add(newNode);
		}
		
		++size;
		
		reSizeBucket();
	}
	
	public V get(K key)
	{
		if(key == null) return null;
		if(bucket.get(getIndex(key)) == null) return null;
		
		return bucket.get(getIndex(key)).get(key);	
	}
	
	/* Testing*/
	public static void main(String[] args)
	{
		CustomHashTable<String, String> testObj = new CustomHashTable<>();
		
		testObj.put("first", "Hello");
		
		System.out.println(testObj.get("first"));
	}
}

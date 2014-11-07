/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.redis.api;

import com.creditcloud.model.enums.misc.CacheType;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;
import javax.ejb.Remote;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * redis client
 * 
 * @author suetming
 */
@Remote
public interface RedisService {

    public void put(String key, String value);

    public void put(String key, Object object);

    /**
     * binary content
     * @param key
     * @param value 
     */
    public void put(String key, byte[] value);
    
    /**
     * serializable value
     * @param key
     * @param value 
     */
    public void put(String key, Serializable value);
    
    /**
     * 
     * @param key
     * @return 
     */
    public String getString(String key);

    /**
     * put common class (Gson implements)
     * @param <T>
     * @param key
     * @param classOfT
     * @return
     */
    public <T> T get(String key, Class<T> classOfT);

    /**
     * Type typeOfSrc = new TypeToken&lt;Collection&lt;Foo&gt;&gt;(){}.getType();
     * 
     * @param <T>
     * @param key
     * @param typeOfT
     * @return 
     */
    public <T> T get(String key, Type typeOfT);
    
    /**
     * binary content
     * @param key
     * @return 
     */
    public byte[] getBytes(String key);
    
    /**
     * 
     * @param key
     * @return 
     */
    public Object getSerializable(String key);
    
    public boolean exist(String key);
    
    /**
     * subscribe to a channel in Redis
     * 
     * Note that subscribe is a blocking operation 
     * because it will poll Redis for responses on 
     * the thread that calls subscribe. A single 
     * JedisPubSub instance can be used to subscribe 
     * to multiple channels. You can call subscribe 
     * or psubscribe on an existing JedisPubSub instance 
     * to change your subscriptions.
     * @param listener 
     * @param keys 
     */
    public void subscribe(JedisPubSub listener, String ...keys);
    
    public void publish(String channel, String message);
    
    /**
     * expire a value
     * @param key 
     * @param second 
     */
    public void expire(String key, int second);
    
    /**
     * increment (first default value is 0)
     * 
     * atomic operation
     * 
     * Time complexity: O(1)
     * 
     * @param key
     * @return final increment result
     */
    public long increment(String key);
    
    /**
     * increment value (first default value is 0)
     * 
     * atomic operation
     * 
     * Time complexity: O(1)
     * 
     * @param key
     * @param value
     * @return final increment result
     */
    public long incrementBy(String key, long value);
    
    /**
     * decrement (first default value is 0)
     * 
     * atomic operation
     * 
     * Time complexity: O(1)
     * 
     * @param key
     * @return final decrement result
     */
    public long decrement(String key);
    
    /**
     * decrement value (first default value is 0)
     * 
     * atomic operation
     * 
     * Time complexity: O(1)
     * 
     * @param key
     * @param value
     * @return final decrement result
     */
    public long decrementBy(String key, long value);
    
    /**
     * get a value and set a value
     * 
     * atomic operation
     * 
     * Time complexity: O(1)
     * 
     * getSet can be used together with increment for counting 
     * with atomic reset. For example: a process may call increment
     * against the key mycounter every time some event occurs, 
     * but from time to time we need to get the value of the counter 
     * and reset it to zero atomically. This can be done using getSet 
     * mycounter "0":
     * @param key
     * @param value
     * @return 
     */
    public String getSet(String key, String value);
 
    
    /**
     * 
     * Time complexity: O(1)
     * 
     * Insert all the specified values at the tail of the list stored at key. 
     * If key does not exist, it is created as empty list before performing 
     * the push operation. When key holds a value that is not a list, an error 
     * is returned. is possible to push multiple elements using a single command
     * call just specifying multiple arguments at the end of the command. 
     * Elements are inserted one after the other to the tail of the list, 
     * from the leftmost element to the rightmost element. So for instance 
     * the command RPUSH mylist a b c will result into a list containing a as 
     * first element, b as second element and c as third element.
     * @param key
     * @param values
     * @return 
     */
    public long rpush(String key, String...values);
    
    /**
     * 
     * Time complexity: O(1)
     * 
     * Insert all the specified values at the head of the list stored at key.
     * If key does not exist, it is created as empty list before performing 
     * the push operations. When key holds a value that is not a list, 
     * an error is returned.
     * It is possible to push multiple elements using a single command call 
     * just specifying multiple arguments at the end of the command. Elements 
     * are inserted one after the other to the head of the list, from the 
     * leftmost element to the rightmost element. So for instance the command 
     * LPUSH mylist a b c will result into a list containing c as first element, 
     * b as second element and a as third element
     * 
     * @param key
     * @param values
     * @return 
     */
    public long lpush(String key, String...values);
    
    /**
     * 
     * Time complexity: O(S+N) where S is the distance of start 
     * offset from HEAD for small lists, from nearest end (HEAD or TAIL) 
     * for large lists; and N is the number of elements in the specified range.
     * 
     * 
     * Returns the specified elements of the list stored at key. 
     * The offsets start and stop are zero-based indexes, with 0 
     * being the first element of the list (the head of the list), 
     * 1 being the next element and so on.
     * These offsets can also be negative numbers indicating offsets 
     * starting at the end of the list. For example, -1 is the last 
     * element of the list, -2 the penultimate, and so on.
     * @param key
     * @param start
     * @param end
     * @return 
     */
    public List<String> range(String key, long start, long end);
    
    /**
     * 
     * Time complexity: O(1)
     * 
     * Returns the length of the list stored at key. 
     * If key does not exist, it is interpreted as an 
     * empty list and 0 is returned. An error is returned 
     * when the value stored at key is not a list.
     * 
     * @param key
     * @return 
     */
    public long count(String key);
    
    /**
     * 
     * Removes the first count occurrences of elements equal to value from the list stored at key. 
     * The count argument influences the operation in the following ways:
     *      count > 0: Remove elements equal to value moving from head to tail.
     *      count < 0: Remove elements equal to value moving from tail to head.
     *      count = 0: Remove all elements equal to value.
     * For example, LREM list -2 "hello" will remove the last two occurrences of "hello" in the list
     * stored at list.
     * Note that non-existing keys are treated like empty lists, so when key does not exist, 
     * the command will always return 0.
     * 
     * @param key
     * @param count
     * @param value
     * @return 
     */
    public long remove(String key, long count, String value);
    /**
     * 
     * Time complexity: O(N) where N is the number of keys that will be removed. 
     * When a key to remove holds a value other than a string, the individual 
     * complexity for this key is O(M) where M is the number of elements in the list, 
     * set, sorted set or hash. Removing a single key that holds a string value is O(1).
     * 
     * Removes the specified keys. A key is ignored if it does not exist.
     * @param keys
     * @return 
     */
    public long delete(String ...keys);
    
    /**
     * 
     * Time complexity: O(1)
     * 
     * Returns the remaining time to live of a key that has a timeout. 
     * This introspection capability allows a Redis client to check 
     * how many seconds a given key will continue to be part of the dataset.
     * 
     * @param keys
     * @return 
     */
    public long ttl(String keys);
}

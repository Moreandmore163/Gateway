/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.redis.api;

import javax.ejb.Remote;
import redis.clients.jedis.JedisPubSub;

/**
 * redis client
 * 
 * @author suetming
 */
@Remote
public interface RedisService {

    public void put(String key, String value);

    /**
     *
     * @param clientCode
     * @param key
     * @param value
     * @param clazz 当前所在类（避免相同键值对导致混淆）
     */
    public void put(String key, String value, Class clazz);

    public void put(String key, Object object);

    public void put(String key, Integer value);

    public String getString(String key);

    /**
     *
     * @param clientCode
     * @param key
     * @param clazz 当前所在类（避免相同键值对导致混淆）
     * @return
     */
    public String getString(String key, Class clazz);

    /**
     *
     * @param <T>
     * @param clientCode
     * @param key
     * @param classOfT
     * @return
     */
    public <T> T get(String key, Class<T> classOfT);

    public Integer getInteger(String key);

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
     * @param key
     * @param listener 
     */
    public void subscribe(String clientCode, JedisPubSub listener, String ...keys);
    
    /**
     * expire a value
     * @param clientCode
     * @param key
     * @param expire 
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
    
}

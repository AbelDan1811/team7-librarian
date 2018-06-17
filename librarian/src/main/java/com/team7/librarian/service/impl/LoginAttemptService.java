package com.team7.librarian.service.impl;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
public class LoginAttemptService {
	private static final int MAX_ATTEMP = 3;
	private LoadingCache<String, Integer> attempsCache;
	
	public LoginAttemptService() {
		attempsCache = CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.MINUTES)
							.build(new CacheLoader<String, Integer>(){
								public Integer load(String key) {
									return 0;
								}
							});
	}
	
	public void loginSucceeded(String key) {
		attempsCache.invalidate(key);
	}
	
	public void loginFailed(String key) {
		int attempts = 0;
		try {
			attempts = attempsCache.get(key);
		} catch (ExecutionException e) {
			attempts = 0;
		}
		attempts++;
		attempsCache.put(key, attempts);
	}
	
	public boolean isBlock(String key) {
		try {
			return attempsCache.get(key) >= MAX_ATTEMP;
		} catch (ExecutionException e) {
			return false;
		}
	}
}
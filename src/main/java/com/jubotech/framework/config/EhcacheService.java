package com.jubotech.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

@Service
public class EhcacheService {
	@Autowired
    private EhCacheCacheManager manager;
	
	public Cache  getCache(){
		return manager.getCache("custom");
	}
}

package com.employee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

	Logger log = LoggerFactory.getLogger(CacheService.class);
	
	@Autowired
	CacheManager cacheManager;

	public void evictAllCaches() {
		log.info("@evictAllCaches invoked");
		cacheManager.getCacheNames()
		            .stream()
		            .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
	}

	@Scheduled(cron = "0 0/2 * ? * *")
	public void evictAllcachesAtIntervals() {
		log.info("@evictAllcachesAtIntervals invoked");
		evictAllCaches();
	}
}

package com.tilundev.ocapi.internal;

import java.util.Date;
import java.util.Map;

import com.tilundev.ocapi.data.Beatmap;
import com.tilundev.ocapi.data.User;

public class Cache {
	private static Map<User,Date> userListCache;
	private static Map<Beatmap,Date> beatmapListCache;
	
	
	public static Map<User,Date> getUserListCache() {
		return userListCache;
	}
	public static Map<Beatmap,Date> getBeatmapListCache() {
		return beatmapListCache;
	}
	public static void setUserListCache(Map<User,Date> userListCache) {
		Cache.userListCache = userListCache;
	}
	public static void setBeatmapListCache(Map<Beatmap,Date> beatmapListCache) {
		Cache.beatmapListCache = beatmapListCache;
	}
	
	public static void addUserInCache(User user) {
		userListCache.put(user, new Date(System.currentTimeMillis()));
	}
	
	public static void addBeatmapInCache(Beatmap beatmap) {
		beatmapListCache.put(beatmap, new Date(System.currentTimeMillis()));
	}
	
	public static boolean isUserContain(User user) {
		return isUserContain(user.get_userId());
	}
	
	public static boolean isUserContain(Long user) {
		return userListCache.keySet().stream().filter(u -> u.get_userId() == user).count() > 0 ? true : false;
	}
	
	public static boolean isBeatmapContain(Beatmap beatmap) {
		return isBeatmapContain(beatmap.get_beatmapId());
	}
	
	public static boolean isBeatmapContain(Long beatmap) {
		return beatmapListCache.keySet().stream().filter(b -> b.get_beatmapId() == beatmap).count() > 0 ? true : false;
	}
	
	public static User getUserListByUserID(Long userID) {
		if(isUserContain(userID)) {
			User user = userListCache.keySet().stream().filter(u -> u.get_userId() == userID).findFirst().get();
			return user;
		}
		return null;
	}
	
	public static Beatmap getBeatmapListByBeatmapID(Long beatmapID) {
		if(isBeatmapContain(beatmapID)) {
			Beatmap beatmap = beatmapListCache.keySet().stream().filter(b -> b.get_beatmapId() == beatmapID).findFirst().get();
			return beatmap;
		}
		return null;
	}
}

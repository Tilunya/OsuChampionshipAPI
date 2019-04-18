package com.tilundev.ocapi.internal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.tilundev.ocapi.data.Beatmap;
import com.tilundev.ocapi.data.User;

public class Cache { // PB NIVEAU CACHE GET
	private static Map<User,Date> userListCache = new HashMap<User, Date>();
	private static Map<Beatmap,Date> beatmapListCache = new HashMap<Beatmap, Date>();
	
	
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
		return userListCache.keySet().stream().filter((u) -> user.equals(u.get_userId())).findAny().orElse(null) == null ? false : true;
	}
	
	public static boolean isBeatmapContain(Beatmap beatmap) {
		return isBeatmapContain(beatmap.get_beatmapId());
	}
	
	public static boolean isBeatmapContain(Long beatmap) {
		return beatmapListCache.keySet().stream().filter((b) -> b.equals(beatmap)).findAny().orElse(null) == null ? false : true;
	}
	
	public static User getUserListByUserID(Long userID) {
		if(isUserContain(userID)) {
			return userListCache.keySet().stream().filter((u) -> userID.equals(u.get_userId())).findAny().orElse(null);
		}
		return null;
	}
	
	public static Beatmap getBeatmapListByBeatmapID(Long beatmapID) {
		if(isBeatmapContain(beatmapID)) {
			return beatmapListCache.keySet().stream().filter((b) -> beatmapID.equals(b.get_beatmapId())).findAny().orElse(null);
		}
		return null;
	}
}

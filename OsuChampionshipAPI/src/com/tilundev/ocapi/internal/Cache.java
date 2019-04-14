package com.tilundev.ocapi.internal;

import java.util.List;

import com.tilundev.ocapi.data.Beatmap;
import com.tilundev.ocapi.data.User;

public class Cache {
	private static List<User> userListCache;
	private static List<Beatmap> beatmapListCache;
	
	
	public static List<User> getUserListCache() {
		return userListCache;
	}
	public static List<Beatmap> getBeatmapListCache() {
		return beatmapListCache;
	}
	public static void setUserListCache(List<User> userListCache) {
		Cache.userListCache = userListCache;
	}
	public static void setBeatmapListCache(List<Beatmap> beatmapListCache) {
		Cache.beatmapListCache = beatmapListCache;
	}
	
	public static void addUserInCache(User user) {
		userListCache.add(user);
	}
	
	public static void addBeatmapInCache(Beatmap beatmap) {
		beatmapListCache.add(beatmap);
	}
	
	public static boolean isUserContain(User user) {
		return userListCache.stream().filter(u -> u.get_userId() == user.get_userId()).count() > 0 ? true : false;
	}
	
	public static boolean isBeatmapContain(Beatmap beatmap) {
		return beatmapListCache.stream().filter(b -> b.get_beatmapId() == beatmap.get_beatmapId()).count() > 0 ? true : false;
	}
	
}

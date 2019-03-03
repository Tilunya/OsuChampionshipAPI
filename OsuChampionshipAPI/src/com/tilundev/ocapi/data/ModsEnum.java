package com.tilundev.ocapi.data;

public enum ModsEnum {
	NONE(0, false, false, false),
	NO_FAIL(1, false, true, false),
	EASY(2, false, true, false),
	TOUCH_DEVICE(4, false, false, false),
	HIDDEN(8, false, true, true),
	HARD_ROCK(16, false, true, true),
	SUDDEN_DEATH(32, false, true, false),
	DOUBLE_TIME(64, false, false, true),
	RELAX(128, false, true, false),
	HALF_TIME(256, false, false, false),
	NIGHTCORE(512, false, false, false),
	FLASHLIGHT(1024, false, true, true),
	AUTO_PLAY(2048, false, false, false),
	SPUN_OUT(4096, false, true, false),
	AUTO_PILOT(8192, false, true, false),
	PERFECT(16384, false, false, false),
	KEY4(32768, true, true, false),
	KEY5(65536, true, true, false),
	KEY6(131072, true, true, false),
	KEY7(262144, true, true, false),
	KEY8(524288, true, true, false),
	FADE_IN(1048576, false, true, true),
	RANDOM(2097152, false, false, false),
	CINEMA(4194304, false, false, false),
	TARGET(8388608, false, false, false),
	KEY9(16777216, true, true, false),
	KEY_COOP(33554432, true, true, false),
	KEY1(67108864, true, true, false),
	KEY3(134217728, true, true, false),
	KEY2(268435456, true, true, false),
	SCORE_V2(536870912, false, false, false),
	LAST_MOD(1073741824, false, false, false);
	
	
	private long id;
	private boolean keyMod;
	private boolean freeModAllowed;
	private boolean scoreIncreaseMods;
	
	private ModsEnum(long id, boolean km, boolean fma, boolean sim) {
		this.id = id;
		this.keyMod = km;
		this.freeModAllowed = fma;
		this.scoreIncreaseMods = sim;
	}

	public long getId() {
		return id;
	}

	public boolean isKeyMod() {
		return keyMod;
	}

	public boolean isFreeModAllowed() {
		return freeModAllowed;
	}

	public boolean isScoreIncreaseMods() {
		return scoreIncreaseMods;
	}
	
}

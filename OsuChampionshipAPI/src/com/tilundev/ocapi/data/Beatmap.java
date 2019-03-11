package com.tilundev.ocapi.data;

import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.tilundev.ocapi.util.DateUtil;
import com.tilundev.ocapi.util.StringUtil;
import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;
import com.tilundev.ocapi.utilexcept.NoApprouvedFoundException;
import com.tilundev.ocapi.utilexcept.NoGenreFoundException;
import com.tilundev.ocapi.utilexcept.NoLanguageFoundException;
import com.tilundev.ocapi.utilexcept.NoModFoundException;

public class Beatmap {
	private ApprouvedEnum _approuved;
	private Date _approuvedDate;
	private Date _lastUpdate;
	private String _artist;
	private Long _beatmapId;
	private Long _beatmapsetId;
	private int _bpm;
	private String _creator;
	private Long _creatorId;
	private Double _difficultyRating;
	private Double _difficultyCircleSize;
	private Double _difficultyOverall;
	private Double _difficultyApprochRate;
	private Double _difficultyHealthDrain;
	private Long _hitLength;
	private String _source;
	private GenreEnum _genre;
	private LanguageEnum _Language;
	private String _title;
	private Long _totalLength;
	private String _difficultyName; // called "version" in osu's API callback
	private String _fileMd5;
	private ModEnum _gameMode;
	private List<String> _tags;
	private Long _favoriteCount;
	private Long _playCount;
	private Long _passCount;
	private Long _maxCombo;
	
	// GETTERS

	public ApprouvedEnum get_approuved() {
		return _approuved;
	}

	public Date get_approuvedDate() {
		return _approuvedDate;
	}

	public Date get_lastUpdate() {
		return _lastUpdate;
	}

	public String get_artist() {
		return _artist;
	}

	public Long get_beatmapId() {
		return _beatmapId;
	}

	public Long get_beatmapsetId() {
		return _beatmapsetId;
	}

	public int get_bpm() {
		return _bpm;
	}

	public String get_creator() {
		return _creator;
	}

	public Long get_creatorId() {
		return _creatorId;
	}

	public Double get_difficultyRating() {
		return _difficultyRating;
	}

	public Double get_difficultyCircleSize() {
		return _difficultyCircleSize;
	}

	public Double get_difficultyOverall() {
		return _difficultyOverall;
	}

	public Double get_difficultyApprochRate() {
		return _difficultyApprochRate;
	}

	public Double get_difficultyHealthDrain() {
		return _difficultyHealthDrain;
	}

	public Long get_hitLength() {
		return _hitLength;
	}

	public String get_source() {
		return _source;
	}

	public GenreEnum get_genre() {
		return _genre;
	}

	public LanguageEnum get_Language() {
		return _Language;
	}

	public String get_title() {
		return _title;
	}

	public Long get_totalLength() {
		return _totalLength;
	}

	public String get_difficultyName() {
		return _difficultyName;
	}

	public String get_fileMd5() {
		return _fileMd5;
	}

	public ModEnum get_gameMode() {
		return _gameMode;
	}

	public List<String> get_tags() {
		return _tags;
	}

	public Long get_favoriteCount() {
		return _favoriteCount;
	}

	public Long get_playCount() {
		return _playCount;
	}

	public Long get_passCount() {
		return _passCount;
	}

	public Long get_maxCombo() {
		return _maxCombo;
	}
	
	
	// SETTERS
	
	public void set_approuved(ApprouvedEnum _approuved) {
		this._approuved = _approuved;
	}

	public void set_approuvedDate(Date _approuvedDate) {
		this._approuvedDate = _approuvedDate;
	}

	public void set_lastUpdate(Date _lastUpdate) {
		this._lastUpdate = _lastUpdate;
	}

	public void set_artist(String _artist) {
		this._artist = _artist;
	}

	public void set_beatmapId(Long _beatmapId) {
		this._beatmapId = _beatmapId;
	}

	public void set_beatmapsetId(Long _beatmapsetId) {
		this._beatmapsetId = _beatmapsetId;
	}

	public void set_bpm(int _bpm) {
		this._bpm = _bpm;
	}

	public void set_creator(String _creator) {
		this._creator = _creator;
	}

	public void set_creatorId(Long _creatorId) {
		this._creatorId = _creatorId;
	}

	public void set_difficultyRating(Double _difficultyRating) {
		this._difficultyRating = _difficultyRating;
	}

	public void set_difficultyCircleSize(Double _difficultyCircleSize) {
		this._difficultyCircleSize = _difficultyCircleSize;
	}

	public void set_difficultyOverall(Double _difficultyOverall) {
		this._difficultyOverall = _difficultyOverall;
	}

	public void set_difficultyApprochRate(Double _difficultyApprochRate) {
		this._difficultyApprochRate = _difficultyApprochRate;
	}

	public void set_difficultyHealthDrain(Double _difficultyHealthDrain) {
		this._difficultyHealthDrain = _difficultyHealthDrain;
	}

	public void set_hitLength(Long _hitLength) {
		this._hitLength = _hitLength;
	}

	public void set_source(String _source) {
		this._source = _source;
	}

	public void set_genre(GenreEnum _genre) {
		this._genre = _genre;
	}

	public void set_Language(LanguageEnum _Language) {
		this._Language = _Language;
	}

	public void set_title(String _title) {
		this._title = _title;
	}

	public void set_totalLength(Long _totalLength) {
		this._totalLength = _totalLength;
	}

	public void set_difficultyName(String _difficultyName) {
		this._difficultyName = _difficultyName;
	}

	public void set_fileMd5(String _fileMd5) {
		this._fileMd5 = _fileMd5;
	}

	public void set_gameMode(ModEnum _gameMode) {
		this._gameMode = _gameMode;
	}

	public void set_tags(List<String> _tags) {
		this._tags = _tags;
	}

	public void set_favoriteCount(Long _favoriteCount) {
		this._favoriteCount = _favoriteCount;
	}

	public void set_playCount(Long _playCount) {
		this._playCount = _playCount;
	}

	public void set_passCount(Long _passCount) {
		this._passCount = _passCount;
	}

	public void set_maxCombo(Long _maxCombo) {
		this._maxCombo = _maxCombo;
	}

	
	// CONSTRUCTORS
	 
	/**
	 * Default Constructor, nothing done.
	 * 
	 */
	public Beatmap() {
		//TODO [FR] Faire ça!
	}
	
	/**
	 * @param json
	 * @throws JSONException
	 * @throws NoApprouvedFoundException
	 * @throws BadJSONDateFormatException 
	 * @throws NoGenreFoundException 
	 * @throws NoLanguageFoundException 
	 * @throws NoModFoundException 
	 */
	public Beatmap(JSONObject json) throws BadJSONDateFormatException, JSONException, NoApprouvedFoundException, NoGenreFoundException, NoLanguageFoundException, NoModFoundException {
		this._approuved = ApprouvedEnum.getEnum(json.getInt(BeatmapEnum.APPROVED.getName()));
		this._approuvedDate = DateUtil.parseDate(json.getString(BeatmapEnum.APPROVED_DATE.getName()));
		this._lastUpdate = DateUtil.parseDate(json.getString(BeatmapEnum.LAST_UPDATE.getName()));
		this._artist = json.getString(BeatmapEnum.ARTIST.getName());
		this._beatmapId = json.getLong(BeatmapEnum.BEATMAP_ID.getName());
		this._beatmapsetId = json.getLong(BeatmapEnum.BEATMAPSET_ID.getName());
		this._bpm = json.getInt(BeatmapEnum.BPM.getName());
		this._creator = json.getString(BeatmapEnum.CREATOR.getName());
		this._creatorId = json.getLong(BeatmapEnum.CREATOR_ID.getName());
		this._difficultyRating = json.getDouble(BeatmapEnum.DIFFICULTY_RATING.getName());
		this._difficultyCircleSize = json.getDouble(BeatmapEnum.DIFF_SIZE.getName());
		this._difficultyOverall = json.getDouble(BeatmapEnum.DIFF_OVERALL.getName());
		this._difficultyHealthDrain = json.getDouble(BeatmapEnum.DIFF_DRAIN.getName());
		this._hitLength = json.getLong(BeatmapEnum.HIT_LENGTH.getName());
		this._source = json.getString(BeatmapEnum.SOURCE.getName());
		this._genre = GenreEnum.getEnum(json.getInt(BeatmapEnum.GENRE_ID.getName()));
		this._Language = LanguageEnum.getEnum(json.getInt(BeatmapEnum.LANGUAGE_ID.getName()));
		this._title = json.getString(BeatmapEnum.TITLE.getName());
		this._totalLength = json.getLong(BeatmapEnum.TOTAL_LENGTH.getName());
		this._difficultyName = json.getString(BeatmapEnum.VERSION.getName());
		this._fileMd5 = json.getString(BeatmapEnum.FILE_MD5.getName());
		this._gameMode = ModEnum.getEnum(json.getInt(BeatmapEnum.MODE.getName()));
		this._tags = StringUtil.split(json.getString(BeatmapEnum.TAGS.getName()), " ");
		this._favoriteCount = json.getLong(BeatmapEnum.FAVOURITE_COUNTS.getName());
		this._playCount = json.getLong(BeatmapEnum.PLAYCOUNT.getName());
		this._passCount =  json.getLong(BeatmapEnum.PASSCOUNT.getName());
		this._maxCombo = json.getLong(BeatmapEnum.MAX_COMBO.getName());
	}
	
	
}

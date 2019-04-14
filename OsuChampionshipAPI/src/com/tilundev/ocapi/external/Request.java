package com.tilundev.ocapi.external;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.tilundev.ocapi.data.Beatmap;
import com.tilundev.ocapi.data.BeatmapEnum;
import com.tilundev.ocapi.data.BestScore;
import com.tilundev.ocapi.data.ModsEnum;
import com.tilundev.ocapi.data.MultiplayerGame;
import com.tilundev.ocapi.data.RecentScore;
import com.tilundev.ocapi.data.ResultRequestData;
import com.tilundev.ocapi.data.Score;
import com.tilundev.ocapi.data.User;
import com.tilundev.ocapi.external.parameters.RequestParametersEnum;
import com.tilundev.ocapi.internal.Config;
import com.tilundev.ocapi.internal.request.RequestEnum;
import com.tilundev.ocapi.util.DateUtil;
import com.tilundev.ocapi.utilexcept.BadInitException;
import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;
import com.tilundev.ocapi.utilexcept.BadRequestException;
import com.tilundev.ocapi.utilexcept.NoApprouvedFoundException;
import com.tilundev.ocapi.utilexcept.NoGenreFoundException;
import com.tilundev.ocapi.utilexcept.NoLanguageFoundException;
import com.tilundev.ocapi.utilexcept.NoModFoundException;
import com.tilundev.ocapi.utilexcept.NoRequiredParameterFoundException;
import com.tilundev.ocapi.utilexcept.NoScoringTypeFoundException;
import com.tilundev.ocapi.utilexcept.NoTeamTypeFoundException;

public class Request {

	private String _keyAPI = null; // Required
	private String _sinceDate = null; // YYYY-MM-JJ
	private String _beatmapSetID = null;
	private String _beatmapID = null;
	private String _userID = null;
	private String _typeUserID = null;
	private String _mode = null;
	private String _modeConverter = null;
	private String _beatmapHash = null;
	private String _limit = null;
	private String _eventDays = null;
	private String _mods = null;
	private String _matchID = null;
	
	private boolean _init = false;
	private boolean _deepRequest = false;
	private RequestEnum _request = null;
	private JsonNode _body = null;
	private List<JsonNode> _deepBody = null;
	
	private ResultRequestData _requestData = new ResultRequestData();
	
	public Request() {
		// TODO Auto-generated constructor stub
	}
	
	
	// Public methods
	
	public Request getBeatmapRequest() {
		return this;
	}
	
	public Request setParameter(RequestParametersEnum rpe, String value) throws BadRequestException {
		switch (rpe) {
		case BEATMAP_HASH:
			this._beatmapHash = value;
			break;
			
		case BEATMAP_ID:
			this._beatmapID = value;
			break;
			
		case BEATMAP_SET_ID:
			this._beatmapSetID = value;
			break;
			
		case LIMIT_RESULT:
			try {
				switch (this._request) {
				case GET_BEATMAP:
					setLimitValue(500, value, rpe);
					break;
				case GET_SCORE:
				case GET_USER_BEST:
					setLimitValue(100, value, rpe);
					break;
				case GET_USER_RECENT:
					setLimitValue(50, value, rpe);
					break;
				default:
					if(this._request != null) {
						throw new BadRequestException(rpe.getName() + " is not used in " + this._request.getName());
					} else {
						throw new BadRequestException("No Request Set");
					}
				}
			} catch (Exception e) {
				throw new BadRequestException(e.getMessage());
			}
			break;
			
		case MODE:
			try {
				switch (this._request) {
				case GET_BEATMAP :
				case GET_SCORE : 
				case GET_USER :
				case GET_USER_BEST:
				case GET_USER_RECENT:
					setModeValue(value, rpe);
					break;
				default:
					if(this._request != null) {
						throw new BadRequestException(rpe.getName() + " is not used in " + this._request.getName());
					} else {
						throw new BadRequestException("No Request Set");
					}
				}
			} catch (Exception e) {
				throw new BadRequestException(e.getMessage());
			}
			break;
			
		case MODE_CONVERTER:
			try {
				switch (this._request) {
				case GET_BEATMAP:
					setModeConverterValue(value, rpe);
					break;
				default:
					if(this._request != null) {
						throw new BadRequestException(rpe.getName() + " is not used in " + this._request.getName());
					} else {
						throw new BadRequestException("No Request Set");
					}
				}
			} catch (Exception e) {
				throw new BadRequestException(e.getMessage());
			}
			break;
			
		case SINCE_DATE:
			try {
				switch (this._request) {
				case GET_BEATMAP:
					setDateValue(value, rpe);
					break;
				default:
					if(this._request != null) {
						throw new BadRequestException(rpe.getName() + " is not used in " + this._request.getName());
					} else {
						throw new BadRequestException("No Request Set");
					}
				}
			} catch (Exception e) {
				throw new BadRequestException(e.getMessage());
			}
			break;
			
		case USER_ID:
			this._userID = value;
			break;
			
		case USER_TYPE_DATA:
			try {
				switch (this._request) {
				case GET_BEATMAP:
				case GET_SCORE:
				case GET_USER:
				case GET_USER_BEST:
				case GET_USER_RECENT:
					setUserTypeValue(value, rpe);
					break;
				default:
					if(this._request != null) {
						throw new BadRequestException(rpe.getName() + " is not used in " + this._request.getName());
					} else {
						throw new BadRequestException("No Request Set");
					}
				}
			} catch (Exception e) {
				throw new BadRequestException(e.getMessage());
			}
			break;
			
		case EVENT_DAYS:
			try {
				switch (this._request) {
				case GET_USER:
					setEventDaysValue(value, rpe);
					break;
				default:
					if(this._request != null) {
						throw new BadRequestException(rpe.getName() + " is not used in " + this._request.getName());
					} else {
						throw new BadRequestException("No Request Set");
					}
				}
			} catch (Exception e) {
				throw new BadRequestException(e.getMessage());
			}
		case MODS:
			try {
				switch (this._request) {
				case GET_USER:
					setModsValue(value, rpe);
					break;
				default:
					if(this._request != null) {
						throw new BadRequestException(rpe.getName() + " is not used in " + this._request.getName());
					} else {
						throw new BadRequestException("No Request Set");
					}
				}
			} catch (Exception e) {
				throw new BadRequestException(e.getMessage());
			}
		case MATCH_ID:
			this._matchID = value;
			return this;
			
		default:
			new BadRequestException("Wrong parameter").printStackTrace();
			break;
		}
		
		return this;
		
	}
	
	public Request setParameters(Map<RequestParametersEnum,String> mapParameter) throws BadRequestException {
		try {
			mapParameter.forEach((t, u) -> {
				try {
					setEachParameter(t, u);
				} catch (BadRequestException e) {
					throw new RuntimeException(e);
				}
			});
		} catch (RuntimeException e) {
			throw (BadRequestException) e.getCause();
		}
		return this;
	}
	

	public Request setParameter(RequestParametersEnum rpe, List<ModsEnum> mods) throws BadRequestException {
		int val = 0;
		for (int i = 0; i < mods.size(); i++) {
			val += mods.get(i).getId();
		}
		String value = Integer.toString(val);
		this.setParameter(rpe, value);
		return this;
	}
	
	public Request start() throws Exception {
		this.init();
		if(this._init) {
			Map<String,Object> map = constructParameters();
			if(requiredParamater()) {
				String adress = Config.API_ADDRESS+this._request.getRequest();
				if(!_deepRequest) {
					try {
						HttpResponse<JsonNode> res = Unirest.get(adress)
								.queryString(map)
								.asJson();
						this._body = res.getBody(); 
						constructData(res.getBody());
					} catch (Exception e) {
						throw e;
					}
				} else {
					try {
						HttpResponse<JsonNode> res = Unirest.get(adress)
								.queryString(map)
								.asJson();
						this._body = res.getBody();
						handleDeepRequest();
					} catch (UnirestException e) {
						throw e;
					}
				}
				return this;
			} else {
				throw new NoRequiredParameterFoundException("A Require Parameter is missing. Request can't start");
			}
		} else {
			throw new BadInitException("Request initialisation failed.");
		}
	}
	
	public Request setRequest(RequestEnum re) {
		this._request = re;
		return this;
	}

	public JsonNode getBody() {
		return this._body;
	}
	
	public List<JsonNode> getDeepBody() {
		return this._deepBody;
	}
	
	public ResultRequestData getConstructData() {
		return this._requestData;
	}
	
	
	
	// Private methods
	
	
	
	private void init() {
		this._keyAPI = Config.getApiKey();
		if(this._keyAPI == null || this._keyAPI.isEmpty()) {
			return;
		}
		if(this._request == null)
			return;
		this._init = true;
	}
	
	private boolean requiredParamater() {
		switch (this._request) {
		case GET_BEATMAP:
			return this._keyAPI != null;
		case GET_USER:
		case GET_USER_BEST:
		case GET_USER_RECENT:
			return (this._keyAPI != null && this._userID != null);
		case GET_SCORE:
			return (this._keyAPI != null && this._beatmapID != null);
		case GET_MATCH:
			return (this._keyAPI != null && this._matchID != null);
		default:
			return false;
		}
	}
	
	private void setEachParameter(RequestParametersEnum rpe, String val) throws BadRequestException {
		this.setParameter(rpe, val);
	}
	
	private void setLimitValue(int limit , String value, RequestParametersEnum rpe) throws BadRequestException, NumberFormatException {
		int testUser = Integer.parseInt(value);
		if(testUser >= 0 && testUser <=limit) {
			this._limit = value;
		} else {
			throw new BadRequestException("Wrong value for \""+ rpe.getName() +"\" parameter. : " + value +" (100 max)");
		}
	}
	
	private void setModeValue(String value, RequestParametersEnum rpe) throws BadRequestException, NumberFormatException {
		int test = Integer.parseInt(value);
		if(test >= 0 && test <=3) {
			this._mode = value;
		} else {
			throw new BadRequestException("Wrong value for \""+ rpe.getName() +"\" parameter. : " + value);
		}
	}
	
	private void setModeConverterValue(String value, RequestParametersEnum rpe) throws BadRequestException, NumberFormatException {
		int test = Integer.parseInt(value);
		if(test == 0 || test == 1) {
			this._modeConverter = value;
		} else {
			throw new BadRequestException("Wrong value for \""+ rpe.getName() +"\" parameter. : " + value);
		}
	}
	
	private void setDateValue(String value, RequestParametersEnum rpe) throws BadRequestException, BadJSONDateFormatException {
		if(DateUtil.isDateCorrect(value)) {
			this._sinceDate = value;
		} else {
			throw new BadRequestException("Wrong value for \""+ rpe.getName() +"\" parameter. : " + value);
		}
	}
	
	private void setUserTypeValue(String value, RequestParametersEnum rpe) throws BadRequestException {
		if(value.equals("string") || value.equals("id")) {
			this._typeUserID = value;
		} else {
			throw new BadRequestException("Wrong value for \""+ rpe.getName() +"\" parameter. : " + value + " Only \"string\" and \"id\" works");
		}
	}
	
	private void setEventDaysValue(String value, RequestParametersEnum rpe) throws BadRequestException, NumberFormatException {
		int test = Integer.parseInt(value);
		if(test >= 1 && test <= 31) {
			this._modeConverter = value;
		} else {
			throw new BadRequestException("Wrong value for \""+ rpe.getName() +"\" parameter. : " + value);
		}
	}
	
	private void setModsValue(String value, RequestParametersEnum rpe) throws BadRequestException, NumberFormatException {
		int test = Integer.parseInt(value);
		if(test >= 0) {
			this._mods = value;
		} else {
			throw new BadRequestException("Wrong value for \""+ rpe.getName() +"\" parameter. : " + value);
		}
	}
	
	private void handleDeepRequest() {
		switch (this._request) {
		case GET_BEATMAP:
			deepRequestGetBeatmap();
			break;
		case GET_MATCH:
			break;
		case GET_SCORE:
			break;
		case GET_USER:
			break;
		case GET_USER_BEST:
			break;
		case GET_USER_RECENT:
			break;
		default:
			break;
		}
	}
	
	private void deepRequestGetBeatmap() {
		Set<Long> userList = new HashSet<Long>();
		JSONArray jsonArr = this._body.getArray();
		for (int i = 0; i < jsonArr.length(); i++) {
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			if(jsonObj.get(BeatmapEnum.CREATOR_ID.getName()) != JSONObject.NULL) {
				userList.add(jsonObj.getLong(BeatmapEnum.CREATOR_ID.getName()));
			}
		}
		userList.forEach(userID -> {
			RequestEnum deepRequestEnum = RequestEnum.GET_USER;
			try {
				this.setParameter(RequestParametersEnum.USER_ID, userID.toString())
				.setParameter(RequestParametersEnum.USER_TYPE_DATA, "id");
				deepStart(deepRequestEnum);
			} catch (BadInitException | NoRequiredParameterFoundException | BadRequestException e) {
				// TODO Change This
				e.printStackTrace();
			}
		});
	}
	
	private Request deepStart(RequestEnum re) throws BadInitException, NoRequiredParameterFoundException {
		deepInit(re);
		if(this._init) {
			Map<String,Object> map = constructParameters();
			if(requiredParamater()) {
				String adress = Config.API_ADDRESS+this._request.getRequest();
					try {
						HttpResponse<JsonNode> res = Unirest.get(adress)
								.queryString(map)
								.asJson();
						this._deepBody.add(res.getBody()); 
					} catch (UnirestException e) {
						e.printStackTrace();
					}
				return this;
			} else {
				throw new NoRequiredParameterFoundException("A Require Parameter is missing. Request can't start");
			}
		} else {
			throw new BadInitException("Request initialisation failed.");
		}
	}
	
	private void deepInit(RequestEnum re) {
		this._request = re;
		resetParameters();
		this._init = true;
	}
	
	private void resetParameters() {
		this._sinceDate = null;
		this._beatmapSetID = null;
		this._beatmapID = null;
		this._userID = null;
		this._typeUserID = null;
		this._mode = null;
		this._modeConverter = null;
		this._beatmapHash = null;
		this._limit = null;
		this._eventDays = null;
		this._mods = null;
		this._matchID = null;
	}
	
	private Map<String,Object> constructParameters(){
		Map<String,Object> map = new HashMap<String,Object>();
		switch (_request) {
		case GET_BEATMAP:
			if(this._keyAPI != null && !this._keyAPI.isEmpty()) {
				map.put(RequestParametersEnum.API_KEY.getParamNaming(), this._keyAPI);
			}
			if(this._sinceDate != null && !this._sinceDate.isEmpty()) {
				map.put(RequestParametersEnum.SINCE_DATE.getParamNaming(), this._sinceDate);
			}
			if(this._beatmapHash != null && !this._beatmapHash.isEmpty()) {
				map.put(RequestParametersEnum.BEATMAP_HASH.getParamNaming(), this._beatmapHash);
			}
			if(this._beatmapID != null && !this._beatmapID.isEmpty()) {
				map.put(RequestParametersEnum.BEATMAP_ID.getParamNaming(), this._beatmapID);
			}
			if(this._beatmapSetID != null && !this._beatmapSetID.isEmpty()) {
				map.put(RequestParametersEnum.BEATMAP_SET_ID.getParamNaming(), this._beatmapSetID);
			}
			if(this._limit != null && !this._limit.isEmpty()) {
				map.put(RequestParametersEnum.LIMIT_RESULT.getParamNaming(), this._limit);
			}
			if(this._mode != null && !this._mode.isEmpty()) {
				map.put(RequestParametersEnum.MODE.getParamNaming(), this._mode);
			}
			if(this._modeConverter != null && !this._modeConverter.isEmpty()) {
				map.put(RequestParametersEnum.MODE_CONVERTER.getParamNaming(), this._modeConverter);
			}
			if(this._typeUserID != null && !this._typeUserID.isEmpty()) {
				map.put(RequestParametersEnum.USER_TYPE_DATA.getParamNaming(), this._typeUserID);
			}
			if(this._userID != null && !this._userID.isEmpty()) {
				map.put(RequestParametersEnum.USER_ID.getParamNaming(), this._userID);
			}
			return map;
			
		case GET_USER:
			if(this._keyAPI != null && !this._keyAPI.isEmpty()) {
				map.put(RequestParametersEnum.API_KEY.getParamNaming(), this._keyAPI);
			}
			if(this._userID != null && !this._userID.isEmpty()) {
				map.put(RequestParametersEnum.USER_ID.getParamNaming(), this._userID);
			}
			if(this._mode != null && !this._mode.isEmpty()) {
				map.put(RequestParametersEnum.MODE.getParamNaming(), this._mode);
			}
			if(this._typeUserID != null && !this._typeUserID.isEmpty()) {
				map.put(RequestParametersEnum.USER_TYPE_DATA.getParamNaming(), this._typeUserID);
			}
			if(this._eventDays != null && !this._eventDays.isEmpty()) {
				map.put(RequestParametersEnum.EVENT_DAYS.getParamNaming(), this._eventDays);
			}
			return map;
			
		case GET_SCORE:
			if(this._keyAPI != null && !this._keyAPI.isEmpty()) {
				map.put(RequestParametersEnum.API_KEY.getParamNaming(), this._keyAPI);
			}
			if(this._beatmapID != null && !this._beatmapID.isEmpty()) {
				map.put(RequestParametersEnum.BEATMAP_ID.getParamNaming(), this._beatmapID);
			}
			if(this._userID != null && !this._userID.isEmpty()) {
				map.put(RequestParametersEnum.USER_ID.getParamNaming(), this._userID);
			}
			if(this._mode != null && !this._mode.isEmpty()) {
				map.put(RequestParametersEnum.MODE.getParamNaming(), this._mode);
			}
			if(this._mods != null && !this._mods.isEmpty()) {
				map.put(RequestParametersEnum.MODS.getParamNaming(), this._mods);
			}
			if(this._typeUserID != null && !this._typeUserID.isEmpty()) {
				map.put(RequestParametersEnum.USER_TYPE_DATA.getParamNaming(), this._typeUserID);
			}
			if(this._limit != null && !this._limit.isEmpty()) {
				map.put(RequestParametersEnum.LIMIT_RESULT.getParamNaming(), this._limit);
			}
			return map;
		case GET_USER_BEST:
		case GET_USER_RECENT:
			if(this._keyAPI != null && !this._keyAPI.isEmpty()) {
				map.put(RequestParametersEnum.API_KEY.getParamNaming(), this._keyAPI);
			}
			if(this._userID != null && !this._userID.isEmpty()) {
				map.put(RequestParametersEnum.USER_ID.getParamNaming(), this._userID);
			}
			if(this._mode != null && !this._mode.isEmpty()) {
				map.put(RequestParametersEnum.MODE.getParamNaming(), this._mode);
			}
			if(this._limit != null && !this._limit.isEmpty()) {
				map.put(RequestParametersEnum.LIMIT_RESULT.getParamNaming(), this._limit);
			}
			if(this._typeUserID != null && !this._typeUserID.isEmpty()) {
				map.put(RequestParametersEnum.USER_TYPE_DATA.getParamNaming(), this._typeUserID);
			}
			return map;
		case GET_MATCH:
			if(this._keyAPI != null && !this._keyAPI.isEmpty()) {
				map.put(RequestParametersEnum.API_KEY.getParamNaming(), this._keyAPI);
			}
			if(this._matchID != null && !this._matchID.isEmpty()) {
				map.put(RequestParametersEnum.MATCH_ID.getParamNaming(), this._matchID);
			}
			return map;

		default:
			return null;
		}
		
	}
	
	private void constructData(JsonNode node) throws JSONException, BadJSONDateFormatException, NoApprouvedFoundException, NoGenreFoundException, NoLanguageFoundException, NoModFoundException, NoScoringTypeFoundException, NoTeamTypeFoundException {
		switch (this._request) {
		case GET_BEATMAP:
			constructBeatmapData(node);
			break;
		case GET_MATCH:
			constructMatchData(node);
			break;
		case GET_SCORE:
			constructScoreData(node);
			break;
		case GET_USER:
			constructUserData(node);
			break;
		case GET_USER_BEST:
			constructBestScoreData(node);
			break;
		case GET_USER_RECENT:
			constructRecentScoreData(node);
			break;
		default:
			break;
		}
	}
	
	private void constructBeatmapData(JsonNode node) throws JSONException, BadJSONDateFormatException, NoApprouvedFoundException, NoGenreFoundException, NoLanguageFoundException, NoModFoundException {
		JSONArray jsonArr = node.getArray();
		for (int i = 0; i < jsonArr.length(); i++) {
			JSONObject json = jsonArr.getJSONObject(i);
			if(json != null) {
				this._requestData.get_beatmapsList().add(new Beatmap(json));
			}
		}
	}
	
	private void constructUserData(JsonNode node) throws JSONException, BadJSONDateFormatException {
		JSONArray jsonArr = node.getArray();
		for (int i = 0; i < jsonArr.length(); i++) {
			JSONObject json = jsonArr.getJSONObject(i);
			if(json != null) {
				this._requestData.get_usersList().add(new User(json));
			}
		}
	}
	
	private void constructScoreData(JsonNode node) throws BadJSONDateFormatException {
		JSONArray jsonArr = node.getArray();
		for (int i = 0; i < jsonArr.length(); i++) {
			JSONObject json = jsonArr.getJSONObject(i);
			if(json != null) {
				this._requestData.get_scoresList().add(new Score(json));
			}
		}
	}
	
	private void constructBestScoreData(JsonNode node) throws BadJSONDateFormatException {
		JSONArray jsonArr = node.getArray();
		for (int i = 0; i < jsonArr.length(); i++) {
			JSONObject json = jsonArr.getJSONObject(i);
			if(json != null) {
				this._requestData.get_bestScoresList().add(new BestScore(json));
			}
		}
	}
	
	private void constructRecentScoreData(JsonNode node) throws BadJSONDateFormatException {
		JSONArray jsonArr = node.getArray();
		for (int i = 0; i < jsonArr.length(); i++) {
			JSONObject json = jsonArr.getJSONObject(i);
			if(json != null) {
				this._requestData.get_recentScoresList().add(new RecentScore(json));
			}
		}
	}
	
	private void constructMatchData(JsonNode node) throws JSONException, BadJSONDateFormatException, NoModFoundException, NoScoringTypeFoundException, NoTeamTypeFoundException {
		JSONObject json = node.getObject();
		this._requestData.get_multiplayerGamesList().add(new MultiplayerGame(json));
	}
}

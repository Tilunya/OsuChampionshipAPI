package com.tilundev.ocapi.external;

import java.sql.Date;
import java.util.Map;

import com.tilundev.ocapi.external.parameters.BeatmapParametersEnum;
import com.tilundev.ocapi.internal.Config;
import com.tilundev.ocapi.internal.request.BeatmapRequestEnum;

public class BeatmapRequest {

	private String _keyAPI; // Required
	private String _sinceDate; // YYYY-MM-JJ
	private String _beatmapSetID;
	private String _beatmapID;
	private String _userID;
	private String _typeUserID;
	private String _mode;
	private String _modeConverter;
	private String _beatmapHash;
	private String _limit;
	
	private boolean _init = false;
	private BeatmapRequestEnum _request;
	
	public BeatmapRequest() {
		// TODO Auto-generated constructor stub
	}
	
	
	// Public methods
	
	public BeatmapRequest getBeatmapRequest() {
		this.init(BeatmapRequestEnum.GET_BEATMAP_REQUEST);
		return this;
	}
	
	public BeatmapRequest addParameter(BeatmapParametersEnum beatmapParameterEnum, String value) {
		switch (beatmapParameterEnum) {
		case BEATMAP_HASH:
			break;
			
		case BEATMAP_ID:
			break;
			
		case BEATMAP_SET_ID:
			break;
			
		case LIMIT_RESULT:
			break;
			
		case MODE:
			break;
			
		case MODE_CONVERTER:
			break;
			
		case SINCE_DATE:
			break;
			
		case USER_ID:
			break;
			
		case USER_TYPE_DATA:
			break;
			
		default:
			break;
		}
		
		return this;
		
	}
	

	public BeatmapRequest addParameters(Map<String,BeatmapParametersEnum> mapParameter) {
		
	}
	
	
	// Private methods
	
	private void init(BeatmapRequestEnum bre) {
		this._request = bre;
		this._keyAPI = Config.getApiKey();
		if(this._keyAPI == null || this._keyAPI.isEmpty()) {
			//TODO Handle Error;
		}
		this._init = true;
	}
	
}

package com.tilundev.ocapi.external;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.tilundev.ocapi.external.parameters.BeatmapParametersEnum;
import com.tilundev.ocapi.internal.Config;
import com.tilundev.ocapi.internal.request.BeatmapRequestEnum;
import com.tilundev.ocapi.util.DateUtil;
import com.tilundev.ocapi.utilexcept.BadRequestException;

public class BeatmapRequest {

	private String _keyAPI = ""; // Required
	private String _sinceDate = ""; // YYYY-MM-JJ
	private String _beatmapSetID = "";
	private String _beatmapID = "";
	private String _userID = "";
	private String _typeUserID = "";
	private String _mode = "";
	private String _modeConverter = "";
	private String _beatmapHash = "";
	private String _limit = "";
	
	private boolean _init = false;
	private BeatmapRequestEnum _request;
	private JsonNode _body = null;
	
	public BeatmapRequest() {
		// TODO Auto-generated constructor stub
	}
	
	
	// Public methods
	
	public BeatmapRequest getBeatmapRequest() {
		return this;
	}
	
	public BeatmapRequest setParameter(BeatmapParametersEnum beatmapParameterEnum, String value) {
		switch (beatmapParameterEnum) {
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
				int test = Integer.parseInt(value);
				if(test >= 0 && test <=500) {
					this._limit = value;
				} else {
					throw new BadRequestException("Wrong value for \"Limit Result\" parameter. : " + value +" (500 max)");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case MODE:
			try {
				int test = Integer.parseInt(value);
				if(test >= 0 && test <=3) {
					this._mode = value;
				} else {
					throw new BadRequestException("Wrong value for \"Mode\" parameter. : " + value);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case MODE_CONVERTER:
			try {
				int test = Integer.parseInt(value);
				if(test == 0 || test == 1) {
					this._modeConverter = value;
				} else {
					throw new BadRequestException("Wrong value for \"Mode Converter\" parameter. : " + value);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case SINCE_DATE:
			try {
				if(DateUtil.isDateCorrect(value)) {
					this._sinceDate = value;
				} else {
					throw new BadRequestException("Wrong value for \"Since Date\" parameter. : " + value);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case USER_ID:
			this._userID = value;
			break;
			
		case USER_TYPE_DATA:
			try {
				if(value.equals("string") || value.equals("id")) {
					this._typeUserID = value;
				} else {
					throw new BadRequestException("Wrong value for \"User Type Data\" parameter. : " + value + " Only \"string\" and \"id\" works");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		default:
			new BadRequestException("Wrong parameter").printStackTrace();
			break;
		}
		
		return this;
		
	}
	
	public BeatmapRequest setParameters(Map<BeatmapParametersEnum,String> mapParameter) {
		mapParameter.forEach((bpe,val)-> {
			this.setParameter(bpe, val);
		});
		return this;
	}
	
	public BeatmapRequest start() {
		this.init(BeatmapRequestEnum.GET_BEATMAP_REQUEST);
		Map<String,Object> map = constructParameters();
		String adress = Config.API_ADDRESS+BeatmapRequestEnum.GET_BEATMAP_REQUEST.getRequest();
		try {
			HttpResponse<JsonNode> res = Unirest.get(adress)
					.queryString(map)
					.asJson();
			this._body = res.getBody(); 
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public JSONArray getBody() {
		if(this._body == null) {
			return null;
		}
		else {
			if(this._body.isArray()) {
				return this._body.getArray();
			} else {
				return null;
			}
		}
	}
	
	// Private methods
	
	private void init(BeatmapRequestEnum bre) {
		this._request = bre;
		this._keyAPI = Config.getApiKey();
		if(this._keyAPI == null || this._keyAPI.isEmpty()) {
			//TODO Handle Error;
			return;
		}
		this._init = true;
	}
	
	private Map<String,Object> constructParameters(){
		Map<String,Object> map = new HashMap<String,Object>();
		if(!this._keyAPI.isEmpty()) {
			map.put(BeatmapParametersEnum.API_KEY.getParamNaming(), this._keyAPI);
		}
		if(!this._sinceDate.isEmpty()) {
			map.put(BeatmapParametersEnum.SINCE_DATE.getParamNaming(), this._sinceDate);
		}
		if(!this._beatmapHash.isEmpty()) {
			map.put(BeatmapParametersEnum.BEATMAP_HASH.getParamNaming(), this._beatmapHash);
		}
		if(!this._beatmapID.isEmpty()) {
			map.put(BeatmapParametersEnum.BEATMAP_ID.getParamNaming(), this._beatmapID);
		}
		if(!this._beatmapSetID.isEmpty()) {
			map.put(BeatmapParametersEnum.BEATMAP_SET_ID.getParamNaming(), this._beatmapSetID);
		}
		if(!this._limit.isEmpty()) {
			map.put(BeatmapParametersEnum.LIMIT_RESULT.getParamNaming(), this._limit);
		}
		if(!this._mode.isEmpty()) {
			map.put(BeatmapParametersEnum.MODE.getParamNaming(), this._mode);
		}
		if(!this._modeConverter.isEmpty()) {
			map.put(BeatmapParametersEnum.MODE_CONVERTER.getParamNaming(), this._modeConverter);
		}
		if(!this._typeUserID.isEmpty()) {
			map.put(BeatmapParametersEnum.USER_TYPE_DATA.getParamNaming(), this._typeUserID);
		}
		if(!this._userID.isEmpty()) {
			map.put(BeatmapParametersEnum.USER_ID.getParamNaming(), this._userID);
		}
		return map;
	}
	
}

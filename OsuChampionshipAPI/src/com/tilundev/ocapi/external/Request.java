package com.tilundev.ocapi.external;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.tilundev.ocapi.external.parameters.RequestParametersEnum;
import com.tilundev.ocapi.internal.Config;
import com.tilundev.ocapi.internal.request.RequestEnum;
import com.tilundev.ocapi.util.DateUtil;
import com.tilundev.ocapi.utilexcept.BadInitException;
import com.tilundev.ocapi.utilexcept.BadRequestException;
import com.tilundev.ocapi.utilexcept.NoRequiredParameterFoundException;

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
	
	private boolean _init = false;
	private RequestEnum _request = null;
	private JsonNode _body = null;
	
	public Request() {
		// TODO Auto-generated constructor stub
	}
	
	
	// Public methods
	
	public Request getBeatmapRequest() {
		return this;
	}
	
	public Request setParameter(RequestParametersEnum requestParameterEnum, String value) {
		switch (requestParameterEnum) {
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
					throw new BadRequestException("Wrong value for \""+ requestParameterEnum.getName() +"\" parameter. : " + value +" (500 max)");
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
					throw new BadRequestException("Wrong value for \""+ requestParameterEnum.getName() +"\" parameter. : " + value);
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
					throw new BadRequestException("Wrong value for \""+ requestParameterEnum.getName() +"\" parameter. : " + value);
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
					throw new BadRequestException("Wrong value for \""+ requestParameterEnum.getName() +"\" parameter. : " + value);
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
					throw new BadRequestException("Wrong value for \""+ requestParameterEnum.getName() +"\" parameter. : " + value + " Only \"string\" and \"id\" works");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case EVENT_DAYS:
			try {
				int test = Integer.parseInt(value);
				if(test >= 1 || test <= 31) {
					this._modeConverter = value;
				} else {
					throw new BadRequestException("Wrong value for \""+ requestParameterEnum.getName() +"\" parameter. : " + value);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		default:
			new BadRequestException("Wrong parameter").printStackTrace();
			break;
		}
		
		return this;
		
	}
	
	public Request setParameters(Map<RequestParametersEnum,String> mapParameter) {
		mapParameter.forEach((bpe,val)-> {
			this.setParameter(bpe, val);
		});
		return this;
	}
	
	public Request start() throws BadInitException, NoRequiredParameterFoundException {
		this.init();
		if(this._init) {
			Map<String,Object> map = constructParameters();
			if(requiredParamater()) {
				String adress = Config.API_ADDRESS+this._request.getRequest();
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
	
	protected void init() {
		this._keyAPI = Config.getApiKey();
		if(this._keyAPI == null || this._keyAPI.isEmpty()) {
			return;
		}
		if(this._request == null)
			return;
		this._init = true;
	}
	
	protected boolean requiredParamater() {
		switch (this._request) {
		case GET_BEATMAP_REQUEST:
			return this._keyAPI != null;
		case GET_USER:
			return (this._keyAPI != null && this._userID != null);
		default:
			return false;
		}
	}
	
	protected Map<String,Object> constructParameters(){
		Map<String,Object> map = new HashMap<String,Object>();
		switch (_request) {
		case GET_BEATMAP_REQUEST:
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
				map.put(RequestParametersEnum.API_KEY.getParamNaming(), this._userID);
			}
			if(this._mode != null && !this._mode.isEmpty()) {
				map.put(RequestParametersEnum.API_KEY.getParamNaming(), this._mode);
			}
			if(this._typeUserID != null && !this._typeUserID.isEmpty()) {
				map.put(RequestParametersEnum.API_KEY.getParamNaming(), this._typeUserID);
			}
			if(this._eventDays != null && !this._eventDays.isEmpty()) {
				map.put(RequestParametersEnum.API_KEY.getParamNaming(), this._eventDays);
			}
			return map;

		default:
			return null;
		}
		
	}
	
}

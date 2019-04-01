package com.tilundev.ocapi.external;

import java.sql.Date;
import java.util.Map;

import com.mashape.unirest.http.Unirest;
import com.tilundev.ocapi.external.parameters.BeatmapParametersEnum;
import com.tilundev.ocapi.internal.Config;
import com.tilundev.ocapi.internal.request.BeatmapRequestEnum;
import com.tilundev.ocapi.util.DateUtil;
import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;
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
	
	public BeatmapRequest() {
		// TODO Auto-generated constructor stub
	}
	
	
	// Public methods
	
	public BeatmapRequest getBeatmapRequest() {
		this.init(BeatmapRequestEnum.GET_BEATMAP_REQUEST);
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
		Unirest req = new Unirest();
		return this;
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

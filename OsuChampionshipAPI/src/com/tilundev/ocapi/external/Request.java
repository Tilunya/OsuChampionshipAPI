package com.tilundev.ocapi.external;

import java.util.HashMap;
import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.tilundev.ocapi.internal.Config;
import com.tilundev.ocapi.internal.request.RequestEnum;

public class Request {
	private String _keyAPI = ""; // Required

	private boolean _init = false;
	private RequestEnum _request;
	private JsonNode _body = null;
	
	
	
	public Request start(RequestEnum bre) {
		this.init(bre);
		Map<String,Object> map = constructParameters();
		String adress = Config.API_ADDRESS+_request.getRequest();
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
	
	/**
	 * TODO gèrer les exceptions + Gerer le Cast
	 * @return
	 */
	public Object getBody() {
		if(this._body == null) {
			return null;
		}
		else {
			if(this._body.isArray()) {
				return this._body.getArray();
			} else {
				return this._body.getObject();
			}
		}
	}
	
	protected void init(RequestEnum bre) {
		this._request = bre;
		this._keyAPI = Config.getApiKey();
		if(this._keyAPI == null || this._keyAPI.isEmpty()) {
			//TODO Handle Error;
			return;
		}
		this._init = true;
	}
	
	protected Map<String,Object> constructParameters(){
		Map<String,Object> map = new HashMap<String,Object>();
		return map;
	}
}

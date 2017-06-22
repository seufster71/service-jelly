package org.mangobutter.jelly.service;

import javax.inject.Inject;

import org.mangobutter.core.service.ServiceProcessor;
import org.mangobutter.core.utils.Request;
import org.mangobutter.core.utils.Response;
import org.mangobutter.jelly.ServiceJellyConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("PeanutSvcImpl")
public class PeanutSvcImpl implements ServiceProcessor, PeanutSvc {

	@Inject
	private ServiceJellyConfiguration properties;
	
	@Value("${jdbc.A.url}")
	String jdbcurl;
	
	@Override
	public void process(Request request, Response response) {
		String action = (String) request.getParams().get("action");
		switch (action) {
			case "LIST":
				this.list(request, response);
				break;
			case "ITEM":
				this.item(request, response);
				break;
			case "SAVE":
				this.save(request, response);
				break;
		}
		
	}
	
	@Override
	public void item(Request request, Response response) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(jdbcurl);
		sb.append(" || ");
		sb.append(properties.getUrl());
		sb.append(" || ");
		sb.append(properties.getUsername());
		
		response.getParams().put("status", sb.toString());
		
	}

	@Override
	public void list(Request request, Response response) {
		response.getParams().put("status", "A list remote");
		
	}

	@Override
	public void save(Request request, Response response) {
		response.getParams().put("status", "Save item remote");
		
	}

	

}

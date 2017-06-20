package org.mangobutter.jelly.service;

import org.mangobutter.core.service.ServiceProcessor;
import org.mangobutter.core.utils.Request;
import org.mangobutter.core.utils.Response;
import org.springframework.stereotype.Service;

@Service("PeanutSvcImpl")
public class PeanutSvcImpl implements ServiceProcessor, PeanutSvc {

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
		response.getParams().put("status", "A item remote");
		
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

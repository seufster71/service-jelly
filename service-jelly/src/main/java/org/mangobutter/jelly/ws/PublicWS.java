package org.mangobutter.jelly.ws;

import javax.inject.Inject;

import org.mangobutter.core.service.ServiceProcessor;
import org.mangobutter.core.utils.Request;
import org.mangobutter.core.utils.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("public/")
public class PublicWS {

	@Inject
	protected ApplicationContext context;
	
	@RequestMapping(value = "service", method = RequestMethod.POST)
	public Response service(@RequestBody Request request){
		Response response = new Response();
		
		String service = (String) request.getParams().get("service");
		String className = "";
		switch (service) {
			case "PEANUT_SVC":
				className = "PeanutSvcImpl";
				break;
		}
		ServiceProcessor processor = (ServiceProcessor) context.getBean(className);
		
		processor.process(request, response);
		
		return response;
	}
}

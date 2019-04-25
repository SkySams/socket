package com.websocket.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.websocket.service.WebSocketService;
import com.websocket.util.ApiReturnObject;
import com.websocket.util.ApiReturnUtil;

@Controller
@RequestMapping("/check")
public class WebSocket {
	
	@GetMapping("/socket/{cid}")
	public ModelAndView websocket(@PathVariable String cid) {
		ModelAndView mav = new ModelAndView("/index");
		mav.addObject("cid", cid);
		return mav;
	}

	@RequestMapping("/index")
	public String index(){
		return "/index";
	}
	
	@ResponseBody
	@RequestMapping("/socket/push/{cid}")
	public ApiReturnObject pushToWeb(@PathVariable String cid,String message) {  
		try {
			WebSocketService.sendInfo(message,cid);
		} catch (IOException e) {
			e.printStackTrace();
			return ApiReturnUtil.error(cid+"#"+e.getMessage());
		}  
		return ApiReturnUtil.success(cid);
	} 
	
	@RequestMapping("/test")
	public String thymaleaf(ModelMap map){
		map.put("name", "thymaleaf");
		return "thymeleaf";
	}

}

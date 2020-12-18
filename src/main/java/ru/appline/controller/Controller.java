package ru.appline.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.appline.logic.Compass;

@RestController
public class Controller {
	
	private static final Compass compass = new Compass();
	
	@PostMapping(value = "/setSides", consumes = "application/json")
	public void setSides(@RequestBody Map<String, String> sides) {
		sides.entrySet().forEach(side -> {
			int start = Integer.parseInt(side.getValue().split("-")[0]);
			int end = Integer.parseInt(side.getValue().split("-")[1]);
			
			if (start < end) {
				for (int i = start; i <= end && i <= 359; i++) {
					compass.setDegree(i, side.getKey());
				}
			} else {
				for (int i = start; i <= 359; i++) {
					compass.setDegree(i, side.getKey());
				}
				for (int i = 0; i <= end; i++) {
					compass.setDegree(i, side.getKey());
				}
			}
		});;
	}
	
	@GetMapping(value= "/getDegree", consumes = "application/json", produces = "application/json")
	public Map<String, String> getDegree(@RequestBody Map<String, Integer> json) {
		Map<String, String> request = new HashMap<String, String>();
		request.put("Side", compass.getDegree(json.get("Degree")));
		return request;
	}

}

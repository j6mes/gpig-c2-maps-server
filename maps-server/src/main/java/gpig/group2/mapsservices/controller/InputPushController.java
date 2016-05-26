package gpig.group2.mapsservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import gpig.group2.mapsservices.service.GisService;
import gpig.group2.model.sensor.StrandedPerson;
import gpig.group2.models.drone.status.DroneStatusMessage;

@Controller
@RequestMapping("/push")
public class InputPushController {

	@Autowired
	private GisService gisService;

	@RequestMapping(value = "/droneStatus", consumes = "application/xml", method = RequestMethod.POST)
	@ResponseBody
	public String pushDrone(@RequestBody DroneStatusMessage statusMsg) {

		gisService.addOrUpdateDrone(statusMsg.getIdX(), statusMsg.getPositionX(), statusMsg.getWaypointsX());
		return "Accepted";
	}

	@RequestMapping(value = "/strandedPerson", consumes = "application/xml", method = RequestMethod.POST)
	@ResponseBody
	public String pushDrone(@RequestBody StrandedPerson sp) {

		gisService.addStrandedPerson(sp);
		return "Accepted";
	}
}

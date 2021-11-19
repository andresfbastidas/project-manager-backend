package co.edu.usbcali.projectmanager.fcd.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.projectmanager.fcd.constant.FcdConstants;

@RestController
@CrossOrigin(origins = "${cross.origin}")
@RequestMapping(path = FcdConstants.PROJECT)
public class ProjectController {

}

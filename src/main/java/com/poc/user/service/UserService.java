package com.poc.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.poc.user.bean.ProjectMembership;
import com.poc.user.bean.RegUser;
import com.poc.user.bean.UnregUser;
import com.poc.user.utils.UserServiceUtils;

@Service
public class UserService {
	private Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserServiceUtils userServiceUtils;

	@Value("${external.app.service.base.url}")
	private String externalApiBaseURL;

	@Value("${external.app.service.registeredusers}")
	private String registeredusersUri;

	@Value("${external.app.service.unregisteredusers}")
	private String unregisteredusersUri;

	@Value("${external.app.service.projectmemberships}")
	private String projectmembershipsUri;

	public Collection<Object> findUsers() {
		log.info("-->findUsers");
		Collection<Object> response = new ArrayList<Object>();
		log.debug("externalApiBaseURL:{}, registeredusersUri:{},registeredusersUri:{}, projectmembershipsUri:{}",
				externalApiBaseURL, registeredusersUri, registeredusersUri, projectmembershipsUri);
		List<ProjectMembership> mems = userServiceUtils.getProjectMemberships(externalApiBaseURL,
				projectmembershipsUri);
		Collection<RegUser> regUsers = userServiceUtils.getAllRegisteredUsers(externalApiBaseURL, registeredusersUri);
		userServiceUtils.setProjectIdsForRegUsers(externalApiBaseURL, projectmembershipsUri, regUsers, mems);
		response.addAll(regUsers);

		Collection<UnregUser> unRegUsers = userServiceUtils.getAllUnRegisteredUsers(externalApiBaseURL,
				unregisteredusersUri);
		userServiceUtils.setProjectIdsForUnregUsers(externalApiBaseURL, projectmembershipsUri, unRegUsers, mems);
		response.addAll(unRegUsers);

		//log.debug("regUsers:{}", regUsers);
		log.info("<--findUsers");
		return response;
	}

}

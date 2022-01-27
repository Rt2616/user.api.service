package com.poc.user.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.poc.user.bean.ProjectMembership;
import com.poc.user.bean.RegUser;
import com.poc.user.bean.UnregUser;

@Component
public class UserServiceUtils {
	private Logger log = LoggerFactory.getLogger(UserServiceUtils.class);
	@Autowired
	private RestTemplate restTemplate;

	public List<RegUser> getAllRegisteredUsers(String baseURL, String uri) {
		log.info("--> getAllRegisteredUsers");
		List<RegUser> response = null;
		String fooResourceUrl = baseURL + uri;
		log.debug("fooResourceUrl:{}", fooResourceUrl);
		ResponseEntity<RegUser[]> res = restTemplate.getForEntity(fooResourceUrl, RegUser[].class);
		log.debug("API Response Code:{}", res.getStatusCode());
		if (res != null) {
			response = Arrays.asList(res.getBody());
		}
		//log.info("<-- getAllRegisteredUsers:{}", response);
		return response;
	}

	public List<UnregUser> getAllUnRegisteredUsers(String baseURL, String uri) {
		log.info("--> getAllUnRegisteredUsers");
		List<UnregUser> response = null;
		String fooResourceUrl = baseURL + uri;
		log.debug("fooResourceUrl:{}", fooResourceUrl);
		ResponseEntity<UnregUser[]> res = restTemplate.getForEntity(fooResourceUrl, UnregUser[].class);
		log.debug("API Response Code:{}", res.getStatusCode());
		if (res != null) {
			response = Arrays.asList(res.getBody());
		}
		//log.info("<-- getAllUnRegisteredUsers:{}", response);
		return response;
	}

	public List<ProjectMembership> getProjectMemberships(String baseURL, String uri) {
		log.info("--> getProjectMemberships");
		List<ProjectMembership> response = null;
		String fooResourceUrl = baseURL + uri;
		log.debug("fooResourceUrl:{}", fooResourceUrl);
		ResponseEntity<ProjectMembership[]> res = restTemplate.getForEntity(fooResourceUrl, ProjectMembership[].class);
		log.debug("API Response Code:{}", res.getStatusCode());
		if (res != null) {
			response = Arrays.asList(res.getBody());
		}
		//log.info("<-- getProjectMemberships:{}", response);
		return response;
	}

	public void setProjectIdsForRegUsers(String baseURL, String uri, Collection<RegUser> regUsers,
			List<ProjectMembership> mems) {
		List<String> projMemIds = null;
		if (mems != null && !mems.isEmpty()) {
			for (RegUser regUser : regUsers) {
				projMemIds = getProjMemIds(mems, regUser.getId());
				regUser.setProjectIds(projMemIds);

			}
		}

	}

	private List<String> getProjMemIds(List<ProjectMembership> mems, String id) {
		List<String> result = new ArrayList<String>();
		for (ProjectMembership memb : mems) {
			if (memb.getUserId().equals(id)) {
				result.add(memb.getProjectId());
			}
		}
		return result;
	}

	public void setProjectIdsForUnregUsers(String baseURL, String uri, Collection<UnregUser> unRegUsers,
			List<ProjectMembership> mems) {
		List<String> projMemIds = null;
		if (mems != null && !mems.isEmpty()) {
			for (UnregUser unregUser : unRegUsers) {
				projMemIds = getProjMemIds(mems, unregUser.getId());
				unregUser.setProjectIds(projMemIds);
			}
		}

	}

}

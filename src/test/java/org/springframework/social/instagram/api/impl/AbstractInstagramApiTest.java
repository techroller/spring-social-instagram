package org.springframework.social.instagram.api.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.instagram.api.PagedMediaList;
import org.springframework.social.test.client.MockRestServiceServer;
import org.springframework.social.test.client.RequestMatcher;
import org.springframework.social.test.client.ResponseCreator;

public abstract class AbstractInstagramApiTest {

	public InstagramTemplate instagram;
	
	protected MockRestServiceServer mockServer;

	protected HttpHeaders responseHeaders;
	
	@Before
	public void setup() {
		instagram = new InstagramTemplate("CLIENT_ID", "ACCESS_TOKEN");
		mockServer = MockRestServiceServer.createServer(instagram.getRestTemplate());
		responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
	}
	
	protected void assertPagedResults(PagedMediaList media) {
		assertEquals(media.getPagination().getNextMaxId(), 5675287);
		assertEquals(media.getPagination().getNextMinId(), 5689748);
		assertEquals(media.getPagination().getNextUrl(), "https://api.instagram.com/v1/tags/cats/media/recent/?access_token=ACCESS_TOKEN&max_id=5675287");
		assertTrue(media.getList().size() > 0);
	}
	
	protected RequestMatcher requestTo(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	protected RequestMatcher method(HttpMethod get) {
		// TODO Auto-generated method stub
		return null;
	}

	protected ResponseCreator withResponse(ClassPathResource classPathResource,
			HttpHeaders responseHeaders) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

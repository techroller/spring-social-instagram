package org.springframework.social.instagram.api.impl;

import static org.hamcrest.core.StringContains.*;
import static org.junit.Assert.*;

import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.instagram.api.PagedMediaList;
import org.springframework.social.test.client.MockClientHttpRequest;
import org.springframework.social.test.client.MockRestServiceServer;

public abstract class AbstractInstagramApiTest {

	protected AbstractInstagramApiTest() {
		
	}
	
	
	public InstagramTemplate instagram;
	
	protected MockRestServiceServer mockServer;

	protected HttpHeaders responseHeaders;
	
	protected MockClientHttpRequest mockRequest;
	
	@Before
	public void setup() {
		instagram = new InstagramTemplate("CLIENT_ID", "ACCESS_TOKEN");
		mockServer = MockRestServiceServer.createServer(instagram.getRestTemplate());
		responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockRequest = new MockClientHttpRequest();
	}
	
	protected void assertPagedResults(PagedMediaList media) {
		assertEquals(media.getPagination().getNextMaxId(), 5675287);
		assertEquals(media.getPagination().getNextMinId(), 5689748);
		assertEquals(media.getPagination().getNextUrl(), "https://api.instagram.com/v1/tags/cats/media/recent/?access_token=ACCESS_TOKEN&max_id=5675287");
		assertTrue(media.getList().size() > 0);
	}	
}

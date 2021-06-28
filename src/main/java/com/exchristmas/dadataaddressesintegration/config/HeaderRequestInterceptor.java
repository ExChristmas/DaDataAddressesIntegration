package com.exchristmas.dadataaddressesintegration.config;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;

import java.io.IOException;

@RequiredArgsConstructor
public
class HeaderRequestInterceptor implements ClientHttpRequestInterceptor {

	@NonNull private final String headerName;
	@NonNull private final String headerValue;

	@NonNull
	@Override
	public ClientHttpResponse intercept(@NonNull final HttpRequest request, @NonNull final byte[] body,
	                                    @NonNull final ClientHttpRequestExecution execution) throws IOException {
		request.getHeaders().set(headerName, headerValue);
		return execution.execute(request, body);
	}
}

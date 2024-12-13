package com.lecoingameover.belecoingameover.Security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ResponseHeadersFilterTest {

    private ResponseHeadersFilter responseHeadersFilter;

    @Mock
    private ServerWebExchange serverWebExchange;

    @Mock
    private WebFilterChain webFilterChain;

    @Mock
    private ServerHttpResponse serverHttpResponse;

    @Mock
    private HttpHeaders httpHeaders;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        responseHeadersFilter = new ResponseHeadersFilter();

        when(serverWebExchange.getResponse()).thenReturn(serverHttpResponse);
        when(serverHttpResponse.getHeaders()).thenReturn(httpHeaders);
        when(webFilterChain.filter(serverWebExchange)).thenReturn(Mono.empty());
    }

    @Test
    void filter_shouldSetResponseHeadersAndContinueChain() {
        responseHeadersFilter.filter(serverWebExchange, webFilterChain).block();

        // Verify headers are set correctly
        verify(httpHeaders).set("X-XSS-Protection", "0");
        verify(httpHeaders).set("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
        verify(httpHeaders).set("X-Frame-Options", "deny");
        verify(httpHeaders).set("X-Content-Type-Options", "nosniff");
        verify(httpHeaders).set("Content-Security-Policy", "default-src 'self'; frame-ancestors 'none';");
        verify(httpHeaders).set("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
        verify(httpHeaders).setPragma("no-cache");
        verify(httpHeaders).set("Expires", "0");

        // Verify the filter chain is executed
        verify(webFilterChain).filter(serverWebExchange);
    }

    @Test
    void constructor_shouldInstantiateResponseHeadersFilter() {
        ResponseHeadersFilter filter = new ResponseHeadersFilter();
        assertEquals(ResponseHeadersFilter.class, filter.getClass());
    }
}

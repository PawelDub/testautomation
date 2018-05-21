package com.jsystems.mocking;

import com.google.common.net.MediaType;
import com.sun.xml.internal.ws.wsdl.writer.document.soap.BodyType;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.model.Body;

import java.util.*;

import static com.google.common.net.MediaType.ANY_APPLICATION_TYPE;
import static org.mockserver.model.Header.header;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class MockSamplers {

    static Map<String, List<String>> stringQueryParameters = new LinkedHashMap<>();
    static MockServerClient mockServerClient = new MockServerClient("localhost", 9988);

    public static void mockServerExpectationTestApi() {
        stringQueryParameters.put("cartId", Arrays.asList("055CA455-1DF7-45BB-8535-4F83E7266092"));

        mockServerClient
                .when(
                        request()
                                .withMethod("GET")
                                .withPath("/test/api")
                                .withQueryStringParameters(stringQueryParameters)
                                .withHeaders(
                                        header("Content-Type", "application/json"),
                                        header("Authorization", "api,1234567890"))
                )
                .respond(
                        response()
                                .withHeader(header("content-type", "application/json"))
                                .withBody("{\n\"name\":\"some_response_body\",\n\"name\":\"some_response_body\",\n\"age\": 56}")
                );
    }
}

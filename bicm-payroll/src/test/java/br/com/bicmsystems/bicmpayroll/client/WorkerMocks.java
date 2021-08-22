package br.com.bicmsystems.bicmpayroll.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.MediaType;

import java.io.IOException;

import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;

public class WorkerMocks {

    public static void setupMockWorkerResponse(WireMockServer mockService,
                                               String testUrl,
                                               Integer httpStatus,
                                               String payloadResponse) throws IOException {

        mockService.stubFor(WireMock.get(WireMock.urlEqualTo(testUrl))
            .willReturn(
                WireMock.aResponse()
                    .withStatus(httpStatus)
                    .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                    .withBody(
                        copyToString(
                            WorkerMocks.class.getClassLoader().getResourceAsStream(payloadResponse),
                            defaultCharset()
                        )
                    )
            )
        );
    }

}

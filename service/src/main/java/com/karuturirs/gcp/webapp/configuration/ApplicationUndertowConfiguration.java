package com.karuturirs.gcp.webapp.configuration;

import io.undertow.server.DefaultByteBufferPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xnio.Options;

import io.undertow.Undertow;
import io.undertow.UndertowOptions;

@Configuration
public class ApplicationUndertowConfiguration {


    @Value("${undertow.channel.max.concurent.request.connection:100}")
    private Integer MAX_CONCURRENT_REQUESTS_PER_CONNECTION;
    @Value("${undertow.socket.tcpNodelay:true}")
    private boolean TCP_NODELAY;
    @Value("${undertow.accesslog.responseTime.enable:false}")
    private boolean RECORD_REQUEST_START_TIME;
    @Value("${undertow.server.maxHeaderSize:8129}")
    private Integer MAX_HEADER_SIZE;
    @Value("${undertow.allow.unescaped.characters.in.url:true}")
    private boolean ALLOW_UNESCAPED_CHARACTERS_IN_URL;
    @Value("${undertow.decode.url:true}")
    private boolean DECODE_URL;


    @Bean
    public UndertowServletWebServerFactory embeddedServletContainerFactory() {
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {

            public void customize(Undertow.Builder builder) {
                /**
                 * If this is true then Undertow will record the request start time, to allow
                 * for request time to be logged
                 *
                 * This has a small but measurable performance impact
                 *
                 * default is false
                 */
                builder.setServerOption(UndertowOptions.RECORD_REQUEST_START_TIME, RECORD_REQUEST_START_TIME);


                /**
                 * If this is true then a Date header will be added to all responses. The HTTP
                 * spec says this header should be added to all responses, unless the server
                 * does not have an accurate clock.
                 * <p>
                 * Defaults to true
                 */
                builder.setServerOption(UndertowOptions.ALWAYS_SET_DATE, true);

                /**
                 * Max Header size for incoming request
                 * <p>
                 * Defaults to 8129
                 */
                builder.setServerOption(UndertowOptions.MAX_HEADER_SIZE, MAX_HEADER_SIZE);
                /**
                 * The maximum number of concurrent requests that will be processed at a time.
                 * This differs from max concurrent streams in that it is not sent to the remote
                 * client.
                 *
                 * If the number of pending requests exceeds this number then requests will be
                 * queued, the difference between this and max concurrent streams determines the
                 * maximum number of requests that will be queued.
                 *
                 * Queued requests are processed by a priority queue, rather than a FIFO based
                 * queue, using HTTP2 stream priority.
                 *
                 * If this number is smaller than or equal to zero then max concurrent streams
                 * determines the maximum number of streams that can be run.
                 *
                 *
                 */
                if (MAX_CONCURRENT_REQUESTS_PER_CONNECTION > 0)
                    builder.setServerOption(UndertowOptions.MAX_CONCURRENT_REQUESTS_PER_CONNECTION,
                            MAX_CONCURRENT_REQUESTS_PER_CONNECTION);
                /**
                 * If this is true then HTTP/1.1 requests will be failed if no host header is
                 * present.
                 */

                builder.setServerOption(UndertowOptions.ALLOW_UNESCAPED_CHARACTERS_IN_URL,
                        ALLOW_UNESCAPED_CHARACTERS_IN_URL);
                builder.setSocketOption(Options.TCP_NODELAY, TCP_NODELAY);
                builder.setSocketOption(Options.WORKER_NAME, "XNIO-SM");
                builder.setServerOption(UndertowOptions.DECODE_URL, DECODE_URL);
                //builder.setByteBufferPool(new DefaultByteBufferPool(false, 1024));
            }

        });

        return factory;
    }
}

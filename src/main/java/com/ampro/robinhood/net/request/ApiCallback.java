package com.ampro.robinhood.net.request;

import com.ampro.robinhood.RobinhoodApi;
import com.ampro.robinhood.endpoint.ApiElement;
import com.ampro.robinhood.net.ApiMethod;
import com.google.gson.Gson;
import io.github.openunirest.http.HttpResponse;
import io.github.openunirest.http.JsonNode;
import io.github.openunirest.http.async.Callback;
import io.github.openunirest.http.exceptions.UnirestException;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.Future;

public class ApiCallback<E extends ApiElement> implements Callback<JsonNode> {

    private final Gson gson = new Gson();

    /** The value returned by the async call */
    protected E value;

    protected ApiMethod method;

    public ApiCallback(ApiMethod method) {
        this.method = method;
    }

    private <E> E deserialize(HttpResponse<JsonNode> response) {

        try {
            if (!Objects.equals(response.getStatusText(), "OK")
                    || method.getReturnType() == Void.TYPE) {
                this.value = null;
                return null;
            }
            String body = IOUtils.toString(response.getRawBody(),
                                           StandardCharsets.UTF_8.name());
            value = gson.fromJson(body, method.getReturnType());
        } catch (UnirestException ex) {
            System.err.println("[RobinhoodApi] Failed to communicate with endpoint");
            RobinhoodApi.log.throwing(this.getClass().getName(), "completed", ex);
        } catch (IOException ex) {
            System.err.println("[RobinhoodApi] Failed to parse response body");
            RobinhoodApi.log.throwing(this.getClass().getName(), "completed", ex);
        }
        return value;
    }

    @Override
    public void completed(HttpResponse<JsonNode> response) {
        try {
            if (!Objects.equals(response.getStatusText(), "OK")
                    || method.getReturnType() == Void.TYPE) {
                this.value = null;
                return;
            }
            String body = IOUtils.toString(response.getRawBody(),
                                           StandardCharsets.UTF_8.name());
            value = gson.fromJson(body, method.getReturnType());
        } catch (UnirestException ex) {
            System.err.println("[RobinhoodApi] Failed to communicate with endpoint");
            RobinhoodApi.log.throwing(this.getClass().getName(), "completed", ex);
        } catch (IOException ex) {
            System.err.println("[RobinhoodApi] Failed to parse response body");
            RobinhoodApi.log.throwing(this.getClass().getName(), "completed", ex);
        }
    }

    public Future<E> getFuture() {

        return this.value;
    }

}

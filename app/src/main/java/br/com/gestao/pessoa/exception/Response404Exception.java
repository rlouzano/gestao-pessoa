package br.com.gestao.pessoa.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientResponseException;

import java.nio.charset.Charset;

public class Response404Exception extends RestClientResponseException {

    private static final long serialVersionUID = 1L;

    public Response404Exception(final String msg) {
        super(msg, HttpStatus.NOT_FOUND.value(), msg, null, null, null);
    }

    public Response404Exception(final String message, final int statusCode, final String statusText, final HttpHeaders headers,
                                final byte[] responseBody, final Charset responseCharset) {
        super(message, statusCode, statusText, headers, responseBody, responseCharset);
    }
}

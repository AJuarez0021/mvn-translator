package com.work.translator.client;

import com.google.gson.Gson;
import com.work.translator.dto.LanguagesDTO;
import com.work.translator.dto.RequestTranslatorDTO;
import com.work.translator.dto.ResponseTranslatorDTO;
import com.work.translator.util.Languages;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author linux
 */
public class FreeTranslate {

    private static final String URL_TRANSLATE = "https://translate.fedilab.app/translate";

    public List<LanguagesDTO> getLanguages() {
        Languages[] langs = Languages.values();
        List<LanguagesDTO> list = new ArrayList<>();
        for (Languages lang : langs) {
            list.add(new LanguagesDTO(lang.getCode(), lang.toString()));
        }
        return list;
    }

    public ResponseTranslatorDTO translate(LanguagesDTO from, LanguagesDTO to, String text) throws IOException, InterruptedException {
        if (to.getCode().equals(Languages.NONE.getCode()) || from.getCode().equals(to.getCode())) {
            return new ResponseTranslatorDTO(text);
        }

        return translate(from.getCode(), to.getCode(), text);
    }

    public ResponseTranslatorDTO translate(LanguagesDTO to, String text) throws IOException, InterruptedException {
        if (to.getCode().equals(Languages.NONE.getCode())) {
            return new ResponseTranslatorDTO(text);
        }

        return translate("auto", to.getCode(), text);
    }

    private ResponseTranslatorDTO translate(String source, String target, String text) throws IOException, InterruptedException {
        RequestTranslatorDTO req = new RequestTranslatorDTO();
        req.setAlternatives(3);
        req.setFormat("text");
        req.setSource(source);
        req.setTarget(target);
        req.setQ(text);
        req.setApi_key("");

        Gson gson = new Gson();
        String body = gson.toJson(req);

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(URL_TRANSLATE))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("Content-Type", "application/json")
                .timeout(Duration.ofSeconds(50))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
        String response = postResponse.body();
        int status = postResponse.statusCode();
        if (!isOk(status)) {
            throw new RuntimeException("Bad Translator: " + status + "-" + response);
        }
        return gson.fromJson(response, ResponseTranslatorDTO.class);
    }

    private boolean isOk(int status) {
        return status >= 200 && status <= 299;
    }
}

package com.work.translator;

import com.work.translator.client.FreeTranslate;
import com.work.translator.dto.LanguagesDTO;
import com.work.translator.dto.ResponseTranslatorDTO;
import com.work.translator.util.Languages;
import java.io.IOException;
import java.util.Optional;

/**
 *
 * @author linux
 */
public class Main {

    public static void main(String[] args) {
        try {
            FreeTranslate ft = new FreeTranslate();
            Optional<LanguagesDTO> es = ft.getLanguages().stream()
                    .filter(t -> t.getCode().equals(Languages.SPANISH.getCode())).findFirst();
            Optional<LanguagesDTO> en = ft.getLanguages()
                    .stream().filter(t -> t.getCode().equals(Languages.ENGLISH.getCode())).findFirst();

            ResponseTranslatorDTO response = ft.translate(es.get(), en.get(), "Saludos cordiales");
            System.out.println("Response: " + response.getTranslatedText());
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace(System.err);
        }
    }
}

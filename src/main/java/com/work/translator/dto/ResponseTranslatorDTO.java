/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.work.translator.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author linux
 */
public class ResponseTranslatorDTO {

    private String translatedText;
    private List<String> alternatives;

    public ResponseTranslatorDTO() {
        this.translatedText = "";
        this.alternatives = new ArrayList<>();
    }

    public ResponseTranslatorDTO(String translatedText) {
        this.translatedText = translatedText;
        this.alternatives = new ArrayList<>();
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public List<String> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<String> alternatives) {
        this.alternatives = alternatives;
    }

}

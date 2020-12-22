package com.example.azuretranslation;

import java.util.Map;

public class LanguagesResponse {
    Map<String, Language> translation;

    @Override
    public String toString() {

        // перечень языков объединяем в одну строку
        String  languages = "";
        for (String l: translation.keySet()) {
            languages += l + ":";
        }
        return languages;
    }
}

/* формат ответа от API
{"translation":
  {
   "af":{"name":"Африкаанс","nativeName":"Afrikaans","dir":"ltr"},
   "ar":{"name":"Арабский","nativeName":"العربية","dir":"rtl"},
   "as":{"name":"Assamese","nativeName":"Assamese","dir":"ltr"},
   ..
  }
 */

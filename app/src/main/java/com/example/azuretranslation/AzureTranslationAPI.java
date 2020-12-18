package com.example.azuretranslation;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface AzureTranslationAPI {
    String API_URL = "https://api.cognitive.microsofttranslator.com";
    String key = "1db01788ad86488d90d573a7fe502c11 ";

    @GET("/languages?api-version=3.0&scope=translation")
    Call<Translation> getLanguages();

}

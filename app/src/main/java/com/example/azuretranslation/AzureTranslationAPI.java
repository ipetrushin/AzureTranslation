package com.example.azuretranslation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AzureTranslationAPI {
    String API_URL = "https://api.cognitive.microsofttranslator.com";
    // TODO: рекомендуется использовать свой ключ, чтобы получить доп. балл
    String key = "feaf0689c4446ab99c7e50a874b7ab9 ключ попросить у преподавателя"; //
    // TODO: регион указать отдельной переменной

    // запрос языков работает без ключа
    @GET("/languages?api-version=3.0&scope=translation")
    Call<LanguagesResponse> getLanguages();

    @POST("/translate?api-version=3.0&to=es") // путь к API
    @Headers({
            "Content-Type: application/json",
            // TODO: указать ключ и регион
    })

    // TranslatedText - формат ответа от сервера
    // Тип ответа - TranslatedText, действие - translate, содержание запроса - пустое (нет полей формы)
    // TODO: с помощью аннотации @Body передать поля запроса к API (текст для перевода)
    // см. примеры https://square.github.io/retrofit/
    Call<TranslatedText> translate();
}

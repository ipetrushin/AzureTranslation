package com.example.azuretranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // Экземпляр библиотеки и интерфейса можно использовать для всех обращений к сервису
    // формируем экземпляр библиотеки
    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create()) // ответ от сервера в виде строки
            .baseUrl(AzureTranslationAPI.API_URL) // адрес API сервера
            .build();

    AzureTranslationAPI api = retrofit.create(AzureTranslationAPI.class); // описываем, какие функции реализованы

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<Translation> call = api.getLanguages(); // создаём объект-вызов
        call.enqueue(new LanguagesCallback());

    }

    class LanguagesCallback implements Callback<Translation> {

        @Override
        public void onResponse(Call<Translation> call, Response<Translation> response) {
            if (response.isSuccessful()) {
                // TODO: response.body() содержит строку-токен, сохраните его для дальнейшего использования
                Log.d("mytag", "response: " + response.body());
            } else
                Log.d("mytag", "error " + response.code());
        }

        @Override
        public void onFailure(Call<Translation> call, Throwable t) {
            // TODO: выводить Toast в случае ошибки
            Log.d("mytag", "error " + t.getLocalizedMessage());

        }
    }
}

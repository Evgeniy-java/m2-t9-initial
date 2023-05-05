package ru.yandex.practicum.exceptions;

public class ErrorResponse {
    //названеи ошибки
    private String error;
    //подробное описание
    private String description;

    public ErrorResponse(String error, String description){
        this.error = error;
        this.description = description;
    }

    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }
}

package ru.yandex.practicum.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.yandex.practicum.exceptions.ErrorResponse;

import java.util.Map;

@RestController
@RequestMapping("/cats")
public class CatsInteractionController {
    private int happiness = 0;

    @GetMapping("/converse")
    public Map<String, String> converse() {
        happiness++;
        return Map.of("talk", "Мяу");
    }

    @GetMapping("/pet")
    public Map<String, String> pet(@RequestParam(required = false) final Integer count) {
        happiness += count;
        return Map.of("talk", "Муррр. ".repeat(count));
    }

    @GetMapping("/happiness")
    public Map<String, Integer> happiness() {
        return Map.of("happiness", happiness);
    }

    //перечисление обрабатываемых исключений
    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    //код ответа
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    // в аргументах указывается родительское исключение
    public ErrorResponse handleIncorrectCount(final RuntimeException e) {
        return new ErrorResponse(
                "Ошибка с параметром count.", e.getMessage()
        );
    }

    @GetMapping("/feed")
    public Map<String, Integer> feed() {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "Метод /feed ещё не реализован.");
    }
}
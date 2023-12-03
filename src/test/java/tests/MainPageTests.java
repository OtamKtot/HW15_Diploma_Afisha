package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageObjects.MainPage;

import javax.swing.*;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@DisplayName("Тест главной страницы Яндекс.Афиши")
@Tag("mainpage")
public class MainPageTests extends BaseTest {
    MainPage mainPage = new MainPage();

    @DisplayName("Проверка смены города")
    @Tag("mainpage")
    @Test
    void cityChangeTest () {
        step("Открываем страницу Яндекс.Афиши", () -> {
            mainPage.openPage();
        });

        step("Меняем город", () -> {
            mainPage.selectCity();
        });

    }

    @DisplayName("Проверка поиска")
    @Tag("mainpage")
    @Test
    void searchActionTest () {
        step("Открываем страницу Яндекс.Афиши", () -> {
            mainPage.openPage();
        });

        step("Вводим запрос в поле поиска", () -> {
            mainPage.searchAction();
        });
    }

    @DisplayName("Проверка перехода на страницу Кино")
    @Tag("mainpage")
    @Test
    void navigationToCinemaPage () {
        step("Открываем страницу Яндекс.Афиши", () -> {
            mainPage.openPage();
        });

        step("Кликаем кнопку навигации на вкладку Кино", () -> {
            mainPage.cinema();
        });
    }

    @DisplayName("Проверка перехода на страницу Театр")
    @Tag("mainpage")
    @Test
    void navigationToTheatre () {
        step("Открываем страницу Яндекс.Афиши", () -> {
            mainPage.openPage();
        });

        step("Кликаем кнопку навигации на вкладку Театр", () -> {
            mainPage.theatre();
        });
    }

    @DisplayName("Проверка добавления мероприятия в Избранное")
    @Tag("mainpage")
    @Test
    void likeEvent() {
        step("Открываем страницу Яндекс.Афиши", () -> {
            mainPage.openPage();
        });

        step("Логинимся под кредами тестового пользователя", () -> {
            mainPage.loginProcess();
        });

        step("Ставим лайк и проверям отображение карточки мероприятия в избранном", () -> {
            mainPage.like();
        });
    }
}
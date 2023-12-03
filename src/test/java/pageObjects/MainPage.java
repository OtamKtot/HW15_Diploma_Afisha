package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private SelenideElement
            citySelector = $("[data-testid='header-city-button']"),
            cityInputPopup = $("[data-testid='city-popup-input']"),
            cityPopupResult = $("[data-testid='city-popup__list-item_0']"),
            afishaInTown = $(".rubric-header__title"),
            searchBox = $("#SearchInputComponent"),
            searchBoxResult = $(".search-page__items"),
            cinemaPage = $("[data-testid='PageHeaderNavigation/Item/Кино']"),
            cinemaCheck = $("[data-testid='title-with-more-link__title']"),
            theatrePage = $("[data-testid='PageHeaderNavigation/Item/Театр']"),
            theatreCheck = $("[data-testid='title-with-more-link__title']"),
            likeButton = $("[data-testid='favorite-button']"),
            myTickets = $("[data-testid='header-profile-link']"),
            myLikes = $("[data-testid='chip2']"),
            myLikesResult = $(".content-profile__inner"),
            loginButton = $("[data-testid='header-login-link']"),
            loginInput = $("#passp-field-login"),
            enterButton = $(".Button2-Text"),
            passwordInput = $("#passp-field-passwd"),
            submitButton = $("#passp:sign-in");


    public MainPage openPage() {
        open("https://afisha.yandex.ru/moscow");
        return this;
    }

    public MainPage selectCity() {
        citySelector.click();
        cityInputPopup.sendKeys("Надым");
        cityPopupResult.click();
        afishaInTown.shouldHave(Condition.text("Афиша событий в Надыме"));
        return this;
    }

    public MainPage searchAction() {
        searchBox.click();
        searchBox.sendKeys("Мумий Тролль");
        searchBox.pressEnter();
        searchBoxResult.shouldHave(Condition.text("Мумий Тролль"));
        return this;
    }

    public MainPage cinema() {
        cinemaPage.click();
        cinemaCheck.shouldHave(Condition.text("Кино в Москве"));
        return this;
    }

    public MainPage theatre() {
        theatrePage.click();
        theatreCheck.shouldHave(Condition.text("Репертуар театров в Москве"));
        return this;
    }

    public MainPage like() {
        cinemaPage.click();
        likeButton.click();
        myTickets.click();
        myLikes.click();
        myLikesResult.shouldNotBe(Condition.empty);
        return this;
    }

    public MainPage loginProcess() {
        loginButton.click();
        loginInput.sendKeys("mazown");
        loginInput.pressEnter();
        passwordInput.sendKeys("Blacktest88!");
        passwordInput.pressEnter();
        return this;
    }
}
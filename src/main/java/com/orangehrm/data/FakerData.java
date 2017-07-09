package com.orangehrm.data;

import com.github.javafaker.Faker;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Serhiy on 7/9/17.
 */
public class FakerData {

    Faker faker = new Faker();

    @Step("getFieldName")
    public String getNameFaker() {
        String name = faker.name().fullName();
        return name;

    }

    @Step("getEmailField")
    public String getEmailFaker() {
        String email = faker.internet().emailAddress();
        return email;

    }

    @Step("getWebSite")
    public String getWebSiteFeker() {
        String webSite = faker.internet().url();
        return webSite;

    }

    @Step("getPassword")
    public String getPasswordFaker() {
        String comment = faker.internet().password();
        return comment;
    }

}



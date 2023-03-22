<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
<div align="center">
<h2 align="center">Yandex Praktikum (QA Java) REST Assured Allure Test</h2>
  <p align="center">
   
 <br /> 
    <br />
    <a href="https://github.com/NickoT88/REST_Assured_Allure_Test"><strong>Explore the docs</strong></a>
    <br />
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## About The Project

**Задание проекта:** Тебе предстоит протестировать API учебного сервиса <a href="hhttp://qa-scooter.praktikum-services.ru">
Яндекс.Самокат</a>. Его документация: <a href="https://qa-scooter.praktikum-services.ru/docs/">
qa-scooter.praktikum-services.ru/docs/</a>

**Что нужно сделать**

Проверь, что ручки корректно работают и выдают нужные ошибки.

**Создание курьера**

Проверь:

- курьера можно создать;
- нельзя создать двух одинаковых курьеров;
- чтобы создать курьера, нужно передать в ручку все обязательные поля;
- запрос возвращает правильный код ответа;
- успешный запрос возвращает ok: true;
- если одного из полей нет, запрос возвращает ошибку;
- если создать пользователя с логином, который уже есть, возвращается ошибка.

**Логин курьера**

Проверь:

- курьер может авторизоваться;
- для авторизации нужно передать все обязательные поля;
- система вернёт ошибку, если неправильно указать логин или пароль;
- если какого-то поля нет, запрос возвращает ошибку;
- если авторизоваться под несуществующим пользователем, запрос возвращает ошибку;
- успешный запрос возвращает id.

**Переход в личный кабинет**

Проверь, что когда создаёшь заказ:

- можно указать один из цветов — BLACK или GREY;
- можно указать оба цвета;
- можно совсем не указывать цвет;
- тело ответа содержит track.
- чтобы протестировать создание заказа, нужно использовать параметризацию.

**Список заказов**

- Проверь, что в тело ответа возвращается список заказов.

**Отчёт Allure**

- Сгенерируй его и запушь в репозиторий.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

* <a href="https://www.java.com/ru/">Java 11</a>
* <a href="https://junit.org/junit4/">Junit 4</a>
* <a href="https://rest-assured.io/">REST Assured</a>
* <a href="https://github.com/allure-framework/">Allure Framework</a>
* <a href="https://mvnrepository.com/artifact/com.google.code.gson/gson">Gson</a>

Откройте проект в IntelliJ IDEA.
В терминале введите команду mvn clean test.

<p align="right">(<a href="#readme-top">back to top</a>)</p>
<!-- CONTACT -->

## Contact

Николай Токарев - [@tokarevnickolay](https://t.me/tokarevnickolay) - Tibibo88@yandex.ru

Project Link: [https://github.com/NickoT88/REST_Assured_Allure_Test](https://github.com/NickoT88/REST_Assured_Allure_Test)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

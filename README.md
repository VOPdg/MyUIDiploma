# Автоматизация тестирования заказа билета на сайте https://abo.bvg.de/de/

## :link: <a target="_blank" href="https://abo.bvg.de/de/">bvg.de - BVG Abo online abschließen | BVG</a>

<p align="center">
<img title="Wiki img" src="images/picture/download.png">
</p>

## :page_with_curl: Содержание:

- <a href="#computer-Технологии-и-инструменты">Технологии и инструменты</a>
- <a href="#robot-сборки-в-Jenkins">Сборки в Jenkins</a>
- <a href="#keyboard-запуск-из-терминала">Запуск из терминала</a>
- <a href="#bar_chart-allure-отчет">Allure отчет</a>
- <a href="#robot-отчет-в-telegram">Отчет в Telegram</a>
- <a href="#film_projector-видео-пример-прохождения-тестов">Видео пример прохождения тестов</a>

## :computer: Технологии и инструменты

<p align="left"> 
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

## :keyboard: Запуск из терминала

Локальный запуск всех тестов:

```
gradle clean abotests
```

Удаленный запуск всех тестов:

```
gradle clean
abotests
-Dbrowser=${BROWSER}
-DanyText="${ANY_TEXT}"
-Dsize="${SIZE}"
-Dversion="${VERSION}"
```

## :robot: Сборки в Jenkins

### <a target="_blank" href="https://jenkins.autotests.cloud/job/qa_guru_Jenkinsjob_MyUIDiploma/">Параметризированная сборка в Jenkins со всеми тестами</a>

<p align="center">
<img title="Jenkins Job Run with parameters" src="images/screenshots/Screenshot 2022-05-29 at 23.52.25.png">
</p>


<p align="center">
<img title="Jenkins Dashboard" src="images/screenshots/Screenshot 2022-05-29 at 23.53.10.png">
</p>

## :bar_chart: Allure отчет

- ### Главный экран отчета

<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/Screenshot 2022-05-29 at 23.53.37.png">
</p>

- ### Страница с проведенными тестами

<p align="center">
<img title="Allure Test Page" src="images/screenshots/Screenshot 2022-05-29 at 23.54.00.png">
</p>

## :robot: Отчет в Telegram

- ### Telegram notification message (all results)

<p align="center">
<img title="Telegram notification message (all results)" src="images/screenshots/Screenshot 2022-05-29 at 23.54.27.png">
</p>

## :film_projector: Видео пример прохождения тестов

> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Selenoid Video" src="images/gif/ezgif.com-gif-maker.gif">
</p>

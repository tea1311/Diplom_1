# Diplom_1
Юнит-тесты для учебного проекта Stellar Burgers.

В проекте реализованы проверки:
* Установки булочек
* Добавления ингредиентов
* Удаления ингредиентов
* Перемещения ингредиентов
* Расчета стоимости бургера
* Генерации чеков

## Структура проекта

```Diplom_1/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   └── java/
│   │        └── praktikum/
│   │                ├── Bun.java
│   │                ├── Burger.java
│   │                ├── Database.java
│   │                ├── Ingredient.java
│   │                ├── IngredientType.java
│   │                ├── Praktikum.java
│   └── test/
│       └── java/
│           └── praktikum/
                    ├── BurgerBaseTest.java
                    ├── BurgerPriceTest.java
                    ├── BurgerTest.java

```
## Технологии
* Java 11
* Maven
* JUnit 4
* Mockito
* Jacoco

## Настройка среды
Клонировать репозиторий: https://github.com/tea1311/Diplom_1 
Импортировать проект в IntelliJ IDEA. Убедиться, что установлен JDK 11 
Maven подтянет зависимости автоматически при открытии проекта.

## Запуск тестов
```bash
  mvn clean test
```
## Отчет Jacoco
Для оценки покрытия тестами используется инструмент Jacoco
``` bash 
  mvn verify
```
Отчет доступен по пути target/site/jacoco/index.html
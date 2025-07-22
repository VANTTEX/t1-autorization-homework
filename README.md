Запуск:

```
docker-compose up -d
```

Эндпоинты можно посмотреть на: http://localhost:8080/swagger-ui/index.html

Тестирование:

Неавторизированный пользьзователь не может зайти на http://localhost:8080/example
(403 ошибка)

Регистрация: Отправляем POST запрос на http://localhost:8080/auth/sign-up
```
{
"username": "user",
"email": "user@user.user",
"password": "qwerty"
}
```
В ответе на запрос видим токен, новый пользователь добавляется в БД

Авторизация: Регистрация: Отправляем POST запрос на http://localhost:8080/auth/sign-in
```
{
"username": "user",
"password": "qwerty"
}
```
В ответе на запрос видим токен. Его нужно скопировать

В Postman во вкладке Authorization выбрать Bearer token и вставить скопированный раннее токен

Теперь снова посылаем GET запрос на http://localhost:8080/example

В ответе видим: Привет, Т1

Посылаем запрос на http://localhost:8080/example/admin

Получаем ошибку 403. Для теста реализована функция выдачи прав Админа для текущего пользователя http://localhost:8080/example/get-admin

В консоли видим: Привет, админ

Получаем права примиум пользователя http://localhost:8080/example/get-premium-user

Отправляем запрос на http://localhost:8080/example/premium-user

В консоли видим: Привет, премиум-пользователь

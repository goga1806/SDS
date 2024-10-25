# Student Service

REST сервис для управления информацией о студентах.

## Описание

Приложение позволяет выполнять следующие операции:

1. **Авторизация по протоколу OAuth2.0** с возвратом `access_token`.
2. **Получение списка студентов** (HTTP GET).
3. **Добавление нового студента** (HTTP PUT).
4. **Изменение информации о студенте** (HTTP POST).
5. **Удаление студента** (HTTP DELETE).

## Технологии

- **Java 17**
- **Spring Boot 3.3**
- **Spring Security 6**
- **Spring Authorization Server**
- **MongoDB**

## Требования

- **Java 17** или выше
- **Maven**
- **MongoDB** (запущенный на `mongodb://localhost:27017`)

## Установка и запуск

### 1. Клонирование репозитория

```bash
git clone https://github.com/yourusername/student-service.git
cd student-service
```

### 2. Сборка проекта

```bash
mvn clean install
```

### 3. Запуск MongoDB

Убедитесь, что MongoDB запущен и доступен по адресу `mongodb://localhost:27017`.

### 4. Запуск приложения

```bash
mvn spring-boot:run
```

Приложение будет доступно по адресу `http://localhost:8080`.

---

## Примеры запросов в формате CURL

### 1. Получение `access_token`
Так как это демонстрационное тестовое задание увеличил время жизни токена до 2 часов.

```bash
curl -X POST \
  http://localhost:8080/oauth2/token \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -u "client-id:client-secret" \
  -d "grant_type=client_credentials&scope=read write"
```

**Пример ответа:**

```json
{
  "access_token": "eyJraWQiOiJ... (ACCESS_TOKEN)",
  "token_type": "Bearer",
  "expires_in": 28800,
  "scope": "read write"
}
```

### 2. Получение списка студентов (HTTP GET)

```bash
curl -X GET \
  http://localhost:8080/api/students \
  -H "Authorization: Bearer ACCESS_TOKEN"
```

**Замените `ACCESS_TOKEN` на фактический токен из предыдущего шага.**

### 3. Добавление нового студента (HTTP PUT)

```bash
curl -X PUT \
  http://localhost:8080/api/students \
  -H "Authorization: Bearer ACCESS_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "lastName": "Иванов",
    "firstName": "Иван",
    "middleName": "Иванович",
    "group": "Разработчик",
    "averageGrade": 4.5
  }'
```

### 4. Изменение информации о студенте (HTTP POST)

```bash
curl -X POST \
  http://localhost:8080/api/students/STUDENT_ID \
  -H "Authorization: Bearer ACCESS_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "lastName": "Петров",
    "firstName": "Петр",
    "middleName": "Петрович",
    "group": "HR",
    "averageGrade": 4.8
  }'
```

**Замените `STUDENT_ID` на идентификатор студента, полученный при добавлении.**

### 5. Удаление студента (HTTP DELETE)

```bash
curl -X DELETE \
  http://localhost:8080/api/students/STUDENT_ID \
  -H "Authorization: Bearer ACCESS_TOKEN"
```

---
Так же добавил проверку в Postman

## Примеры запросов для Postman

### 1. Получение `access_token`


1. **Создайте новый запрос в Postman**
    - **Метод:** `POST`
    - **URL:** `http://localhost:8080/oauth2/token`

2. **Настройте авторизацию**
    - Перейдите на вкладку **Authorization**.
    - Выберите **Basic Auth**.
        - **Username:** `client-id`
        - **Password:** `client-secret`

3. **Настройте заголовки**
    - Убедитесь, что у вас есть заголовок:
        - `Content-Type: application/x-www-form-urlencoded`

4. **Настройте тело запроса**
    - Перейдите на вкладку **Body**.
    - Выберите **x-www-form-urlencoded**.
    - Добавьте параметры:
        - `grant_type`: `client_credentials`
        - `scope`: `read write`

5. **Отправьте запрос**
    - Нажмите кнопку **Send**.
    - В ответе вы получите `access_token`.

**Сохраните `access_token`** для использования в последующих запросах.

### 2. Добавление нового студента (HTTP PUT)

1. **Создайте новый запрос**
    - **Метод:** `PUT`
    - **URL:** `http://localhost:8080/api/students`

2. **Добавьте заголовки**
    - `Authorization`: `Bearer ACCESS_TOKEN`
    - `Content-Type`: `application/json`

   **Замените `ACCESS_TOKEN` на ваш токен.**

3. **Настройте тело запроса**
    - Выберите **raw** и формат **JSON**.
    - Введите данные студента:

      ```json
      {
        "lastName": "Иванов",
        "firstName": "Иван",
        "middleName": "Иванович",
        "group": "Разработчик",
        "averageGrade": 4.5
      }
      ```

4. **Отправьте запрос**
    - Нажмите кнопку **Send**.
    - В ответе вы получите созданного студента с присвоенным `id`.

**Сохраните `id` студента** для дальнейших операций.

### 3. Получение списка студентов (HTTP GET)

1. **Создайте новый запрос**
    - **Метод:** `GET`
    - **URL:** `http://localhost:8080/api/students`

2. **Добавьте заголовки**
    - `Authorization`: `Bearer ACCESS_TOKEN`

3. **Отправьте запрос**
    - Нажмите кнопку **Send**.
    - В ответе вы получите список студентов.

### 4. Изменение информации о студенте (HTTP POST)

1. **Создайте новый запрос**
    - **Метод:** `POST`
    - **URL:** `http://localhost:8080/api/students/STUDENT_ID`

      **Замените `STUDENT_ID` на `id` студента.**

2. **Добавьте заголовки**
    - `Authorization`: `Bearer ACCESS_TOKEN`
    - `Content-Type`: `application/json`

3. **Настройте тело запроса**
    - Введите обновленные данные студента:

      ```json
      {
        "lastName": "Петров",
        "firstName": "Петр",
        "middleName": "Петрович",
        "group": "HR",
        "averageGrade": 4.8
      }
      ```

4. **Отправьте запрос**
    - Нажмите кнопку **Send**.
    - В ответе вы получите обновленного студента.

### 5. Удаление студента (HTTP DELETE)

1. **Создайте новый запрос**
    - **Метод:** `DELETE`
    - **URL:** `http://localhost:8080/api/students/STUDENT_ID`

      **Замените `STUDENT_ID` на `id` студента.**

2. **Добавьте заголовки**
    - `Authorization`: `Bearer ACCESS_TOKEN`

3. **Отправьте запрос**
    - Нажмите кнопку **Send**.
    - В ответе вы получите статус `204 No Content`, что означает успешное удаление.

---

- **Обработка ошибок**:

  При выполнении запросов без `access_token` или с неправильным токеном сервер вернет статус `401 Unauthorized`.


## Контактная информация

Если у вас возникнут вопросы или предложения, пожалуйста, свяжитесь со мной по электронной почте: `dolgopolovanton86@gmail.com`.

---

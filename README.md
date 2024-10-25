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

### **1. Клонирование репозитория**

```bash
git clone https://github.com/yourusername/student-service.git
cd student-service

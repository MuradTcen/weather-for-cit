Затраченное время:
На бэк (Java Spring) ушло 2 вечера (пн и вт), на фронт (Vue.js) 2 вечера (ср и вс). 

Что получилось:
1. Есть три бэковых роута: получить координаты по названию города, получить текущую погоду по координатам и
 получить список погодных провайдеров (не используется)
 
2. Задеплоен на Heroku бэк https://thewhear.herokuapp.com/ , задеплоен на Heroku фронт https://thewear.herokuapp.com/                                                                                                                                                                                                                                                                                                     
   Не получилось сделать весь проект (и фронт и бэк ) на одном адресе, проблема в конфигурации проекта.
   Репозиторий фронта: https://github.com/MuradTcen/weather-client
   
3. Не менее 3-х городов и двух провайдеров погоды

4. При перезапуске браузера данные сохраняются

Что не получилось:

1. Не получилось разрешить проблему с CORS, в данный момент необходимо запускать браузер с параметрами
 ```chromium-browser --disable-web-security --user-data-dir```, чтобы убрать проблему с CORS
 
 <a href="https://imageup.ru/img70/3519919/work.jpg.html" target="_blank"><img src="https://imageup.ru/img70/thumb/work3519919.jpg" border="0" alt="Фотохостинг"></a>
<br>
<br>
 Если зайти с обычными настройками, то:
 <br>
 <br>
 <a href="https://imageup.ru/img70/3519918/unworked.jpg.html" target="_blank"><img src="https://imageup.ru/img70/thumb/unworked3519918.jpg" border="0" alt="хранение файлов"></a>
 <br>
 <br>
2. На клиенте приходится иногда тыкать "отправить запрос" дважды. Клиент нормально получает координаты, но иногда не подставляет
координаты в запрос погоды и запрос погоды валится

Проблемы:

1. CORS, ушло достаточно много времени, чтобы фронт заработал локально с бэком

2. Не получилось соединить фронт с бэком в одном проекте, не получилось задеплоить нормально фронт из-за CORS

3. Не добился того, чтобы получать значения из application.properties,
 в Application.java это работает, в других местах нет

-------------------------------
Провайдер Dark-Sky показывает неправильную температуру, можно подумать что неправильно передаются координаты,
но посмотрев весь ответ, можно убедиться, что всё ок 

При использовании провайдера OpenWheather возникают проблемы приходит невалидый ответ, скорее всего проблема в заголовках

Данные ветра не нормализованы

-------------------------------

### Тестовое задание для программиста
#### Задача: Разработать веб-приложение для просмотра данных о погоде.
**Требования к реализации:** Задание должно быть реализовано на платформе Java в виде
веб-приложения, остальные детали — на усмотрение разработчика.

**Постановка задачи:** Приложение отображает информацию о погоде с различных погодных
сервисов в Internet. При входе в интерфейс пользователь может выбрать интересующие его город
и погодный сервис и увидеть информацию о погоде.
#### Требования к функционалу:
1. Для выбора пользователю доступно не менее 3 городов и 2 погодных сервисов.
2. Отображается не менее 3 показателей погоды (например, температура, влажность,
осадки).
3. Выбранные пользователем настройки (город и погодный сервис) сохраняются между
перезапусками браузера.
4. Актуальность данных, выводимых пользователю (разница между временем
получения данных от погодного сервиса и текущим временем) не превышает 5 минут.
Приложение рассчитано на публикацию в Internet (т.е. число одновременных пользователей
может быть достаточно большим).


------------------------------------------------------
### Фидбэк

1) Код достаточно простой и понятный

2) Исходники есть на гитхаб и разработка велась постепенно отдельными коммитами

3) Есть комментарии на гитхабе(подробные, в том числе что не получилось) и немного в коде

4) Требуемый функционал реализован

5) Структура проекта аккуратная и удобная

6) Используется ломбок и в целом всё читабельно

7) Логи

8) Проперти см. №5 в "-"

 

Что не понравилось:

 

1) Нет тестов

2) Нет работы с исключениями

3) На бекэнде реализована возможность получать погоду любого города(используется апи дадата), а на фронте нет (но со стороны бэка это +)

4) (Субъективно)Фронт получился не самым лучшим, хотя в начале кажется что будет что-то интересное(в отдельном гите, vuejs), в итоге пришлось потратить много времени на vue, запуск и установку всяких nodejs.

Но использование всяких технологий это конечно +, но было бы хорошо что бы они ещё давали хороший результат.

5) Есть проперти, и даже видно что планировалось сделать как надо, но что-то пошло не так и данные из пропертей добавлены хардкодом

6) При перезапуске страницы настройки пользователя сохраняются, а вот данные погоды нет и не получаются по новой, приходится опять нажимать кнопку получения погоды.

И при этом есть баг когда фронт запрашивает погоду не запросив координаты города (на бэке есть контроллер который даёт погоду по координатам и координаты по названию местности).

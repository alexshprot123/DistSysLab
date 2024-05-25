# Выполнил Степанов А.М. студент группы ИПБ-21

# Лабораторная работа № 3

В проекте написаны следующие основные классы:
* RestApi – класс, в котором прописаны все запросы;
* Controller – класс, в котором реализованы основные действия над объектами;
* Item – класс, в котором описаны поля объекта;
* Converter – класс, который будет конвертировать DTO в Item и наоборот;
* ItemDTO, ItemAddDTO, ChangeCostDTO – классы для передачи информации через запросы.

Реализованные запросы:
* Получить весь список предметов
* Получить предметы по имени
* Получить предмет по id
* Добавить предмет
* Изменить предмет
* Удалить предмет по id
* Умножить стоимость всех предметов на коэффициент
* Добавить самый дорогой предмет из списка

# Лабораторная работа № 4

Был подключен RabbitMQ

Добавлены следующие классы:
* RabbitMqApi – запрос, записывающий сообщение в очередь;
* RabbitmqConsumer– обработчик очереди. Получает сообщения из очереди и записывает в лог.

# Лабораторная работа № 5

Была подключена База Данных.
Для возможности сохранять объекты в БД класс Item был унаследован от PanacheEntity. 

# Лабораторная работа № 7

Был создан DockerFile

# Лабораторная работа № 8

Изменение структуры проекта:
* PanacheController – класс, в котором прописаны все запросы  для работы с PanacheEntity;
* JDBCController – класс, в котором прописаны все запросы для работы с JDBC;
* RabbitmqController – класс, в котором прописаны все запросы для работы с RabbitMQ;
* RabbitmqConsumer - класс для работы с очередью RabbitMQ;
* PanacheService – класс, в котором прописана логика работы с PanacheEntity;
* JDBCService – класс, в котором прописана логика работы с JDBC;
* Item – класс, в котором описаны поля объекта;
* Converter – класс, который будет конвертировать DTO в Item и наоборот;
* ItemDTO, ItemAddDTO, ChangeCostDTO – классы для передачи информации через запросы.
# lab3

Выполнил Степанов А.М. студент группы ИПБ-21

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
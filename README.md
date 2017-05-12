# RailwayService

Приложение, моделирующее работу информационной системы компании, осуществляющей пассажирские железнодорожные перевозки.
Обеспечивает следующую функциональность:

Для клиентов компании
  *поиск поезда, проходящего от станции A до станции B в заданный промежуток времени;
  *расписание поездов по станции;
  *покупка билета, если:
    *есть свободные места
	  *пассажир с такими же именем, фамилией и датой рождений еще не зарегистрирован в выбранном поезде
  *до отправления поезда не менее 10 минут

Для сотрудников компании
  *добавление новых станций, поездов;
  *просмотр всех зарегистрированных на поезд пассажиров;
 	*просмотр всех поездов;

Проект еще находится на стадии доработки, но уже представлены основные сущности, созданы DAO, сервисы и контроллеры.

TODO: 
существующий код будет доработан, будут добавлены unit тесты, а так же реализован простейший UI.

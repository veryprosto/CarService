<#include "security.ftlx">
<#import "login.ftlx" as l>

<link rel="stylesheet" href="/static/style.css">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">Car service</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <div class="btn-group">
                <li class="nav-item dropdown">
                    <a class="nav-link active dropdown-toggle" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Файл
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark bg-dark">
                        <li><a class="dropdown-item" href=#>Импорт базы данных</a></li>
                        <li><a class="dropdown-item" href=#>Экспорт базы данных</a></li>
                        <li><a class="dropdown-item" href=#>Сменить пользователя</a></li>
                        <li>
                            <form action="/logout" method="post">
                                <a class="dropdown-item" href="javascript:;" onclick="parentNode.submit();">Выход</a>
                                <input type="hidden" name="mess"/>
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            </form>
                        </li>
                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link active dropdown-toggle" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Администрирование
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark bg-dark">
                        <li><a class="dropdown-item" href=#>Организация</a></li>
                        <li><a class="dropdown-item" href=#>Выбор СТО</a></li>
                        <li><a class="dropdown-item" href=#>Типы постов</a></li>
                        <li class="dropdown-submenu">
                            <a class="nav-link active dropdown-toggle" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Cотрудники
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark bg-dark">
                                <li><a class="dropdown-item" href="/worker">Сотрудники</a></li>
                                <li><a class="dropdown-item" href=#>Группы</a></li>
                                <li><a class="dropdown-item" href=#>Заработная плата</a></li>
                                <li><a class="dropdown-item" href=#>Табель рабочего времени</a></li>
                                <li><a class="dropdown-item" href=#>Журнал выдачи зарплаты</a></li>
                            </ul>
                        </li>

                        <li class="dropdown-submenu">
                            <a class="nav-link active dropdown-toggle" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Работы
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark bg-dark">
                                <li><a class="dropdown-item" href=#>Работы</a></li>
                                <li><a class="dropdown-item" href=#>Нормы времени</a></li>
                            </ul>
                        </li>

                        <li class="dropdown-submenu">
                            <a class="nav-link active dropdown-toggle" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Клиенты
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark bg-dark">
                                <li><a class="dropdown-item" href="/customer">Клиенты</a></li>
                                <li><a class="dropdown-item" href=#>Группы</a></li>
                                <li><a class="dropdown-item" href=#>Автомобили</a></li>
                                <li><a class="dropdown-item" href=#>Акты сверки</a></li>
                            </ul>
                        </li>

                        <li class="dropdown-submenu">
                            <a class="nav-link active dropdown-toggle" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Ценообразование
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark bg-dark">
                                <li><a class="dropdown-item" href=#>Ценообразование</a></li>
                                <li><a class="dropdown-item" href=#>Формы оплаты</a></li>
                            </ul>
                        </li>
                        <li><a class="dropdown-item" href=#>Запасные части</a></li>
                        <li><a class="dropdown-item" href=#>Контрагенты</a></li>
                        <li><a class="dropdown-item" href=#>Марки и модели</a></li>
                        <li><a class="dropdown-item" href=#>Поставщики запчастей</a></li>
                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link active dropdown-toggle" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Настройки
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark bg-dark">
                        <li class="dropdown-submenu">
                            <a class="nav-link active dropdown-toggle" href="#" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Печатные формы
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark bg-dark">
                                <li><a class="dropdown-item" href=#>Общие</a></li>
                                <li><a class="dropdown-item" href=#>Заказ-наряд</a></li>
                                <li><a class="dropdown-item" href=#>Акт выполненных работ</a></li>
                                <li><a class="dropdown-item" href=#>Логотип организации</a></li>
                            </ul>
                        </li>
                        <li><a class="dropdown-item" href=#>Валюта</a></li>
                        <li><a class="dropdown-item" href=#>Налог на добавленную стоимость (НДС)</a></li>
                        <li><a class="dropdown-item" href=#>Резервное копирование</a></li>
                        <li><a class="dropdown-item" href=#>ККТ (Контрольно-кассовая техника)</a></li>
                        <li><a class="dropdown-item" href=#>Язык</a></li>

                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link active dropdown-toggle" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Отчеты
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark bg-dark">
                        <li><a class="dropdown-item" href=#>Заработок</a></li>
                        <li><a class="dropdown-item" href=#>Остатки</a></li>
                        <li><a class="dropdown-item" href=#>Оказанные услуги</a></li>
                        <li><a class="dropdown-item" href=#>Основной отчет</a></li>
                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link active dropdown-toggle" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Магазин
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark bg-dark">
                        <li><a class="dropdown-item" href=#>Продажа</a></li>
                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link active dropdown-toggle" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Рассылка
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark bg-dark">
                        <li><a class="dropdown-item" href=#>Отправить сообщение</a></li>
                        <li><a class="dropdown-item" href=#>Шаблоны</a></li>
                        <li><a class="dropdown-item" href=#>Настройка</a></li>
                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link active dropdown-toggle" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Помощь
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark bg-dark">
                        <li><a class="dropdown-item" href=#>Активация</a></li>
                        <li><a class="dropdown-item" href=#>Удаленный помощник</a></li>
                        <li><a class="dropdown-item" href=#>Инструкции</a></li>
                        <li><a class="dropdown-item" href=#>Обратная связь</a></li>
                        <li><a class="dropdown-item" href=#>О программе</a></li>
                    </ul>
                </li>
            </div>
        </ul>
        <div class="navbar-text me-3">${username}</div>
    </div>
</nav>


# Simple-Spring-REST
🧑‍💻Test task

Разработать проект REST-сервиса c использованием Spring Boot, Spring
Web, Spring Data JPA
в качестве БД использовать H2
Сервис должен обеспечивать операции с 2 связанными типами объектов:
Client и Address, использовать связь OneToMany (один Client имеет
несколько Address)
объекты должны иметь поля id и name
Реализовать операции:
- просмотр списка всех Client (без связанных Address)
- просмотр списка всех Client (без связанных Address), отфильтрованных по наличию заданной подстроки, входящей в name
- добавление нового Client
- удаление Client по id
- получение списка Address для заданного id Client
- добавление нового Address для заданного id Client
- удаление Address по id

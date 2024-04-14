# PIONEER
## Актуальные pipelines:
### 1. Customer pipeline:
1. Потребитель заходит на главную страницу  
1.1.  Потребитель регистрируется по `/api/v1/customer/registration`  
1.2.  Если потребитель уже зарегестрирован, он авторизируется по `/api/v1/customer/login`
2. Потребитель получает список услуг по `/api/v1/customer/login` и выбирает нужную
3. Потребитель получает список работ по `/api/v1/customer/works` и выбирает нужную
4. Потребитель получает список аддресов организаций по `/api/v1/customer/addresses` и выбирает нужную
5. Потребитель создает заявку по `/api/v1/customer/service-request`, которая отправляется в топик по organizationId
### 2. Organization pipeline
1. Ответственное за организацию лицо заходит на главную страницу  
1.1.  Лицо оставляет заявку на регистрацию организации по `/api/v1/organization/registration`  
1.2.  После оставления заявки, лицо может авторизироваться по `/api/v1/organization/registration`
2. Лицо добавляет своей организации адресс по `/api/v1/organization/addresses`.
   Также по данному endpoint'у лицо может обновить данные уже добавленного адресса
3. Лицо может получить список привязанных адрессов по `/api/v1/organization/addresses/{id}`
4. Лицо может получить список своих заявок на регистрацию по `/api/v1/organization/connection-request/{id}`
5. Если заявка на регистрацию одобрена, лицо может получить заявку на услугу из своего топика по `/api/v1/organization/service-request/{id}`
### 3. Aggregator-specialist pipeline
1. Специалист заходит на главную страницу и может авторизироваться по `/api/v1/aggregator/login`
2. Специалист получает список заявок на регистрацию организации по `/api/v1/aggregator/connection-request`
3. Специалист может изменить статус заявки по `/api/v1/aggregator/connection-request/{id}`
## Актуальная ERD
![image](https://github.com/Spark11e/PIONEER/assets/99715439/e0543640-c4e5-4361-8131-f817321a3322)

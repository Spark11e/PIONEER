import React, { useContext, useEffect } from 'react';
import { observer } from 'mobx-react-lite';
import {useNavigate} from 'react-router-dom';
import { Context } from '../../../index';
import styles from './OrganizationItem.module.css';

import { ORGANIZATION_ROUTER, CONFIRM_ROUTER } from '../../../utils/const';

const OrganizationItem = observer(() => {


    const { user } = useContext(Context);
    const navigate = useNavigate();

     // для выбора услуги
    // console.log(user.selectedOrganization)
    
    const handleSelectService = (service) => {

        if (user.selectedServices.find(s => s.type_id === service.type_id)) {
            user.removeSelectedServices(service.type_id);
        } else {
            user.addSelectedServices(service);
        }
    };


    // Проверка, выбрана ли услуга
    const isServiceSelected = (service) => {
        return user.selectedServices.some(s => s.type_id === service.type_id);
    };


    const filteredServices = user.carServices.filter(service => service.type_code === user.selectedService.type_code);

 


    useEffect(() => {
        console.log('selectedOrganization changed:', user.selectedOrganization);
    }, [user.selectedOrganization]);


    const handleClick= () => {
        console.log(user.getSelectedServices());
        // Сохраняем выбранные услуги в стор
        // user.setSelectedServices(user.selectedServices);

        // Редирект на страницу с подтверждением (confirm) и передача id организации
        // navigate(`/organization/${user.selectedOrganization.organization_id}/confirm`);
        navigate(CONFIRM_ROUTER);
    };


    return (
        <div className={styles.services__container}>
            <h2>{user.selectedService.type_name} Услуги для {user.selectedOrganization.subject_name}</h2>
            <div>{`ул ${user.selectedOrganization.street_name}, д ${user.selectedOrganization.house_number}`}</div>
            {filteredServices.map(service => (
                    <div key={service.type_id} className={styles.service__item}>
                        <input
                            type="checkbox"
                            id={`service-${service.type_id}`}
                            checked={isServiceSelected(service)}
                            onChange={() => handleSelectService(service)}
                        />
                        <label htmlFor={`service-${service.type_id}`}>
                            {service.type_name} - {service.price} руб., {service.duration}
                        </label>  
                    </div>
            ))}

            <button onClick={handleClick}>Выбрать</button>
        </div>
    );
});

export default OrganizationItem;
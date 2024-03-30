import React, { useState, useContext } from 'react';
import { observer } from 'mobx-react-lite';
import {Context} from '../../../index'
import Button from "../../../components/Button";
import { useNavigate } from "react-router-dom";
import { ORGANIZATION_ROUTER } from '../../../utils/const';

import styles from './ServiceSelection.module.css';

const ServiceSelection = observer(() => {

    const navigate = useNavigate();

    const { user } = useContext(Context);

    const [selectedService, setService] = useState('');

    const handleNext = () => {
        user.setSelectedService(selectedService);
        navigate(ORGANIZATION_ROUTER);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        handleNext();
    };

    return (
        <div className={styles.main__container}>
            <form onSubmit={handleSubmit}>
                <div>
                    <h2>Выбор услуги</h2>
                </div>
                <div className={styles.services}>
                    <div className={styles.service__item}>
                        <input
                            className={styles.services__checkbox}
                            type="checkbox"
                            id="carWash"
                            checked={selectedService === 'Мойка'}
                            onChange={() => setService('Мойка')}
                        />
                        <label htmlFor="carWash">Автомойка</label>
                    </div>
                    <div className={styles.service__item}>
                        <input
                            className={styles.services__checkbox}
                            type="checkbox"
                            id="tireService"
                            checked={selectedService === 'Шиномонтаж'}
                            onChange={() => setService('Шиномонтаж')}
                        />
                        <label htmlFor="tireService">Шиномонтаж</label>
                    </div>
                </div>
                <div className={styles.button__container}>
                    <Button text={"Выбрать услугу"} onClick={handleSubmit} disabled={!selectedService} className={styles.next__button}>
                        
                    </Button>
                </div>

            </form>
        </div>
    );
});

export default ServiceSelection;

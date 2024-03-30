import React, {useState, useContext} from 'react';
import { observer } from 'mobx-react-lite';

import { useNavigate } from "react-router-dom";
import { SERVICES_ROUTER } from '../../../utils/const';

import InputMask from 'react-input-mask';

import {Context} from '../../../index'

import styles from './Registraion.module.css'

const Registraion = observer(() => {

    const navigate = useNavigate();

    const [phoneNumber, setPhone] = useState('');
    const [email, setAdress] = useState('');
    const [isChecked, setIsChecked] = useState(false);

    const { user } = useContext(Context);

    const handleSubmit = (e) => {
        e.preventDefault();
        handleNext();
    };

    const handleCheckboxChange = () => {
        setIsChecked(!isChecked);
      }

    const handleNext = () => {
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        navigate(SERVICES_ROUTER);

    };

    return (

        <div className={styles.main__container}>

            <div>
                <h2>Регистрация</h2>
            </div>

            <div className={styles.registraion}>
                <form onSubmit={handleSubmit}>
                    <div className={styles.registraion__list}>
                        <div className={styles.registraion__item} >
                            <label>Номер телефона</label>
                            <InputMask
                                mask="8 (999) 999-99-99"
                                maskChar="_"
                                type="text"
                                placeholder="Номер телефона"
                                value={phoneNumber}
                                onChange={(e) => setPhone(e.target.value)}
                            />
                        </div>

                        <div className={styles.registraion__item}>
                            <label>Email</label>  
                            <input
                                type="email"
                                placeholder="Email"
                                value={email}
                                onChange={(e) => setAdress(e.target.value)}
                            />
                        </div>
                    </div>
                    
                    <div className={styles.registraion__checkbox}>
                        
                        <input type="checkbox"
                        checked={isChecked}
                        onChange={handleCheckboxChange}
                            
                        />
                        <label>Принимаю условия <span className={styles.registraion__span}>политики конфиденциальности</span></label>

                    </div>

                    <div className={styles.registraion__button}>

                        <button onClick={handleSubmit} disabled={!isChecked} type="submit" >Зарегистрироваться</button>
                    </div>

                </form>
            </div>
            
        </div>

    );
});

export default Registraion;
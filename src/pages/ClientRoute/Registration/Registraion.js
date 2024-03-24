import React, {useState} from 'react';
import { observer } from 'mobx-react-lite';
import UserStore from "../../../store/UserStore";

import CheckboxComponent from '../../../components/Checkbox';
import styles from './Registraion.module.css'

const Registraion = observer(() => {

    const [phoneNumber, setPhoneNumber] = useState('');
    const [email, setEmail] = useState('');
    const [isChecked, setIsChecked] = useState(false);

    const handlePhoneChange = (e) => {
        UserStore.setPhoneNumber(e.target.value);
    };

    const handleEmailChange = (e) => {
        UserStore.setEmail(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
    
    };

    const handleCheckboxChange = () => {
        setIsChecked(!isChecked);
      }

    const handleNext = () => {
        UserStore.setPhoneNumber(phoneNumber);
        UserStore.setEmail(email);

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
                            <input
                                type="text"
                                placeholder="Номер телефона"
                                value={phoneNumber}
                                onChange={(e) => setPhoneNumber(e.target.value)}
                            />
                        </div>

                        <div className={styles.registraion__item}>
                            <label>Email</label>  
                            <input
                                type="email"
                                placeholder="Email"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
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

                        <button  disabled={!isChecked} type="submit" >Зарегистрироваться</button>
                    </div>

                </form>
            </div>
            
        </div>

    );
});

export default Registraion;
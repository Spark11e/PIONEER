import React, {useState, useContext} from 'react';
import { observer } from 'mobx-react-lite';

import {useFormik} from 'formik';
import * as Yup from 'yup';


import { useNavigate, useLocation, NavLink } from "react-router-dom";
import { SERVICES_ROUTER, REGISTRATION_ROUTER } from '../../../utils/const';

import InputMask, {unmask} from 'react-input-mask';

import {Context} from '../../../index'

import styles from './Login.module.css'

const Login = observer(() => {
    const navigate = useNavigate();
    const { user } = useContext(Context);

    const formik = useFormik({
        initialValues: {
            
            email: '',
            password: '',
        },
        validationSchema: Yup.object({
            email: Yup.string().email('Неверный формат email').required('Обязательное поле'),
            password: Yup.string()
            .min(2, "Миниум 2 символа")
            .required('Обязательное поле'),
            
        }),
        onSubmit: (values) => {


            user.setEmail(values.email);
            user.setPassword(values.password);

            navigate(SERVICES_ROUTER);
        },
    });

    return (

        <div className={styles.main__container}>

            <div>
                <h2>Авторизация</h2>
            </div>

            <div className={styles.login}>
                <form onSubmit={formik.handleSubmit}>
                    <div className={styles.login__list}>

                        <div className={styles.login__item}>
                            <label>Email</label>  
                            <input
                                type="email"
                                placeholder="Email"
                                value={formik.values.email}
                                onChange={formik.handleChange}
                                onBlur={formik.handleBlur}
                                name="email"
                                required
                            />
                            
                        </div>

                        {formik.errors.email && formik.touched.email && (
                                <div className={styles.error}>{formik.errors.email}</div>
                        )}

                        <div className={styles.login__item}>
                            <label>Введите пароль</label>  
                            <input
                                type="password"
                                placeholder="Пароль"
                                value={formik.values.password}
                                onChange={formik.handleChange}
                                onBlur={formik.handleBlur}
                                name="password"
                                required
                            />
                        </div>
                        

                        {formik.errors.password && formik.touched.password && (
                                <div className={styles.error}>{formik.errors.password}</div>
                        )}
                        <div className={styles.login_link}>
                            <NavLink to={REGISTRATION_ROUTER}>Зарегистрироваться</NavLink>
                        </div>
                    </div>    

                    <div className={styles.login__button}>

                        <button type="submit" disabled={!formik.isValid}>
                                Войти
                        </button>
                    </div>

                </form>
            </div>
            
        </div>

    );
});

export default Login;
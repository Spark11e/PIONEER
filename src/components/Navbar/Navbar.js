import React from 'react';

import styles from "./Navbar.module.css"

import svgImage from '../../assets/svg/exit.svg'
import { useNavigate, useLocation } from 'react-router-dom';

const Navbar = () => {

    const location = useLocation();
    const navigate = useNavigate();

    // Функция для перехода на предыдущую страницу (шаг назад)
    const goBack = () => {
        navigate(-1); // -1 для перехода на предыдущую страницу
    };


    return (

        <div className={styles.container}>
            
            <div className={styles.navbar__header}>
            {location.pathname === '/' ? (
                <a href="/#" id="link_exit" className={styles.navbar__link}>
                    <img
                    src={svgImage}
                    alt="exit"
                    height="87px"
                    width="100px"
                    onClick={(e) => {
                        e.preventDefault();
                        navigate('/')}
                    }   
                    > 
                    </img>
                </a>
            ) : (
                <img
                src={svgImage}
                alt="back"
                height="87px"
                width="100px"
                onClick={goBack}
                style={{ cursor: 'pointer' }}
            />

            )
            }
            </div>
        </div>
    );
};

export default Navbar;
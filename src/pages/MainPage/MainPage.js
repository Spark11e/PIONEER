import React from 'react';

import styles from './MainPage.module.css'
const MainPage = () => {




    return (
        <div className={styles.main__container}>
            <div className={styles.pioneer}>
                    <h1>PIONEER</h1>
            </div>
            <div>
                <p className={styles.pioner__about}>Предоставление услуг<br/> транспортным средствам</p>
            </div>
            <div className={styles.button_menu}>
                <div className={styles.button_list}>
                    <div className={styles.button__item}>
                        <button className={styles.button__xl}>
                            <a className={styles.button__link} href="/#" target="_blank">Владельцам транспортным средствам</a>
                        </button>
                    </div>
                    <div className={styles.button__item}>
                        <button className={styles.button__xl}>
                            <a className={styles.button__link} href="/#" target="_blank">Организациям Партнерам</a>
                        </button>
                    </div>
                    <div className={styles.button__item}>
                        <button className={styles.button__xl}>
                            <a className={styles.button__link} href="/#" target="_blank">Администрирование</a>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default MainPage;
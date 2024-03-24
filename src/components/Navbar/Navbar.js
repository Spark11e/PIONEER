import React from 'react';

import styles from "./Navbar.module.css"

import svgImage from '../../assets/svg/exit.svg'

import Button from 'react-bootstrap/Button';

const Navbar = () => {

    return (

        <div className={styles.container}>
            
            <div className={styles.navbar__header}>
                <a href="/#" id="link_exit" className={styles.navbar__link}>
                    <img
                    src={svgImage}
                    alt="exit"
                    height="87px"
                    width="100px" 
                    > 
                    </img>
                </a>
            </div>
        </div>
    );
};

export default Navbar;
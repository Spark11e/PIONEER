
import React, { useState, useContext } from 'react';
import { observer } from 'mobx-react-lite';
import {Context} from '../../../index'
import Button from "../../../components/Button";
import { useNavigate } from "react-router-dom";
import { ORGANIZATION_ROUTER} from '../../../utils/const';

import styles from './OrganizationSelect.module.css';

const OrganizationSelect = observer(() => {

    const navigate = useNavigate();

    const { user } = useContext(Context);
    const [searchCity, setSearchCity] = useState('');
    const [filteredOrganizations, setFilteredOrganizations] = useState([]);


    const handleSearch = () => {
        const filtered = user.organizations.filter(org =>
            org.city_name.toLowerCase().includes(searchCity.toLowerCase())
        );
        setFilteredOrganizations(filtered);
        
        setSearchCity('');
    };

    const handleSelectOrganization = (organization) => {
        user.printUserData(user);
        console.log('Выбрана организация:', organization);
    };

    // const [selectedService, setService] = useState('');

    // const handleNext = () => {
    //     user.setSelectedService(selectedService);
    //     // navigate(NEXT_PAGE_ROUTER);
    // };

    // const handleSubmit = (e) => {
    //     e.preventDefault();
    //     handleNext();
    // };

    return (
        <div className={styles.main__container}>
            <div className={styles.search__container}>
                <input
                    type="text"
                    placeholder="Введите город"
                    value={searchCity}
                    onChange={(e) => setSearchCity(e.target.value)}
                />
                <button onClick={handleSearch}>Искать</button>
            </div>
            <div className={styles.organizations__list}>
                {filteredOrganizations.map(org => (
                    <div key={org.organization_id} className={styles.organization__item}>
                        <p>{org.subject_name}</p>
                        <p>{org.city_name}, {org.street_name} {org.house_number}</p>
                        <button onClick={() => handleSelectOrganization(org)}>Выбрать</button>
                    </div>
                ))}
            </div>
        </div>
    );
});

export default OrganizationSelect;

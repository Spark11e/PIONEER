import React, { useContext, useState } from 'react';
import { observer } from 'mobx-react-lite';

import { Context } from '../../../index';
import { useNavigate } from 'react-router-dom';
import styles from './OrganizationSelect.module.css';
import { ORGANIZATION_ROUTER } from '../../../utils/const';

const OrganizationSelect = observer(() => {
    const { user } = useContext(Context);
    const navigate = useNavigate();

    const [searchCity, setSearchCity] = useState('');
    const [filteredOrganizations, setFilteredOrganizations] = useState([]);

    const [isFilterArr, setIsFilterArr] = useState(true)


    const handleSearch = () => {
        let filtered = user.organizations.filter(org => 
            org.city_name.toLowerCase().includes(searchCity.toLowerCase())
        );

        if(user.selectedService !== null) {
            filtered = filtered.filter(org => org.organization_type === user.selectedService)
        }

        setIsFilterArr(filtered.length > 0); // Проверяем наличие результатов

        setFilteredOrganizations(filtered);


        
    }

    const handleSelectOrganization = (organization) => {
        user.setSelectedOrganization(organization);

        user.setSelectedLocation(organization.city_name)
    
        console.log(user.printUserData(user));
        // ORGANIZATION_ROUTER + '/' + organization.organization_id
        // user.printUserData(user);
        navigate(ORGANIZATION_ROUTER + '/' + organization.organization_id);
    };

    return (
        <div className={styles.organization__container}>
            <div className={styles.search__container}>
                <input
                    type="text"
                    placeholder="Введите город"
                    value={searchCity}
                    onChange={(e) => setSearchCity(e.target.value)}
                />
            </div>    
                <button onClick={handleSearch}>Искать</button>
            <div className={styles.organization__list}>
                {filteredOrganizations.map(organization => (
                    <div
                        key={organization.organization_id}
                        className={styles.organization__item}
                        onClick={() => handleSelectOrganization(organization)}
                    >
                        <div>{organization.subject_name}</div>
                        <div>{organization.city_name}, {organization.street_name} {organization.house_number}</div>
                    </div>
                ))}
                {!isFilterArr ? <div>Ничего не найдено</div> : null}
            </div>
        </div>
    );
});

export default OrganizationSelect;
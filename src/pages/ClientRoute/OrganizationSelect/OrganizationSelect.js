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


    const handleSearch = () => {
        const filtered = user.organizations.filter(org => 
            org.city_name.toLowerCase().includes(searchCity.toLowerCase())
        );

        setFilteredOrganizations(filtered);


        
    }

    const handleSelectOrganization = (organization) => {
        user.setSelectedOrganization(organization);
        user.setSelectedLocation(organization.city_name)

        // ORGANIZATION_ROUTER + '/' + organization.organization_id
        // user.printUserData(user);
        console.log(user.getSelectedOrganization());
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
            </div>
        </div>
    );
});

export default OrganizationSelect;
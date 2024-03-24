import {makeAutoObservable} from 'mobx';

export default class UserStore {
    phoneNumber = '';
    email = '';
    selectedService = ''; // выбранная услуга: 'шиномонтаж' или 'мойка'
    selectedLocation = ''; // выбранное место
    selectedTime = ''; // выбранное время

    constructor() {
        this._isAuth = true;
        this._user = {}
        makeAutoObservable(this)
    }



    setPhoneNumber(phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    setEmail(email) {
        this.email = email;
    }

    setSelectedService(service) {
        this.selectedService = service;
    }

    setSelectedLocation(location) {
        this.selectedLocation = location;
    }

    setSelectedTime(time) {
        this.selectedTime = time;
    }















    setIsAuth(bool) {
        this._isAuth = bool
    }

    setUser(user) {
        this._ = user
    }

    get isAuth(){
        return this._isAuth
    }
    get user(){
        return this._user
    }
}
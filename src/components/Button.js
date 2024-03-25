import React from 'react';

const Button = ({text}) => {

    const buttonStyle = {
        fontSize: '15px',
        cursor: 'pointer',
        fontWeight: 500,
        color: '#EAE4E4',
        border: 'none',
        width: '245px',
        height: '48px',
        backgroundColor: '#c2b4b4'
    };

    return (
        <button style={buttonStyle}>{text}</button>
    );
};



export default Button;
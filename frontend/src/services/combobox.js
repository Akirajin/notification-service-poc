import React, { useState, useEffect } from 'react';

const CategoryComboBox = ({ value, onChange }) => {
    const [options, setOptions] = useState([]);

    useEffect(() => {
        // Make a GET request to the API endpoint.
        fetch('http://localhost:8080/categories')
            .then((response) => response.json())
            .then((data) => {
                // Extract the names from the API data and set them as options.
                const categoryOptions = data.map((category) => category.name);
                setOptions(categoryOptions);
            });
    }, []);

    return (
        <select value={value} onChange={onChange}>
            {options.map((option, index) => (
                <option key={index} value={option}>
                    {option}
                </option>
            ))}
        </select>
    );
};

export default CategoryComboBox;

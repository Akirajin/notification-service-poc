import {AiFillNotification} from 'react-icons/ai'
import './styles.css'
import CategoryComboBox from "./services/combobox";
import {useState} from "react";
import NotificationLogs from "./services/notificationlogs";

function App() {


    const [selectedCategory, setSelectedCategory] = useState('');

    const [inputText, setInputText] = useState('');


    const handle = async () => {
        // Define the payload object
        const payload = {
            category: selectedCategory.toUpperCase(),
            message: inputText,
        };

        try {
            const response = await fetch('http://localhost:8080/notifications', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(payload),
            });

            if (response.ok) {
                // Handle successful API call here
                console.log('Notification sent successfully!');


            } else {
                // Handle API call error here
                console.error('Error sending notification.');
            }
        } catch (error) {
            // Handle any network or other errors here
            console.error('Error:', error);
        }
    };


    // Define a function to handle the ComboBox change
    const handleCategoryChange = (event) => {
        setSelectedCategory(event.target.value);
    };


    return (
        <div className="container">
            <h1 className="title">Notification Service</h1>


            <div className="containerInput">
                <CategoryComboBox value={selectedCategory} onChange={handleCategoryChange}/>

                <p>Selected Category: {selectedCategory}</p>
            </div>


            <div className="containerInput">
                <input type="text" placeholder="Write your notification..." value={inputText}
                       onChange={(e) => setInputText(e.target.value)}/>
                <button className="buttonSubmit" onClick={handle}>
                    <AiFillNotification size={25} color="#000"/>
                </button>
            </div>

            <div className="main">
                {/* Other components and content */}
                <NotificationLogs/> {/* Use the NotificationLogs component here */}
                {/* Other components and content */}
            </div>
        </div>
    );
}

export default App;

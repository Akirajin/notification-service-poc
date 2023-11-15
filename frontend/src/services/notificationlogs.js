import React, {useState, useEffect} from 'react';

const NotificationLogs = () => {
    const [notificationLogs, setNotificationLogs] = useState([]);

    const fetchNotificationLogs = () => {
        fetch('http://localhost:8080/logs')
            .then((response) => response.json())
            .then((data) => setNotificationLogs(data))
            .catch((error) => console.error('Error fetching notification logs:', error));
    };

    useEffect(() => {
        // Fetch data from the API when the component mounts
        fetchNotificationLogs();

        // Set up an interval to fetch data every 10 seconds (adjust the interval as needed)
        const intervalId = setInterval(fetchNotificationLogs, 10000);

        // Clean up the interval when the component unmounts
        return () => clearInterval(intervalId);
    }, []);

    return (
        <div className="notificationLogsContainer">
            <h2>Notification Logs</h2>
            <div className="logsScrollable">
                <ul>
                    {notificationLogs.map((log, index) => (
                        <li key={index}>
                            <strong>Date and Time:</strong> {log.datetime}<br />
                            <strong>User:</strong> {log.user}<br />
                            <strong>Channels:</strong> {log.channel.join(', ')}<br />
                            <strong>Category:</strong> {log.category}<br />
                            <strong>Message:</strong> {log.message}<br />
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default NotificationLogs;

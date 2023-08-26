import React, { useState, useEffect } from 'react';
import axios from 'axios';

const SubmissionForm = () => {
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState('');
  const [message, setMessage] = useState('');
  const [logHistory, setLogHistory] = useState([]);

  // Fetch available categories on component mount
  useEffect(() => {
    axios.get('http://localhost:8080/categories')
      .then(response => {
        setCategories(response.data.categories);
      })
      .catch(error => {
        console.error('Error fetching categories:', error);
      });
  }, []);

  // Fetch log history on component mount
  useEffect(() => {
    axios.get('http://localhost:8080/log/history')
      .then(response => {
        setLogHistory(response.data);
      })
      .catch(error => {
        console.error('Error fetching log history:', error);
      });
  }, []);

  const handleSubmit = (event) => {
    event.preventDefault();

    if (message.trim() === '') {
      alert('Message cannot be empty');
      return;
    }

    const newLogEntry = {
      user: 'anyname',
      date: new Date().toISOString().split('T')[0],
      category: selectedCategory,
      sent: true,
    };

    // Assuming you have an API endpoint to save log entries
    axios.post('http://localhost:8080/log', newLogEntry)
      .then(response => {
        setLogHistory([...logHistory, newLogEntry]);
      })
      .catch(error => {
        console.error('Error adding log entry:', error);
      });
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>
          Category:
          <select value={selectedCategory} onChange={e => setSelectedCategory(e.target.value)}>
            <option value="">Select a category</option>
            {categories.map(category => (
              <option key={category} value={category}>{category}</option>
            ))}
          </select>
        </label>
        <br />
        <label>
          Message:
          <textarea value={message} onChange={e => setMessage(e.target.value)} />
        </label>
        <br />
        <button type="submit">Submit</button>
      </form>

      <h2>Log History:</h2>
      <ul>
        {logHistory.map((entry, index) => (
          <li key={index}>
            User: {entry.user} | Date: {entry.date} | Category: {entry.category} | Sent: {entry.sent.toString()}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default SubmissionForm;

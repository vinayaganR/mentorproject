// src/components/Login.js
import React, { useState } from 'react';
import { loginStudent } from '../services/studentService';

const Login = () => {
  const [kuId, setKuId] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');

  const handleLogin = async () => {
    try {
      const response = await loginStudent({ kuId, password });
      setMessage(response.data); // assuming backend sends a plain string message
    } catch (error) {
      if (error.response && error.response.status === 401) {
        setMessage('Invalid credentials');
      } else {
        setMessage('Login failed. Try again later.');
      }
    }
  };

  return (
    <div>
      <h2>Student Login</h2>
      <input
        type="text"
        placeholder="KU ID"
        value={kuId}
        onChange={(e) => setKuId(e.target.value)}
      />
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <button onClick={handleLogin}>Login</button>
      <p>{message}</p>
    </div>
  );
};

export default Login;

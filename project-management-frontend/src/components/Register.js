// src/components/Register.js
import React, { useState } from 'react';
import { registerStudent } from '../services/studentService';

const Register = () => {
  const [kuId, setKuId] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');

  const handleRegister = async () => {
    try {
      const response = await registerStudent({ kuId, password });
      setMessage(response.data);
    } catch (error) {
      setMessage(error.response?.data || 'Registration failed');
    }
  };

  return (
    <div>
      <h2>Register Student</h2>
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
      <button onClick={handleRegister}>Register</button>
      <p>{message}</p>
    </div>
  );
};

export default Register;

// src/services/studentService.js
import axios from 'axios';
import BASE_URL from './api'; // Make sure BASE_URL = "http://localhost:8080"

export const registerStudent = async (student) => {
  // POST request to register a student
  return axios.post(`${BASE_URL}/students/register`, student);
};

export const loginStudent = async (student) => {
  // POST request to login student
  return axios.post(`${BASE_URL}/students/login`, student);
};

export const updatePassword = async (kuId, newPassword) => {
  // PUT request to update password
  return axios.put(`${BASE_URL}/students/update-password/${kuId}`, {
    newPassword: newPassword,
  });
};

export const deleteStudent = async (kuId) => {
  // DELETE request to remove student by kuId
  return axios.delete(`${BASE_URL}/students/delete/${kuId}`);
};

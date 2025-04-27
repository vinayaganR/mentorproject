import axios from 'axios';

const BASE_URL = 'http://localhost:8080/mentors';

export const registerMentor = (mentorData) => {
  return axios.post(`${BASE_URL}/register`, mentorData);
};

export const loginMentor = (mentorData) => {
  return axios.post(`${BASE_URL}/login`, mentorData);
};

export const getMentorById = (id) => {
  return axios.get(`${BASE_URL}/${id}`);
};

export const updateMentor = (id, updatedData) => {
  return axios.put(`${BASE_URL}/${id}`, updatedData);
};

export const deleteMentor = (id) => {
  return axios.delete(`${BASE_URL}/${id}`);
};

export const getAllMentors = () => {
  return axios.get(BASE_URL);
};

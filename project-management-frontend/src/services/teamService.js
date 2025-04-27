import axios from './api';

export const createTeam = (data) => {
    return axios.post('/api/team/create', data);
};

export const assignMentor = (data) => {
    return axios.post('/api/team/assign-mentor', data);
};

export const getTeamByStudentId = (studentId) => {
    return axios.get(`/api/team/student/${studentId}`);
};

const teamService = {
    createTeam,
    assignMentor,
    getTeamByStudentId
};

export default teamService;
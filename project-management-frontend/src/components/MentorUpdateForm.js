import React, { useState } from "react";
import axios from "axios";

const MentorUpdateForm = () => {
  const [formData, setFormData] = useState({
    id: "", // mentor DB ID
    mentorId: "",
    password: "",
    maxSlots: "",
    usedSlots: ""
  });

  const handleChange = (e) => {
    setFormData({...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const { id, ...updateData } = formData;
      const res = await axios.put(`http://localhost:8080/mentors/${id}`, updateData);
      alert(res.data);
    } catch (err) {
      console.error(err);
      alert("Update failed. Check console.");
    }
  };

  return (
    <div>
      <h2>Update Mentor</h2>
      <form onSubmit={handleSubmit}>
        <input name="id" placeholder="Mentor DB ID" onChange={handleChange} required /><br />
        <input name="mentorId" placeholder="Mentor ID" onChange={handleChange} required /><br />
        <input name="password" placeholder="Password" type="password" onChange={handleChange} required /><br />
        <input name="maxSlots" placeholder="Max Slots" type="number" onChange={handleChange} required /><br />
        <input name="usedSlots" placeholder="Used Slots" type="number" onChange={handleChange} required /><br />
        <button type="submit">Update</button>
      </form>
    </div>
  );
};

export default MentorUpdateForm;

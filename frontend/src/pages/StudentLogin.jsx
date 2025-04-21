import React from "react";

const StudentLogin = () => {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100">
      <h2 className="text-2xl font-bold mb-4">Student Login</h2>
      <input
        type="email"
        placeholder="Email"
        className="border p-2 rounded mb-2 w-64"
      />
      <input
        type="password"
        placeholder="Password"
        className="border p-2 rounded mb-2 w-64"
      />
      <button className="bg-blue-500 text-white px-4 py-2 rounded">Login</button>
    </div>
  );
};

export default StudentLogin;

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Login({ setUsername }) {
  const [name, setName] = useState('');
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    if (name.trim()) {
      setUsername(name);
      navigate('/chat');
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <form onSubmit={handleSubmit}>
        <input
          placeholder="Enter username"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <button type="submit">Enter Chat</button>
      </form>
    </div>
  );
}

export default Login;

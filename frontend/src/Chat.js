import React, { useState } from 'react';

function Chat({ username }) {
  const [input, setInput] = useState('');
  const [messages, setMessages] = useState([]);

  const sendMessage = async () => {
    if (!input.trim()) return;
    
    const userMessage = { from: 'You', text: input };
    setMessages((prev) => [...prev, userMessage]);

    try {
      const res = await fetch('/api/chat', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, message: input }),
      });
      const data = await res.json();
      setMessages((prev) => [...prev, { from: 'Bot', text: data.reply }]);
    } catch (err) {
      console.error(err);
      setMessages((prev) => [...prev, { from: 'Bot', text: 'Error contacting API.' }]);
    }

    setInput('');
  };

  return (
    <div>
      <h2>Chat with Bot</h2>
      <div style={{ border: '1px solid #ccc', padding: '10px', height: '200px', overflowY: 'scroll' }}>
        {messages.map((msg, i) => (
          <p key={i}><strong>{msg.from}:</strong> {msg.text}</p>
        ))}
      </div>
      <input
        value={input}
        onChange={(e) => setInput(e.target.value)}
        placeholder="Type your message..."
        onKeyDown={(e) => e.key === 'Enter' && sendMessage()}
      />
      <button onClick={sendMessage}>Send</button>
    </div>
  );
}

export default Chat;
    
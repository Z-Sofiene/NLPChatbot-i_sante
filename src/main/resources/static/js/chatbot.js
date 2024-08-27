function sendMessage() {
    const userInput = document.getElementById('user-input').value;
    document.getElementById('user-input').value = '';

    if (userInput.trim() !== '') {
        const chatBox = document.getElementById('chat-box');
        chatBox.innerHTML += '<div><strong>You:</strong> ' + userInput + '</div>';

        // Send the message to the chatbot API
        fetch('http://localhost:10000/api/chatbot', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ message: userInput })
        })
        .then(response => response.json())
        .then(data => {
            chatBox.innerHTML += '<div><strong>Chatbot:</strong> ' + data.response + '</div>';
            chatBox.scrollTop = chatBox.scrollHeight; // Scroll to the bottom
        })
        .catch(error => console.error('Error:', error));
    }
}

// JavaScript to handle the chatbot communication
document.addEventListener("DOMContentLoaded", function () {
    const chatBox = document.getElementById('chat-box');
    const userInput = document.getElementById('user-input');
    const sendBtn = document.getElementById('send-btn');

    // Function to append a message to the chatbox
    function appendMessage(message, isUser = true) {
        const messageDiv = document.createElement('div');
        messageDiv.classList.add(isUser ? 'user-message' : 'bot-message');
        messageDiv.textContent = message;
        chatBox.appendChild(messageDiv);
        chatBox.scrollTop = chatBox.scrollHeight; // Scroll to the bottom
    }

    // Send message to the backend and display the bot's response
    function sendMessage() {
        const message = userInput.value.trim();
        if (message === "") return; // Don't send empty messages

        // Display the user's message
        appendMessage(message, true);

        // Clear the input field
        userInput.value = "";

        // Make an AJAX POST request to send the message to the backend
        fetch('/api/chatbot/ask', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(message)
        })
            .then(response => response.text()) // Parse the response as text
            .then(data => {
                // Display the bot's response
                appendMessage(data, false);
            })
            .catch(error => {
                console.error('Error:', error);
                appendMessage('Sorry, something went wrong.', false);
            });
    }

    // Add event listener to send message on button click
    sendBtn.addEventListener('click', sendMessage);

    // Send message when pressing Enter in the input field
    userInput.addEventListener('keyup', function (event) {
        if (event.key === 'Enter') {
            sendMessage();
        }
    });
});
